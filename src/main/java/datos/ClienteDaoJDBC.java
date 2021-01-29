package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.*;

public class ClienteDaoJDBC {

    private static final String SQL_SELECT ="SELECT " + 
                                                        "id_cliente, " + 
                                                        "nombre, " + 
                                                        "apellido, " + 
                                                        "email, " + 
                                                        "telefono, " + 
                                                        "saldo " + 
                                            "FROM " + 
                                                        "cliente";
    
    private static final String SQL_SELECT_BY_ID = "SELECT " + 
                                                            "id_cliente, " + 
                                                            "nombre, " + 
                                                            "apellido, " + 
                                                            "email, " + 
                                                            "telefono, " + 
                                                            "saldo " + 
                                                   "FROM " + 
                                                            "cliente " + 
                                                   "WHERE " + 
                                                            "id_cliente = ?";
    
    private static final String SQL_INSERT ="INSERT INTO cliente " + 
                                                        "(nombre, " + 
                                                        "apellido, " + 
                                                        "email, " + 
                                                        "telefono, " + 
                                                        "saldo) " + 
                                            "VALUES " + 
                                                        "(?, ?, ?, ?, ?)";
    
    private static final String SQL_UPDATE ="UPDATE " + 
                                                        "cliente " + 
                                            "SET " + 
                                                        "nombre = ?, " + 
                                                        "apellido = ?, " +
                                                        "email = ?, " +
                                                        "telefono = ?, " + 
                                                        "saldo = ? " + 
                                            "WHERE "  +
                                                        "id_cliente = ?";
    
    private static final String SQL_DELETE ="DELETE FROM " + 
                                                        "cliente " +
                                            "WHERE " + 
                                                        "id_cliente = ?";
    
    /*
    Metodo el cual regresara una lista de tipo Cliente, este metodo se va a conectar a la BD
    va a ejecutar la sentencia de listar todos los objetos de tipo cliente y va a regresar dicha lista
    */
    public List<Cliente> listar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            //Iniciamos la conexion
            conn = Conexion.getConnection();
            //Inicamos el objeto Statement
            stmt = conn.prepareStatement(SQL_SELECT);
            //Ejecutamos el query y lo asignamos a la variable resultSet
            rs = stmt.executeQuery();
            //Iteramos cada uno de los elemntos del ResultSet
            while(rs.next()){
                //Recuperamos cada una de las columnas del registro que se esta iternado en ese momento
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");
                
                //creamos un objeto de tipo Cliente
                cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
                //Agregamos el cliente al listado de clientes
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //Cerramos el ResultSet, PrepareStatment y la Conexion
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return clientes;        
    }
    
    
    //Metodo para encontrar un objeto de tipo Cliente, solamente un objeto
    public Cliente encontrar(Cliente cliente){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            //Iniciamos la conexion
            conn = Conexion.getConnection();
            //Inicamos el objeto Statement
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            //Para ejecutar la sentencia SQL, necesitamos proporcionar el parametro que se va a utilizar en la sentencia
            stmt.setInt(1, cliente.getIdCliente());
            //Ejecutamos el query y lo asignamos a la variable resultSet
            rs = stmt.executeQuery();
            /*
            Para posicionarnos en el registro en dado caso de que este haya sido devuelto un valor,
            utilizamos el metodo next, ya que este avanza a la primer fila de los registros encontrados en este caso solo uno
            */
            rs.next(); //Nos posiciona en el primer registro devuelto
            
            //Una vez que nos posicionamos en ese registro, recuperamos los elementos, ha excepcion del idCliente
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            double saldo = rs.getDouble("saldo");

            //Modificamos cada unos de los valores sobre el objeto Cliente que ya tenemos
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setSaldo(saldo);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //Cerramos el ResultSet, PrepareStatment y la Conexion
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cliente;
    }
    
    
    //Metodo para INSERTAR un objeto de tipo Cliente, regresando un INT indicando el numero de registros afectados
    public int insertar(Cliente cliente){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        /*
        En este caso no se utiliza el ResultSet ya que ahora no vamos a recuperar informacion, si 
        no que ahora se va a insertar
        */  
        
        try {
            //Iniciamos la conexion
            conn = Conexion.getConnection();
            //Inicamos el objeto Statement
            stmt = conn.prepareStatement(SQL_INSERT);
            //Proporcionamos cada uno de los parametros que se van a utilizar en la sentencia SQL
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            //Ejecutamos el Query y lo almacenas en una variable para conocer la cantidad de registros modificados
            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //Cerramos el PrepareStatment y la Conexion
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    
    //Metodo para ACTUALIZAR un objeto de tipo Cliente, regresando un INT indicando el numero de registros afectados
    public int actualizar(Cliente cliente){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        /*
        En este caso no se utiliza el ResultSet ya que ahora no vamos a recuperar informacion, si 
        no que ahora se va a actualizar
        */     
        
        try {
            //Iniciamos la conexion
            conn = Conexion.getConnection();
            //Inicamos el objeto Statement
            stmt = conn.prepareStatement(SQL_UPDATE);
            //Proporcionamos cada uno de los parametros que se van a utilizar en la sentencia SQL
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setInt(6, cliente.getIdCliente());
            //Ejecutamos el Query y lo almacenas en una variable para conocer la cantidad de registros modificados
            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //Cerramos el PrepareStatment y la Conexion
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;        
    }
    
    
    //Metodo para ELIMINAR un objeto de tipo Cliente
    public int eliminar(Cliente cliente){
        
        Connection conn = null; 
        PreparedStatement stmt = null; 
        int rows = 0;         
        /*
        En este caso no se utiliza el ResultSet ya que ahora no vamos a recuperar informacion, si
        no que ahora se va a actualizar(eliminar)
        */
        
        try {             
            //Iniciamos la conexion
            conn = Conexion.getConnection();
            //Iniciamos el objeto Statemnet
            stmt = conn.prepareStatement(SQL_DELETE);
            //Proporcionamos cada uno de los parametros que se van a utilizar en la sentencia SQL
            stmt.setInt(1, cliente.getIdCliente());
            //Ejecutamos el Query y lo almacenas en una variable para conocer la cantidad de registros modificados
            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //Cerramos el PrepareStatement y la Conexion
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;        
    }
    
}
