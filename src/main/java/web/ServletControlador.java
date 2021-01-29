package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ClienteControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Para la accion EDITAR un cliente
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
                default:
                    //En este caso vamos a redirigir a la pagina de inicio
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Recuperamos el idCliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        //Con el parametro de idCliente, recuperamos el objeto cliente de la BD
        Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente));
        //Este objeto se pone en algun alcance
        request.setAttribute("cliente", cliente);
        //Definimos la pagina JSP que vamos a utilizar
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

    }
    
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        //Recuperamos el idCliente del cliente a eliminar
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        
        //Creamos un objeto Cliente (modelo)
        Cliente cliente = new Cliente(idCliente);
        
        //Eliminamos el cliente de la Base de Datos
        int registrosModificados = new ClienteDaoJDBC().eliminar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);
        
        //Volvemos a mostrar el listado de clientes actualizado
        this.accionDefault(request, response);
        
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                default:
                    //En este caso vamos a redirigir a la pagina de inicio
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }

    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Recuperamos los valores del formulario agregarCliente
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        //Como el metodo getParameter regresa un String, aplicamos la siguiente validacion
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }

        //Creamos el objeto de Cliente (modelo), hace las veces del modelo en el patron MVC
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);

        //Insertamos el nuevo objeto de cliente en la Base de Datos 
        int registrosModificados = new ClienteDaoJDBC().insertar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

        //Una vez guardada la informacion en la BD redirigimos hacia la aciion por default 
        this.accionDefault(request, response);

    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Recuperamos los valores del formulario editarCliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        //Como el metodo getParameter regresa un String, aplicamos la siguiente validacion
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }

        //Creamos el objeto de Cliente (modelo), hace las veces del modelo en el patron MVC
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);

        //Insertamos el nuevo objeto de cliente en la Base de Datos 
        int registrosModificados = new ClienteDaoJDBC().actualizar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

        //Una vez guardada la informacion en la BD redirigimos hacia la aciion por default 
        this.accionDefault(request, response);

    }

}
