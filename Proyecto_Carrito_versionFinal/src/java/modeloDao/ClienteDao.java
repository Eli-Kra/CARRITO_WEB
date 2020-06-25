/*
 * *esta clase se relaciona directamente con 
la base de datos de ahi el termino DAO
 */
package modeloDao;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

/**
 *
 * @author Ely
 */
public class ClienteDao {
     //INSTANCIAMOS LA CLASE CONEXION
    Conexion cn = new Conexion();
    //declaramos una variable de tipo connection
    Connection con;
    //declaramos una variable de tipo preparedstatemen
    PreparedStatement ps;
    //declaramos una variable de tipo resultset
    ResultSet rs;
    int r;//variable usada para el insert
    
    
    
    //este metodo nos sirve para buscar un cliente
    public Cliente buscar(String num_doc){
        Cliente cliente2=new Cliente();
        String sql="select * from cliente where Num_doc="+num_doc;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                cliente2.setId(rs.getInt(1));
                cliente2.setNum_documento(rs.getString(2));
                cliente2.setNombre(rs.getString(3));
                cliente2.setDireccion(rs.getString(4));
                cliente2.setCorreo(rs.getString(5));
                cliente2.setPassword(rs.getString(6));
            }
            
        } catch (Exception e) {
        }
        return cliente2;
    }
    
    
    
    
    //creamos un metodo del objeto cliente validar
    //e importamos la clase Cliente para utilizar el metodo
    
    public Cliente validar(String usuar, String pass ){ // este metodo recibira las dos variables que utilizaremos par arealizar las validaciones o verificaciones
        //instanciamos la clase cliente
        Cliente clienteValidar=new Cliente();
        //declaramos una variable para la sentencia sql
     
        String sql="select * from cliente where Email=? and Password=?" ;
        
        // creamos un bloque try para excepciones
        try {
            //realizamos la conexion con la variable de la clase conexion
          con=cn.getConnection();
          //inicializamos el objeto ps, 
          ps=con.prepareStatement(sql);
          ps.setString(1, usuar); // 
          ps.setString(2, pass);
          //ejecutamos la consulta sql
          rs=ps.executeQuery();
          //recorremos los datos devueltos por el sql mediante un bucle
          while(rs.next()){ // 
              clienteValidar.setId(rs.getInt("idCliente"));
              clienteValidar.setNum_documento(rs.getString("Num_doc"));
              clienteValidar.setNombre(rs.getString("Nombres"));
              clienteValidar.setDireccion(rs.getString("Direccion"));
              clienteValidar.setCorreo(rs.getString("Email"));
              clienteValidar.setPassword(rs.getString("Password"));
          }
         
            
            
        } catch (Exception e) {
        }
        return clienteValidar; //retorna el cliente encontrado
    }
    //operaciones crud
    
    //esta operacion es listar cliente asi vemos lo que hay en la bd
    public List Listar_Clientes(){
       String sql="select * from cliente" ;
       List<Cliente>lista=new ArrayList<>();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cliente cli=new Cliente();
                cli.setId(rs.getInt(1));
                cli.setNum_documento(rs.getString(2));
                cli.setNombre(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setCorreo(rs.getString(5));
                cli.setPassword(rs.getString(6));
                lista.add(cli);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    //metodo para agregar registros en la base de datos
    public int Agregar_Clientes(Cliente c){
        String sql="insert into cliente (Num_doc, Nombres, Direccion, Email, Password) values (?,?,?,?,?)";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, c.getNum_documento());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDireccion());
            ps.setString(4, c.getCorreo());
            ps.setString(5, c.getPassword());
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return r;    
    }
    
    public Cliente listarIdCliente(int id){
        Cliente clie=new Cliente();
        String sql="select * from cliente where idCliente="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                clie.setNum_documento(rs.getString(2));
                clie.setNombre(rs.getString(3));
                clie.setDireccion(rs.getString(4));
                clie.setCorreo(rs.getString(5));
                clie.setPassword(rs.getString(6));
            }
        } catch (Exception e) {
        }
    return clie;
    }
    
    
    
    
    //metodo para actualizar los datos de la base
    public int Actualizar_Clientes(Cliente c){
          String sql="update cliente set Num_doc=?, Nombres=?, Direccion=?, Email=?, Password=? where idCliente=?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, c.getNum_documento());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDireccion());
            ps.setString(4, c.getCorreo());
            ps.setString(5, c.getPassword());
            ps.setInt(6, c.getId());
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return r;    
    }
    
    //metodo para eliminar registros de la base
    public void Eliminar_Clientes(int id){
        String sql="delete from cliente where idCliente="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
