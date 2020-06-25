/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modeloDao.ClienteDao;

/**
 *
 * @author Ely
 */
public class Validar_abm extends HttpServlet {
 ClienteDao cliDao = new ClienteDao();
    Cliente cli=new Cliente();
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Validar_abm</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Validar_abm at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
           //CAPTURAMOS LA PETICION DEL USUARIO
       String accion=request.getParameter("accion"); // la variable accion captura lo que el usuario solicita al presionar el boton
       //por medio de una condicional verficamos la accion que se esta realizando
       if(accion.equalsIgnoreCase("Ingresar")){ // si es verdadero se verifican los datos ingresados en las casillas
           //recibimos los datos ingresados en nuevas variables
           String usuar=request.getParameter("txtuser");
           String pass=request.getParameter("txtpass");
           //con los objetos de las clases cliente y clienteDao llamamos al metodo validar que recibe los dos parametros para realizar las comparaciones
           cli=cliDao.validar(usuar, pass);
           //mediante un if redireccionamos de acuerdo al resultado de la validacion
           
           if(cli.getCorreo()!=null){
               request.setAttribute("usuario", cli);
               request.getRequestDispatcher("Controlador_crud?menu=Principal").forward(request, response);
               //redireccionamos al controlador a la accion Principal y se ejecuta lo que hay dentro de este.
           }else{
               request.getRequestDispatcher("Registro_Clientes.jsp").forward(request, response);
           }
           
       }else{
          //si el cliente no presiona ingresar o preciona algun otro boton por accidente
          //nos redirecciona a la pagina principal
         request.getRequestDispatcher("index.jsp").forward(request, response); 
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
