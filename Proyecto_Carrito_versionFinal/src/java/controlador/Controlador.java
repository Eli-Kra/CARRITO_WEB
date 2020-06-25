/*
 * en este servlet se detallaran los casos o acciones que vienen 
como peticion de las paginas jsp que hacen referencia al controlador 
detallados en el processrequest
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Carrito;
import modelo.Cliente;
import modelo.Producto;
import modeloDao.ClienteDao;
import modeloDao.ProductoDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Ely
 */
@MultipartConfig
public class Controlador extends HttpServlet {
    
    ProductoDAO pdao=new ProductoDAO();
    Producto p=new Producto();
    Cliente client=new Cliente();
    ClienteDao cliDao=new ClienteDao();
    List<Producto> productos=new ArrayList<>();
    List<Carrito> listaCarrito=new ArrayList<>();
    int item;
    double totalPagar=0.0;
    int cantidad=1;
    int idp;
    Carrito car;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String accion=request.getParameter("accion");
       //declaramos un objeto de tipo accion
       //utilizamos la sentencia switch para la gestion de las acciones
       productos=pdao.listar();//llamamos el metodo listar de la clase productodao
     // String menu=request.getParameter("menu");
      //if(menu.equalsIgnoreCase("Cliente")){
       //   request.getRequestDispatcher("Registro_Clientes.jsp").forward(request, response);
    //  }
       
       switch (accion){    
           case "Comprar": // con este caso al pulsar el boton comprar del catalogo va directo al detalle de compras
               totalPagar=0.0;//cada vez que pulsa comprar se inicializa la variable en cero
               idp=Integer.parseInt(request.getParameter("id"));
               p=pdao.listarId(idp);//llamamos al metodo listarid del controlador
               item=item+1; // realiza la sumatoria de los items adquiridos
               Carrito car=new Carrito();//instanciamos la clase carrito
                item=item+1;//cando el usuario selecciona el producto debe agregarse al objeto carrito para 
                //eso utilizamos los metodos del objeto carrito por medio de su instancia de clase car
                car=new Carrito();
                car.setItem(item);
                car.setIdProducto(p.getId());
                car.setNombres(p.getNombres());
                car.setDescripcion(p.getDescripcion());
                car.setPrecioCompra(p.getPrecio());
                car.setCantidad(cantidad);
                car.setSubTotal(cantidad*p.getPrecio());
                listaCarrito.add(car);//luego guardamos todas las variables en el objeto listacarrito
                 for (int i = 0; i < listaCarrito.size(); i++) { //luego enviamos el monto a pagar usando un bucle for
                    totalPagar=totalPagar+listaCarrito.get(i).getSubTotal();//realizamos la sumatoria de la columna subtotal 
                }
                request.setAttribute("totalPagar", totalPagar);
                request.setAttribute("carrito", listaCarrito);
                //luego contabilizamos la cantidad de productos comprados 
                request.setAttribute("contador", listaCarrito.size()); 
                //al final redireccionamos al carrito 
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
           break;
           //****************************************
            case "AgregarCarrito":
                //para conocoer la posision y la cantidad de productos declaramos un par de variables para manejar estos datos
                int pos=0;
                cantidad=1;
               idp=Integer.parseInt(request.getParameter("id"));
               p=pdao.listarId(idp);//llamamos al metodo listarid del controlador
              
               if(listaCarrito.size()>0){//verificamos el tama;o de nuestra lista carrito
                  for (int i = 0; i < listaCarrito.size(); i++) {//obtenemos la posicion del id del producto
                      if(idp==listaCarrito.get(i).getIdProducto()){
                          pos=i;
                      }
                  }
                  //una vez conocida la posicion del id realizamos la sumatoria de los ide similares 
                  if(idp==listaCarrito.get(pos).getIdProducto()){
                      cantidad=listaCarrito.get(pos).getCantidad()+cantidad;//obtenemos la suma de items
                      double subtotal=listaCarrito.get(pos).getPrecioCompra()*cantidad;//recalculamos el subtotal
                      //las dos variables nuevas las debeos colocar en la posicion actual
                      listaCarrito.get(pos).setCantidad(cantidad);
                      listaCarrito.get(pos).setSubTotal(subtotal);
                      
                  }else{//si no cumple esta cndicion se agrega el producto normalmente
                        item=item+1; // realiza la sumatoria de los items adquiridos
                        car=new Carrito();//instanciamos la clase carrito
                        item=item+1;//cando el usuario selecciona el producto debe agregarse al objeto carrito para 
                        //eso utilizamos los metodos del objeto carrito por medio de su instancia de clase car
                        car=new Carrito();
                        car.setItem(item);
                        car.setIdProducto(p.getId());
                        car.setNombres(p.getNombres());
                        car.setDescripcion(p.getDescripcion());
                        car.setPrecioCompra(p.getPrecio());
                        car.setCantidad(cantidad);
                        car.setSubTotal(cantidad*p.getPrecio());
                        listaCarrito.add(car);//luego guardamos todas las variables en el objeto listacarrito
                
                      
                  }
              }else{
                item=item+1; // realiza la sumatoria de los items adquiridos
                car=new Carrito();//instanciamos la clase carrito
                item=item+1;//cando el usuario selecciona el producto debe agregarse al objeto carrito para 
                //eso utilizamos los metodos del objeto carrito por medio de su instancia de clase car
                car=new Carrito();
                car.setItem(item);
                car.setIdProducto(p.getId());
                car.setNombres(p.getNombres());
                car.setDescripcion(p.getDescripcion());
                car.setPrecioCompra(p.getPrecio());
                car.setCantidad(cantidad);
                car.setSubTotal(cantidad*p.getPrecio());
                listaCarrito.add(car);//luego guardamos todas las variables en el objeto listacarrito
                
              }
                     
                request.setAttribute("contador", listaCarrito.size());
                //luego seguimos mostrando los productos por eso redirigimos a home que es el catlogo de productos
                request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
               
            break;
            //*************************************
            
            
            case "Delete": //este caso esta referenciado en el archivo js funciones
                int idproducto=Integer.parseInt(request.getParameter("idp"));//capturamos el id del producto enviado por el archivo js funciones
                //con un bucle recorremos la lista y con el if, verificamos si el id seleccionado para borrar es el mismo que el usuario selecciono y borrarmos
                    for(int i=0; i<listaCarrito.size(); i++){
                        if(listaCarrito.get(i).getIdProducto()==idproducto){
                           listaCarrito.remove(i);  
                        }
                       
                    }
            break;    
            
            
            //**************************************
            case "ActualizarCantidad"://en este caso vamos a calcular de forma automatica la cantidad y precio en el carrito
                int idpro=Integer.parseInt(request.getParameter("idp"));
                int cant=Integer.parseInt(request.getParameter("Cantidad"));
                for(int i=0; i<listaCarrito.size(); i++){
                    if(listaCarrito.get(i).getIdProducto()==idpro){
                       listaCarrito.get(i).setCantidad(cant);
                       double st=listaCarrito.get(i).getPrecioCompra()*cant;
                        listaCarrito.get(i).setSubTotal(st);
                       //listaCarrito.get(i).setSubTotal(listaCarrito.get(i).getPrecioCompra()*cant);
                      /*  
                       */
                    }
                }
        
            break;
            
            //****************************************
            case "Carrito":
               totalPagar=0.0;//inicializamos la variable total
               request.setAttribute("carrito", listaCarrito);//enviamos toda la lista del carrito al formulario 
               //luego enviamos el monto a pagar usando un bucle for
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar=totalPagar+listaCarrito.get(i).getSubTotal();//realizamos la sumatoria de la columna subtotal
                    
                }
                request.setAttribute("totalPagar", totalPagar);//luego enviamos el total a pagar resultante
               request.getRequestDispatcher("carrito.jsp").forward(request, response);//mostramos la pagina con el detalle
               
               
            break;
            
            
            //*************************************
            //esta accion redirige a la pagina index catalogo
            case "Principal":
               //request.getRequestDispatcher("index_catalogo.jsp").forward(request, response);
               request.getRequestDispatcher("index_ABM.jsp").forward(request, response);
            break;
           
            //************************************
            case "Guardar":
                ArrayList<String>lista=new ArrayList<>();
                try {
                    FileItemFactory file= new DiskFileItemFactory();
                   ServletFileUpload fileUpload=new ServletFileUpload(file);
                   List items=fileUpload.parseRequest(request);
                   for(int i=0; i<items.size(); i++){
                       FileItem fileItem=(FileItem)items.get(i);
                       if(!fileItem.isFormField()){
                           File f=new File("C:\\imagenes\\"+fileItem.getName());
                           fileItem.write(f);
                          // p.setRuta(f.getAbsoluteFile());
                       }
                   }
                    
                } catch (Exception e) {
                }
                
            break;
            
            //este caso sirve para que aparezcan en el frame los productos
            case "Producto":
              request.getRequestDispatcher("index_catalogo.jsp").forward(request, response);
            break;
            
             case "Clientes":
              request.getRequestDispatcher("Registro_Clientes.jsp").forward(request, response);
            break;
            
             
             
              
            
            
            
           default: 
                //una vez que la variable productos almacena los productos
                //los mostramos dentro de la pagina con el metodo request.set
               request.setAttribute("productos", productos);
               //una vez enviados los datos hacemos que se muestren en la ventana
               request.getRequestDispatcher("index_catalogo.jsp").forward(request, response);
        
          
 
       
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //con este metodo listamos las imagenes
        String accion=request.getParameter("accion");
        switch (accion){
            case "Listar":
                List<Producto>lista=pdao.listar();
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("Regisrar_Productos.jsp").forward(request, response);
                break;
                
            case "Nuevo":
                request.getRequestDispatcher("agregarProductos.jsp").forward(request, response);
                
            break;
            
            case "Guardar":
               
                String nom=request.getParameter("txtNom");
                Part part=request.getPart("fileFoto");
                InputStream inputStream=part.getInputStream();
                String des=request.getParameter("txtDes");
                Double pre=Double.parseDouble(request.getParameter("txtPrecio"));
                int stock=Integer.parseInt(request.getParameter("txtStock"));
                p.setNombres(nom);
                p.setFoto(inputStream);
                p.setDescripcion(des);
                p.setPrecio(pre);
                p.setStock(stock);
                pdao.agregar(p);
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                
                
            break;
            
            
            default:
                 request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                
        }
        
        
        
        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
