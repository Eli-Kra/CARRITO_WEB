<%-- 
   en este archivo realizaremos los registros de las ventas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VENTAS</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">  
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-5">
                <div class="card">
                    <form action="Controlador_crud?menu=NuevaVenta" method="POST">
                    <div class="card-body">
                        <div class="form-group">
                            
                             <%-- DATOS DEL CLIENTE --%>     
                            <label>Datos del Cliente</label>
                            
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="codigocliente" value="${c.getNum_documento()}" class="form-control" placeholder="Codigo" >
                            .   <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nombrescliente" value="${c.getNombre()}" placeholder="Datos Cliente" class="form-control">
                            </div> 
                        </div>
                            
                                <%-- DATOS DEL PRODUCTO --%>     
                            
                            
                        <div class="form-group">
                            <label>Datos Producto:</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="codigoproducto" value="${producto.getId()}" class="form-control" placeholder="Codigo" >
                                .   <input type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nombreproducto" value="${producto.getNombres()}" placeholder="Datos Producto" class="form-control">
                            </div> 
                            
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="Usd/.0.00" >
                            </div>
                             <div class="col-sm-3 d-flex">
                                <input type="number"  value="1" name="cantidad" placeholder="" class="form-control">
                            </div>
                             <div class="col-sm-3 d-flex">
                                 <input type="text" name="stock" value="${producto.getStock()}" placeholder="Stock" class="form-control">
                            </div>
                        </div>
                        <%-- AGREGAR PRODUCTO AL REGISTRO DE VENTA --%>   
                        <div class="form-group">
                            <input type="submit" name="accion" value="Agregar" class=" btn btn-outline-info">
                        </div>
                    </div>
                </form>
            </div>
                
        </div>
        <div class="col-sm-7">
            <div class="card">
                <div class="card-body">
                    <div class="d-flex col-sm-6 ml-auto">
                        <label>NumeroSerie</label>
                        <input type="text" name="NroSerie" class="form-control">
                    </div> 
                    <br>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Item</th>
                                <th>Codigo</th>
                                <th>Nombre</th>
                                <th>Precio</th>
                                <th>Cantidad</th>
                                <th>SubTotal</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="list" items="${lista}">
                            <tr>
                                <td>${list.getItem()}</td>
                                <td>${list.getId()}</td>
                                <td>${list.getDescripcionp()}</td>
                                <td>${list.getPrecio()}</td>
                                <td>${list.getCantidad()}</td>
                                <td>${list.getSubtotal()}</td>
                                <td>
                                    <a href="#" class="btn btn-warning">Editar</a>
                                    <a href="#" class="btn btn-danger">Delete</a>
                                </td>
                            </tr>
                            
                        </c:forEach>
                            
                        </tbody>
                    </table>

                </div>
                <div class="card-footer d-flex">
                    <div class="col-sm-6">
                        <input type="submit" name="accion" value="Generar Venta" class="btn btn-success">
                        <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                    </div>
                   
                </div>
                <div class="col-sm-4 ml-auto">
                    <input type="text" name="txtTotal" value="S/. ${totalpagar}" class="form-control">
                </div>
                
            </div>
            
       </div>
            
        </div>
            
        
        
   <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="js/funciones.js" type="text/javascript"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

  </body>
    
</html>
