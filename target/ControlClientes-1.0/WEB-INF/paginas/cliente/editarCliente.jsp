<%-- 
    Document   : clientes
    Created on : 28 ene. 2021, 14:24:45
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
        <title>Editar Cliente</title>
    </head>
    <body>
        <!-- Cabecero TOP -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp" />
        <!-- Cabecero DOWN -->

        <!-- Botones Navegacion Edicion TOP -->
        <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionSuperiorEdicion.jsp" />
        <!-- Botones Navegacion Edicion DOWN -->

        <form action="${pageContext.request.contextPath}/ClienteControlador?accion=modificar" method="post" class="was-validated">
            <input type="hidden" name="idCliente" value="${cliente.idCliente}">
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Cliente</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>                        
                                        <input type="text" class="form-control" name="nombre" required value="${cliente.nombre}">
                                    </div>
                                    <div class="form-group">
                                        <label for="apellido">Apellido</label>                        
                                        <input type="text" class="form-control" name="apellido" required value="${cliente.apellido}">
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email</label>  
                                        <input type="email" class="form-control" name="email" required pattern="[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}" value="${cliente.email}">
                                    </div>
                                    <div class="form-group">
                                        <label for="telefono">Tel&eacute;fono</label>                        
                                        <input type="tel" class="form-control" name="telefono" required value="${cliente.telefono}">
                                    </div>
                                    <div class="form-group">
                                        <label for="saldo">Saldo</label>                        
                                        <input type="number" class="form-control" name="saldo" required value="${cliente.saldo}" step="any">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!--Botones de Confirmacion TOP-->
            <jsp:include page="/WEB-INF/paginas/comunes/botonesEdicionCliente.jsp" />
            <!--Botones de Confirmacion DOWN-->
        </form>



        <!-- Pie de pagina TOP -->
        <jsp:include page="/WEB-INF/paginas/comunes/pieDePagina.jsp" />
        <!-- Pie de pagina DOWN -->


        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
    </body>
</html>
