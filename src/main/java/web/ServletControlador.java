package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ListarClientes")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        this.accionDefault(request, response);
        
    }
    
    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("clientes = " + clientes);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalClientes", clientes.size());
        sesion.setAttribute("saldoTotal", this.calcularTotalSaldo(clientes));
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        
        //El metodo senRedirect vuelve a hacer una llamada GET al servidor para notificar un cambio de JSP
        response.sendRedirect("clientes.jsp");
    }

    private double calcularTotalSaldo(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal = saldoTotal + cliente.getSaldo();
        }
        return saldoTotal;
    }
    
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String accion = request.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                default:
                    //En este caso vamos a redirigir a la pagina de inicio
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
        
    }
    
    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        //Recuperamos los valores del formulario agregarCliente
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0; 
        //Como el metodo getParameter regresa un String, aplicamos la siguiente validacion
        String saldoString = request.getParameter("saldo");
        if(saldoString != null && !"".equals(saldoString)){
            saldo = Double.parseDouble(saldoString);
        }
        
        //Creamos el objeto de Cliente (modelo), hace las veces del modelo en el patron MVC
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
        
        //Insertamos el nuevo objeto de cliente en la Base de Datos 
        int registrosModificados = new ClienteDaoJDBC().insertar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);
        
        //Una vez guradada la informacion en la BD redirigimos hacia la aciion por default 
        this.accionDefault(request, response);
        
    }

}
