/*
 * en esta clase haremos la conexion con la base de datos
para listar los productos ahi registrados por medio de clases
de conexion y metodos programados para dicho efecto.
 */
package modeloDao;

import config.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import modelo.Producto;

/**
 *
 * @author Ely
 */
public class ProductoDAO {
    //declaramos el objeto de tipo connection
    Connection con;
    //instanciamos un objeto de tipo conexion e importamos el paquete
    Conexion cn= new Conexion();
    //declaramos una variable de tipo statement
    PreparedStatement ps;
    //declaramos una variable que almacene los resultados de tipo resulset
    ResultSet rs;
    
    
    //creamos un metodo de tipo list para listar los productos
    
    public List listar(){
        //declaramos una variable List de tipo Producto
        List<Producto>productos=new ArrayList();
        //creamos una variable para el sql
        String sql="select * from producto";
        //instanciamos un objeto de la clase producto
        
        try { // hacemos la conexion con los objetos creados para listar
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){ //con un bucle recorremos la tabla y extraemos las filas de datos
                Producto p=new Producto();
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setFoto(rs.getBinaryStream(3));
                p.setDescripcion(rs.getString(4));           
                p.setPrecio(rs.getDouble(5));
                p.setStock(rs.getInt(6));
                productos.add(p);
            }
        } catch (Exception e) {
        }
        return productos; // retornamos los productos
    }
    
    // en este metodo listar imagen haremos que se muestren
    //las imagenes de los productos
    //primero creamos la consulta sql, luego creamos los objetos
    //para el manejo de imagenes inputstream y outputstream y los
    //inicializamos , y dentro de un try realizamos la conexion
    //y un condicional if que no spermitira recorrer la tabla y 
    //mostrar las imagenes
    
     public void listarImg(int id, HttpServletResponse response){
        String sql="select * from producto where idProducto="+id;
        InputStream inputStream=null;
        OutputStream outputStream=null;
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        //response.setContentType("image/*");
        try {
            
            outputStream=response.getOutputStream();
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            if(rs.next()){
                 inputStream=rs.getBinaryStream("Foto");
            }
            bufferedInputStream=new BufferedInputStream(inputStream);
            bufferedOutputStream=new BufferedOutputStream(outputStream);
            int i=0;
            while ((i=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(i);
            }
            
        } catch (Exception e) {
        }
    }
     //en este metodo listamos los productos por el id seleccionado
       public Producto listarId (int id){
        String sql="select * from producto where idProducto="+id;
        Producto p=new Producto();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setFoto(rs.getBinaryStream(3));
                p.setDescripcion(rs.getString(4));           
                p.setPrecio(rs.getDouble(5));
                p.setStock(rs.getInt(6));
            }
        } catch (Exception e) {
        }
        return p;
    }
      
     //este metodo sirve para agregar registros a la base de datos
       
       public void agregar(Producto p){
           String sql="insert into producto(Nombres, Foto, Descripcion, Precio, Stock) values (?,?,?,?,?)";
           try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNombres());
            ps.setBlob(2, p.getFoto());
            ps.setString(3, p.getDescripcion());
            ps.setDouble(4, p.getPrecio());
            ps.setInt(5, p.getStock());
            ps.executeUpdate();
               
           } catch (Exception e) {
           }
       
       
       }
    
}
