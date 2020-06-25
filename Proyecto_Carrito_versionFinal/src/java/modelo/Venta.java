/*
 * esta clase tiene todos los campos necesarios
para registrar las ventas relacionando las tablas
correspondientes
 */
package modelo;

/**
 *
 * @author Ely
 */
public class Venta {
    Integer id;
    Integer item;
    Integer idcliente;
    Integer idproducto;
    String Descripcionp;
    String fecha;
    Double precio;
    Integer cantidad;
    Double subtotal;
    Double monto;
    
    public Venta(){
        
    }

    public Venta(Integer id, Integer item, Integer idcliente, Integer idproducto, String Descripcionp, String fecha, Double precio, Integer cantidad, Double subtotal, Double monto) {
        this.id = id;
        this.item = item;
        this.idcliente = idcliente;
        this.idproducto = idproducto;
        this.Descripcionp = Descripcionp;
        this.fecha = fecha;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.monto = monto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getDescripcionp() {
        return Descripcionp;
    }

    public void setDescripcionp(String Descripcionp) {
        this.Descripcionp = Descripcionp;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
    
    
    
}
