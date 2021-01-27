<%-- 
    Document   : clientes
    Created on : 25 ene. 2021, 18:26:29
    Author     : toluc
--%>


<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
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

        <!-- Listado de Clientes TOP -->
        <jsp:include page="WEB-INF/paginas/cliente/listadoClientes.jsp" />
        <!-- Listado de Clientes DOWN -->

        <!-- Pie de pagina TOP -->
        <jsp:include page="WEB-INF/paginas/comunes/pieDePagina.jsp" />
        <!-- Pie de pagina DOWN -->


        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
    </body>
</html>
