/*
 * AQUI CREAMOS LA CLASE CONEXION LA QUE NOS PERMITIRA CONECTARNOS CON LA BASE DE DATOS
    MEDIANTE LAS VARIALBES QUE DECLARAREMOS PARA REPRESENTAR LA URL, USUARIO Y CLAVE
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ely
 */
public class Conexion {
     /*  Connection con; //declaramos una variable de tipo connection e importamos el paguete correspondiente
    
    
    String url="jdbc:mysql://localhost:3306/electrodomesticos";//declaramos el objeto url donde especificamos la direccion de la base y el servidor
    
    String user="root"; // definimos un bjeto que representa al usuario en este caso uno por defecto
    
    String pass=" "; // definimos el objeto para la contrasena en este caso esta vacio.
    
    //creamos el metodo de tipo conexion 
    public Connection Conexion (){ //dendro de un bloque try para excepcion  inicializamos los driver de conexion
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            con=DriverManager.getConnection(url, user, pass); // asignamos al objeto de conexion las variables declaradas 
            
           
            
            // definimos en la variable
        } catch (Exception e) {
            //capturamos el error para poder verificarlo
            System.err.println("Error"+e);
        }
          return con; // el metodo retorna la conexion
    }
 
       
    }*/
   
// 2da opcion de disenio de conexion

 Connection con;
    
    public Conexion (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/electrodomesticos", "root", "");
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
    }
    public Connection getConnection(){
        return con;
    }

    
}
