/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletConfig;
/**
 *
 * @author jorge
 */
public class AgregarPro extends HttpServlet {
 
    
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    @Override
    public void init(ServletConfig cfg) throws ServletException{
        
        String URL = "jdbc:mysql://localhost/sistemaventas";
        
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
            
            String nom, pre, sto;
            
            nom = request.getParameter("producto_Nombre");
            pre = request.getParameter("producto_Precio");
            sto =  request.getParameter("producto_Stock");
            
            
            try{
            
                String q = "insert into producto(producto_Nombre, producto_Precio, producto_Stock)"
                        + "values ('"+nom+"', '"+pre+"', '"+sto+"')";
                
                set.executeUpdate(q);
                System.out.println("Dato Agregado");
            /* TODO output your page here. You may use following sample code. */
           out.println("<!DOCTYPE html>");
            out.println("<html>");
             out.println("<head>"
                       + "<meta charset=\"utf-8\">");
            out.println("<title>Consultar Productos</title>"
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
            out.println("<body>");
            out.println("<h1>Gracias por Registrarte</h1>"
                    + "<a href='productos.html'>Regresar</a>");
            
            }catch(Exception e){
                System.out.println("No se pudo Registrar");
                out.println("<a href='productos.html'>Rregresar al Registro</a>");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());//hilo de error
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