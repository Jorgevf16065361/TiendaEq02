/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge
 */
public class BorrarPro extends HttpServlet {

      private Connection con;//
    private Statement set;
    private ResultSet rs;
   
    public void init(ServletConfig cfg) throws ServletException{
        
        String URL = "jdbc:mysql:3306//sistemaventas";
        
        String userName = "root";
        String password = "";
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            
            URL = "jdbc:mysql://localhost/sistemaventas";
            con = DriverManager.getConnection(URL, userName, password);
            set = con.createStatement();
            
            System.out.println("Conecto con Id BD");
            
        }catch(Exception e){
            System.out.println("No conecto la BD");
             System.out.println(e.getMessage());
             System.out.println(e.getStackTrace());
             
        }
            
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>"
                       + "<meta charset=\"utf-8\">");
            out.println("<title>Consultar Usuarios</title>"
                       + "<link rel=\"stylesheet\" href=\"css/estilo.css\">");            
            out.println("</head>");
            out.println("<body>"
                       + "<header id=\"main-header\">"
                       + "<a id=\"logo-header\" href=\"index.html\">"
                       + "<img src=\"Imagenes/logo2.png\">"
                       + "</a> <!-- / #logo-header -->"
                       + "</header><!-- / #main-header -->"
                       + "<section id=\"main-content\">"
                       + "<article>"
                       + "<header>"
                       + "<h1>Administracion de Tienda Informática</h1>"
                       + "</header>");
            
            try{
                    String q;
                    int id;
                    
                    id = Integer.parseInt(request.getParameter("borrar"));
                    
                    
                    q = "delete from producto where producto_Codigo ='"+id+"'";
                    
                    set.executeUpdate(q);
                    
           
            
            out.println("<h1>Registro Borraro con Exito</h1>");
            out.println("<a href='productos.html'>Regresar</a>");
               System.out.println("Lo borro");
            
             }catch(Exception e){
                 
                 System.out.println("No encotro la Tabla");
                 System.out.println(e.getMessage());
                 System.out.println(e.getStackTrace());
                 
                 out.println("<h1>No encotro el Registro</h1>");
                  out.println("<a href='productos.html'>Regresar</a>");           
            }
            out.println("</article> <!-- /article -->"
                    + "</section> <!-- / #main-content -->"
                    + "<footer id=\"main-footer\">"
                    + "<p>&copy; 2020 <a href=\"https://www.icel.edu.mx/campus/ciudad-de-mexico/ermita/\" target=\"_blank\">Universidad ICEL</a></p>"
                    + "<span class=\"site-desc\">Proyecto Final Programación de la Red Mundial</span>"
                    + "</footer> <!-- / #main-footer -->");
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