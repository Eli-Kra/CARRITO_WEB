/*
 * este servlet nos permite hacer el control de las acciones para el mantenimiento de las clases cliente y producto
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Carrito;
import modelo.Cliente;
import modelo.Producto;
import modelo.Venta;
import modeloDao.ClienteDao;
import modeloDao.ProductoDAO;

/**
 *
 * @author Ely
 */
public class Controlador_crud extends HttpServlet {
    
    Cliente client=new Cliente();
    ClienteDao cliDao=new ClienteDao();
    Producto p=new Producto();
    ProductoDAO pdao=new ProductoDAO();

    int ide;
    int idc;
    int idp;
    
    Venta v=new Venta();
    List<Venta>lista=new ArrayList<>();
    int item;
    int cod;
    String nombre;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    
    
   
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
          String menu = request.getParameter("menu");
       //declaramos un objeto de tipo accion
       //utilizamos la sentencia switch para la gestion de las acciones
       if(menu.equals("Principal")){
            request.getRequestDispatcher("index_catalogo.jsp").forward(request, response);
           
       }
       if(menu.equals("Clientes")){
           switch (accion){
               case "Listar_Clientes":
                    List lista_clientes=cliDao.Listar_Clientes();
                    request.setAttribute("clientes", lista_clientes);
                 
                break;
             
                case "Agregar":
                    String doc = request.getParameter("txtDoc");
                    String nom = request.getParameter("txtNom");
                    String dir = request.getParameter("txtDir");
                    String email = request.getParameter("txtEmail");
                    String pass = request.getParameter("txtPass");
                    client.setNum_documento(doc);
                    client.setNombre(nom);
                    client.setDireccion(dir);
                    client.setCorreo(email);
                    client.setPassword(pass);               
                    cliDao.Agregar_Clientes(client);
                    request.getRequestDispatcher("Controlador_crud?menu=Clientes&accion=Listar_Clientes").forward(request, response);
                 
                break;
                
                case "Editar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    Cliente cl = cliDao.listarIdCliente(ide);
                    request.setAttribute("cliente1", cl);
                    request.getRequestDispatcher("Controlador_crud?menu=Clientes&accion=Listar_Clientes").forward(request, response);
                    
                 break;
                 
                case "Actualizar":
                    String doc1 = request.getParameter("txtDoc");
                    String nom1 = request.getParameter("txtNom");
                    String dir1 = request.getParameter("txtDir");
                    String email1 = request.getParameter("txtEmail");
                    String pass1 = request.getParameter("txtPass");
                    client.setNum_documento(doc1);
                    client.setNombre(nom1);
                    client.setDireccion(dir1);
                    client.setCorreo(email1);
                    client.setPassword(pass1);
                    client.setId(ide);
                    cliDao.Actualizar_Clientes(client);
                     request.getRequestDispatcher("Controlador_crud?menu=Clientes&accion=Listar_Clientes").forward(request, response);
                    
                    
                break;
                        
                case "Delete":
                    ide=Integer.parseInt(request.getParameter("id"));
                    cliDao.Eliminar_Clientes(ide);
                    request.getRequestDispatcher("Controlador_crud?menu=Clientes&accion=Listar_Clientes").forward(request, response);
                    
                    
                break;
                   
           }
           
            request.getRequestDispatcher("Registro_Clientes.jsp").forward(request, response);
       } 
  
            
     if(menu.equals("NuevaVenta")){
         switch (accion){
             case "BuscarCliente":
                String numDoc = request.getParameter("codigocliente");
                client.setNum_documento(numDoc);
                client=cliDao.buscar(numDoc);
                request.setAttribute("c", client);
                
             break;
             
             case "BuscarProducto":
               int id=Integer.parseInt(request.getParameter("codigoproducto"));
               p=pdao.listarId(id);
               request.setAttribute("c", client);
               request.setAttribute("producto", p);
               request.setAttribute("lista", lista);
               request.setAttribute("totalpagar", totalPagar);
                 
             break;
             
             case "Agregar":
                 request.setAttribute("c", client);
                 totalPagar=0;
                 item=item+1;
                 cod=p.getId();
                 nombre=request.getParameter("nombreproducto");
                 precio=Double.parseDouble(request.getParameter("precio"));
                 cant=Integer.parseInt(request.getParameter("cantidad"));
                 subtotal=precio*cant;
                 v=new Venta();
                 v.setItem(item);
                 v.setId(cod);
                 v.setDescripcionp(nombre);
                 v.setPrecio(precio);
                 v.setCantidad(cant);
                 v.setSubtotal(subtotal);
                 lista.add(v);
                 for(int i=0; i<lista.size(); i++){
                     totalPagar=totalPagar+lista.get(i).getSubtotal();
                 }
                 request.setAttribute("totalpagar", totalPagar);
                 request.setAttribute("lista", lista);
              break;
             
             
             
             
             default:
                 throw new AssertionError();
         }
         request.getRequestDispatcher("Registrar_Venta.jsp").forward(request, response);
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
        processRequest(request, response);
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
