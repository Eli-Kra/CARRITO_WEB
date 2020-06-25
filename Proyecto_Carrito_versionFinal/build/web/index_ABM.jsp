<%-- 
    Document   : index_ABM
    Created on : 22-jun-2020, 17:04:41
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
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <a class="navbar-brand" href="#">Carrito Web</a>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item active">
                                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="index_catalogo.jsp">Volver</a>
                            </li>
                            <li class="nav-item">
                                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Regisrar_Productos.jsp" target="myFrame">Producto</a>
                            </li>
                             
                            <li class="nav-item">
                                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador_crud?menu=Clientes&accion=Listar_Clientes" target="myFrame">Cliente</a>
                            </li>
                            <li class="nav-item">
                                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador_crud?menu=NuevaVenta&accion=BuscarCliente" target="myFrame">Nueva Venta</a>
                            </li>
                        </ul>
                        
                        <div class="dropdown">
                            <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                     ${usuario.getNombre()}
                                </button>
                                    <div class="dropdown-menu text-center">
                                        <a class="dropdown-item" href="#">
                                            <img src="img_login/usuario.jpg" alt="30" width="30"/>
                                        </a>
                                        <a class="dropdown-item" href="#">${usuario.getId()}</a>
                                        <a class="dropdown-item" href="#">Usuario@gmail.com</a>
                                        <div class="dropdown-divider"></div>
                                        <form action="Validar_abm" method="POST">
                                            <button name="accion" value="Salir" class="dropdown-item" href="index.jsp">Salir</button>
                                        </form>
                                        
                                    </div>
                        </div>
                </div>
        </nav>
        
       <div class="m-4" style="height: 550px;">
           <iframe name="myFrame" style="height: 100%; width: 100%; border: none" ></iframe>                            
        </div>
        
        
        
     <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
