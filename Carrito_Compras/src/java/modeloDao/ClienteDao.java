/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

import configuracion.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Cliente;


public class ClienteDao {
    Conexion cn= new Conexion();
    Connection con;    
    PreparedStatement ps;
    ResultSet rs;
    
    public Cliente validar(String num_doc, String passw){
        Cliente client=new Cliente();
        String sql="select * from cliente where Num_doc=? and Password=? ";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, num_doc);
            ps.setString(2, passw);
            rs=ps.executeQuery();
            while(rs.next()){
                client.setId(rs.getInt("idCliente"));
                client.setNum_documento(rs.getString("Num_doc"));
                client.setNombre(rs.getString("Nombres"));
                client.setDireccion(rs.getString("Direccion"));
                client.setCorreo(rs.getString("Email"));
                client.setPassword(rs.getString("Password"));
            }
        } catch (Exception e) {
        }
        return client;
    }
    
}
