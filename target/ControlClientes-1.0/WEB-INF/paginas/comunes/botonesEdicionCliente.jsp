<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">                
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i>&nbsp;&nbsp;Actualizar Cliente
                </button>
            </div>            
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ClienteControlador?accion=eliminar&idCliente=${cliente.idCliente}" class="btn btn-danger btn-block">
                    <i class="fas fa-trash"></i>&nbsp;&nbsp;Eliminar Cliente
                </a>
            </div>            
        </div>
    </div>
</section>
