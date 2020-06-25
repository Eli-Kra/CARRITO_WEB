<%-- 
    en este jsp, haremos el diseno de la pantalla para registrar
 nuevos productos en la base de datos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container mt-4">
            <form action="Controlador?accion=Guardar" class="col-md-6" method="POST" enctype="multipart/form-data">
                <div class="card">
                    <div class="card-header">
                        <h3>
                            AGREGAR NUEVO PRODUCTO
                        </h3>
                    </div>
                    <div class="card-body">
                        <div class="form-group">
                            <label>Nombre:</label>
                            <input type="text" name="txtNombre" class="form-control">
                            <label>Descripción:</label>
                            <input type="text" name="txtDesc" class="form-control">
                            <label>Precio:</label>
                            <input type="text" name="txtPrecio" class="form-control">
                            <label>Stock:</label>
                            <input type="text" name="txtStock" class="form-control">
                            
                        </div>
                        <div class="form-group">
                            <label>Imagen:</label>
                            <input type="file" name="fileImagen">
                        </div>
                    
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-outline-primary" name="accion" value="Guardar" >Guardar Producto</button>
                    </div>
                </div>
            </form>
        </div>
   
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
 </body>
</html>