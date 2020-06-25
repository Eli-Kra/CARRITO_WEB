<%-- 
    este archivo jsp nos permitira dise;ar
el formulario para registrar a nuevos clients
en la base de datos utilizando un marco de trabajo
de bootstrap por ello importamos todas las herramientas
del mismo css, y cdn
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
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body">
                    <form action="Controlador_crud?menu=Clientes" method="POST">
                        <div class="form-group">
                            <label>Num.Documemto:</label>
                            <input type="text" value="${cliente1.getNum_documento()}" name="txtDoc" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre y Apellido:</label>
                            <input type="text" value="${cliente1.getNombre()}" name="txtNom" class="form-control">
                        </div>  
                        <div class="form-group">
                            <label>Dirección:</label>
                            <input type="text" value="${cliente1.getDireccion()}" name="txtDir" class="form-control">
                        </div>  
                        <div class="form-group">
                            <label>Email:</label>
                            <input type="text" value="${cliente1.getCorreo()}" name="txtEmail" class="form-control">
                        </div>  
                        <div class="form-group">
                            <label>Password:</label>
                            <input type="password" value="${cliente1.getPassword()}" name="txtPass" class="form-control">
                        </div>
                            <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                            <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
            </div>
        </div>
            <div class="col-sm-9">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <td>Id.Cliente</td>
                        <th>Num.Doc.</th>
                        <th>Nombre y Apellido</th>
                        <th>Dirección</th>
                        <th>Email</th>
                        <th>Password</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cli" items="${clientes}">
                    <tr>
                        <td>${cli.getId()}</td>
                        <td>${cli.getNum_documento()}</td>
                        <td>${cli.getNombre()}</td>
                        <td>${cli.getDireccion()}</td>
                        <td>${cli.getCorreo()}</td>
                        <td>${cli.getPassword()}</td>
                        <td>
                            <a class="btn btn-warning" href="Controlador_crud?menu=Clientes&accion=Editar&id=${cli.getId()}">Editar</a>
                            <a class="btn btn-danger" href="Controlador_crud?menu=Clientes&accion=Delete&id=${cli.getId()}">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
                    
                </tbody>
            </table>

        </div>
        
        </div>
  
        
        
        
        
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
