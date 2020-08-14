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
 * @author AbrahamPerezMedina
 */
public class EditarP extends HttpServlet {

   private Connection con; //es el objeto para establecer la conexion de la BD
    private Statement set; //es para poder preparar los querys (insert, alter, create, drop)
    private ResultSet rs; //es el objeto para poder realizar consultas(select)
    
    public void init(ServletConfig cfg) throws ServletException{
        //se traza la conexion de la BD
        String URL = "jdbc:mysql://localhost/sistemaventas";
        String userName = "root";
        String password = "";
        try{
            //colocar el driver de la conexion mysql, sql, firebano, con el manejador
            Class.forName("com.mysql.jdbc.Driver");
            // a veces por la version del manejador o mysql
            //  URL = "jdbc:mysql:3306//localhost/saeo";
            //hacer usos d eo los objetos con y set 
            con = DriverManager.getConnection(URL, userName, password);
            //con set preparamos la setencia
            set = con.createStatement();
            System.out.println("Conecto con la BD");
            
        }catch(Exception e){
            System.out.println("No conecto la BD");
            //donde fue el error
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nom, pre, sto, id;
            
            id = request.getParameter("id_edit");            
            nom = request.getParameter("nom_edit");
            pre = request.getParameter("pre_edit");
            sto =  request.getParameter("sto_edit");
            
            
            try{
            
                String q = "update producto set producto_Nombre = '"+nom+"', producto_Precio = '"+pre+"', "
                        + "producto_Stock = '"+sto+"' where producto_Codigo = '"+id+"' ";
                
                set.executeUpdate(q);
                System.out.println("Producto Editado");
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
            out.println("<h1>Se editó el producto con Exito</h1>"
                    + "<a href='productos.html'>Regresar</a>");
             out.println("</article> <!-- /article -->"
                    + "</section> <!-- / #main-content -->"
                    + "<footer id=\"main-footer\">"
                    + "<p>&copy; 2020 <a href=\"https://www.icel.edu.mx/campus/ciudad-de-mexico/ermita/\" target=\"_blank\">Universidad ICEL</a></p>"
                    + "<span class=\"site-desc\">Proyecto Final Programación de la Red Mundial</span>"
                    + "</footer> <!-- / #main-footer -->");
            out.println("</body>");
            out.println("</html>");
            }catch(Exception e){
                System.out.println("No se pudo editar");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                out.println("<h1>No se encontro el Producto</h1>");
                out.println("<a href='productos.html'>Rregresar al Principal</a>");
            }
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
