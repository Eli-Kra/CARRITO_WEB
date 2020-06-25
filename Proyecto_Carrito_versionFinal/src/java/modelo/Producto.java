/*
 * en esta clase declaramos las variables que represetaran a los campos de la tabla productos que esta en nuestra base de datos
luego creamos los construcotores uno vacio y otro inicializando las variables y objetos, y luego por ultimo creamos los metodos
setter y getter los set no devuelven informacion, solo realizan determinadas acciones pero los get si retornan datos.
 */
package modelo;

import java.io.InputStream;

/**
 *
 * @author Ely
 */
public class Producto {
    int id;
    String nombres;
    InputStream foto;
    String descripcion;
    double precio;
    int stock;
    
    
    public Producto(){
        
    }

    public Producto(int id, String nombres, InputStream foto, String descripcion, double precio, int stock) {
        this.id = id;
        this.nombres = nombres;
        this.foto = foto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    
}
