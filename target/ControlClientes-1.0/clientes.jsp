<%-- 
    Document   : clientes
    Created on : 25 ene. 2021, 18:26:29
    Author     : toluc
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <!-- Font Awesome -->
        <script src="https://kit.fontawesome.com/34ebfdeb8e.js" crossorigin="anonymous"></script>
        <title>Control de Clientes</title>
    </head>
    <body>
        <!-- Cabecero TOP -->
        <jsp:include page="WEB-INF/paginas/comunes/cabecero.jsp" />
        <!-- Cabecero DOWN -->
        
        <!-- Botones de navegación TOP -->
        <jsp:include page="WEB-INF/paginas/comunes/botonesNavegacion.jsp" />        
        <!-- Botones de navegación DOWN -->
        
        <ul>
            <c:forEach var="cliente" items="${clientes}">
                <li> ${cliente.idCliente} ${cliente.nombre} ${cliente.apellido} ${cliente.saldo} </li>
            </c:forEach>
        </ul>
        
        <!-- Pie de pagina TOP -->
        <jsp:include page="WEB-INF/paginas/comunes/pieDePagina.jsp" />
        <!-- Pie de pagina DOWN -->
        
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
    </body>
</html>
