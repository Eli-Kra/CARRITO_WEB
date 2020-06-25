/*
 *  en esta clase declaramos las variables que representan los 
campos de nuestra tabla, y creamos el constructor vacio, y el 
constructor inicializando las varialbles, ademas creamos los
metodos getter y setter.
 */
package modelo;

/**
 *
 * @author Ely
 */
public class Cliente {
    
     // declaramos las variables y objetos que 
    //representan los campos de la tabla
      private int id;
    private String num_documento;
    private String nombre;
    private String direccion;
    private String correo;
    private String password;
    
    //constructor vacio
    public Cliente(){
        
    }
  //constructor inicializado las variables y objetos
    public Cliente(int id, String num_documento, String nombre, String direccion, String correo, String password) {
        this.id = id;
        this.num_documento = num_documento;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.password = password;
    }
 //creamos los metodos setter que no retorna valores
    //solo realizan las operaciones designadas
    //creamos los metodos getter que si retornan valores
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
