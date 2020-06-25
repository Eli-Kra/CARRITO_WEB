<%-- 
    Document   : Listado_Clientes
    Created on : 19-jun-2020, 16:37:25
    Author     : Ely

en esta pagina jsp, listaremos los registros de la base de datos en 
    la tabla clientes
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <%--AQUI CREAMOS UNA TABLA CON LAS CABEZERAS PARA REPRESENTAR LOS DATOS 
        DE LA TABLA CLIENTES QUE ESTA EN LA BASE DE DATOS ELECTRODOMESTICOS--%>
       <br><br><br><br>
        <h1 align="center">REGISTRAR DATOS</h1>
        <table border="1" width="1000" align="center">
            <tr bgcolor="skyblue">
                <th colspan="6">ABM Clientes</th>
                <th><a href="nuevoCliente.jsp">
                        <img src="img_botones/agregarUsuario.png" width="30" height="30"/></a></th>
            
            </tr>
            <tr bgcolor="skyblue">
                <th>Id Cliente</th><br>
                <th>Nro.Documento</th><br>
                <th>Nombre y Apellido</th><br>
                <th>Dirección</th><br>
                <th>Email</th><br>
                <th>Password</th>
                 <th>Acción</th>
            </tr>
            <%
                //declaro las variables de conexion
                Connection cn=null;
                Statement sta=null;
                ResultSet rs=null;
                

                try {
                      //inicializo el driver de mysql
                      Class.forName("com.mysql.jdbc.Driver");
                      //inicializo la cadena de conexion
                      cn=DriverManager.getConnection
                    ("jdbc:mysql://localhost/electrodomesticos?user=root&password=");
                      // inicializamos el statemen que nos ayuda a ejecutar la sentencia sql
                      sta=cn.createStatement();
                      //ejecutamos la sentencia y guardamos el resultado obtenido en la variable resulset
                      rs=sta.executeQuery("select * from cliente");
                      //obtenidos los resultados volcamos los mismos a la tabla mediante un 
                      //bucle while que recorre la tabla fila a fila
                      while (rs.next()){
                          %>
                          <tr> <%-- recorremos con el bucle y cargamos la tabla fila por fila--%>
                              <th><%=rs.getString(1)%></th>
                              <th><%=rs.getString(2)%></th>    
                              <th><%=rs.getString(3)%></th>
                              <th><%=rs.getString(4)%></th>
                              <th><%=rs.getString(5)%></th>
                              <th><%=rs.getString(6)%></th>
                              <th>
                                  <a href="editarCliente.jsp?cod=<%=rs.getString(1)%>">
                                  <img src="img_botones/editarUsuario.png" width="30" height="30"/> ||
                                  </a>
                                  <a href="eliminarCliente.jsp?cod=<%=rs.getString(1)%>">

                                  <img src="img_botones/eliminarUsuario.png" width="30" height="30"/> 
                                  </a>
                              </th>
                              
                          </tr>
     
                          <%
                          
                      }
                      
                      //Una vez concluido , cerramos las variables inicializadas 
                      
                      sta.close();
                      rs.close();
                      cn.close();
                    } catch (Exception e) {
                    }
                
                
                %>
            

        </table>
    </body>
</html>
