<%-- 
    Document   : agregarProductos
    Created on : 23-jun-2020, 23:06:47
    Author     : Ely
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">  
    </head>
    <body>
    <center>
        <div>
            <h3>Agregar nuevo Producto</h3>
        </div>
        <hr>
        <br>
        <form action="Controlador" method="POST" enctype="multipart/form-data">
            <label>Nombre:</label>
            <input type="text" name="txtNom">
            <label>Foto:</label>
            <input type="file" name="fileFoto">
            <label>Descripcion</label>
            <input type="text" name="txtDes">
            <label>Precio:</label>
            <input type="number" name="txtPrecio">
            <label>Stock:</label>
            <input type="text" name="txtStock">
            
            <input type="submit" name="accion" value="Guardar">
            <input type="submit" name="accion" value="Regresar">
                
        </form>
    </center>
        
        
      <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
