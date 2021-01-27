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

        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("clientes = " + clientes);
        request.setAttribute("clientes", clientes);
        request.setAttribute("totalClientes", clientes.size());
        request.setAttribute("saldoTotal", this.calcularTotalSaldo(clientes));
        request.getRequestDispatcher("clientes.jsp").forward(request, response);

    }

    private double calcularTotalSaldo(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal = saldoTotal + cliente.getSaldo();
        }
        return saldoTotal;
    }

}
