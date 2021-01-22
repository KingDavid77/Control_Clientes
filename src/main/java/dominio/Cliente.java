package dominio;

public class Cliente {
    
    //Mapeamos cada una de las columnas de la BD, de la tabla Cliente
    private int idCliente;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private double saldo;
    
    //Constructores
    public Cliente(){
        
    }    
    //Para eliminar un cliente
    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }
    //Para insertar un nuevo cliente
    public Cliente(String nombre, String apellido, String email, String telefono, double saldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }
    //Para modificar un cliente existente
    public Cliente(int idCliente, String nombre, String apellido, String email, String telefono, double saldo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }
    
    
    //Metodo getters & setters

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    //Metodo toString

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + this.idCliente + ", nombre=" + this.nombre + ", apellido=" + this.apellido + ", email=" + this.email + ", telefono=" + this.telefono + ", saldo=" + this.saldo + '}';
    }
    
    
    
    
}
