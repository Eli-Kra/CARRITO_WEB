/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ely
 */
public class Conexion {
    
    Connection con;
    
    public Conexion (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=(com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/electrodomesticos", "root", "");
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
    }
    public Connection getConnection(){
        return con;
    }
    
}