<%-- 
    Document   : Regisrar_Productos
    Created on : 23-jun-2020, 21:58:23
    Author     : Ely
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <form action="Controlador" method="POST"> 
                <input type="submit" name="accion" value="Listar" class="btn btn-success">
                <input type="submit" name="accion" value="Nuevo" class="btn btn-success">
                
            </form>
            <hr>
                    <table >
                        <thead>
                            <tr>
                                <th>ID Producto</th>
                                <th>Nombre</th>
                                <th>Foto</th>
                                <th>Descripcion</th>
                                <th>Precio</th>
                                <th>Stock</th>
                               
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dato" items="${lista}">
                             <tr>
                                <td>${dato.getId()}</td>
                                <td>${dato.getNombres()}</td>
                                <td><img src="Controlador_Imagenes?id=${dato.getId()}" width="100" height="100"></td>
                                <td>${dato.getDescripcion()}</td>
                                <td>${dato.getPrecio()}</td>
                                <td>${dato.getStock()}</td>
                                <td>
                                   <%-- <form action="Controlador" method="POST"> 
                                        <input type="submit" name="accion" value="Editar" class="btn btn-success">
                                        <input type="submit" name="accion" value="Borrar" class="btn btn-success">
                                        --%>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                           
                        </tbody>
                    </table>
              
        </div>
    </center>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
