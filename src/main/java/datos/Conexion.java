package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_clientes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin1234";
    
    //Metodo que recupera una conexion a la BD
    public static DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(JDBC_USER);
        dataSource.setPassword(JDBC_PASSWORD);
        //Definimos el tamaño inicial de Pool de Conexiones
        dataSource.setInitialSize(50);
        return dataSource;
    }
    
    
    //Metodo para obtener una conexion 
    public static Connection getConnection() throws SQLException{
        
        //Obtenemos una conexion hacia la BD obtenida a partir del pool de Conexiones 
        return getDataSource().getConnection();
    }
    
    
    //Metodos para cerrar el PrepareStatment, ResultSet y Conexion
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}
