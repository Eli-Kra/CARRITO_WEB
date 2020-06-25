<%-- 
    en esta pagina haremos el diseno de la vista del catalogo con las opciones superiores para que el cliente pueda hacer las compras
    y ver los productos- utilizaremos una plantilla pre programada que nos proporciona bootstrap

importamos los estilos y scripts del marco de trabajo bootstrap
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
        
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Tienda Online</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="Controlador?accion=home">VER CATALOGO</a>
                               
                            </li>
                             <li class="nav-item active">
                                <a class="nav-link" href="index_ABM.jsp">ABM-Sitio</a>
                               
                            </li>
                                                      
                            <li class="nav-item">
                                <a class="nav-link disabled" href="Controlador?accion=Carrito"><svg class="bi bi-cart-plus" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                               <path fill-rule="evenodd" d="M8.5 5a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1H8V5.5a.5.5 0 0 1 .5-.5z"/>
                                <path fill-rule="evenodd" d="M8 7.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1H9v1.5a.5.5 0 0 1-1 0v-2z"/>
                                <path fill-rule="evenodd" d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm7 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"/> 
                                </svg><i class="fas fas-cart-plus">(<label style="color: deeppink">${contador}</label>)</i>Carrito</a>
                                
                            </li>
                        </ul>
                                <li class="nav-item">
                               <a class="nav-link" href="index.jsp">Salir del Sitio</a> 
                            </li> 
                      
                            
                       
                        <ul class="navbar-nav"> 
                        <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    ${usuario.getNombre()}
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="#">${usuario.getId()}</a>
                                    <a class="dropdown-item" href="#">usuario@gmail.com</a>
                                        <div class="dropdown-divider"></div>
                                        <form action="Validar" method="POST">
                                            <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                                            
                                        </form>
                                </div>
                        </li>
                        </ul>
                                
                    </div>
        </nav>
    
   
    <%-- en esta seccion realizaremo la codificacion para mostrar las imagenes cargadas en la base de datos
    que corresponderian a los electrodomesticos, de nuestro catalogo utilizamos un bucle forEach--%>
        
        <div class="container mt-4">
            <div class="row"><br>
                <c:forEach var="p" items="${productos}"><br>
                    <div class="col-sm-6">
                        <div class="card">
                            <div class="card-header color bg-red">
                                <h4 class="text-center">${p.getNombres()}</h4>
                            </div>
                            <div class="card-body">
                                <i>USD. ${p.getPrecio()}</i>
                                    <img src="Controlador_Imagenes?id=${p.getId()}" width="300" height="300" >
                            </div>
                            <div class="card-footer text-center">
                                <label>${p.getDescripcion()}</label>
                                <div>
                                    <a href="Controlador?accion=AgregarCarrito&id=${p.getId()}" class="btn btn-outline-info">Agregar al carrito</a>
                                    <a href="Controlador?accion=Comprar&id=${p.getId()}" class="btn btn-warning">Comprar</a>
                                </div>
                            </div>
                                <br>
                        </div>
                    </div>
                </c:forEach>  
            </div>
        </div>
   <%-- 
    <div  class="m-4" style="height: 550px;">
        <iframe name="myFrame" style="height: 100%; width: 100%"></iframe>
    </div>
 --%>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
