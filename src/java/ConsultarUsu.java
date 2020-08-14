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
public class ConsultarUsu extends HttpServlet {

    private Connection con;//
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
            out.println("<h1>Tabla de Usuarios</h1>"
                    + "<table border=2>"
                    + "<tr>"
                    + "<td><b>ID</b>"
                    + "</td>"
                    + "<td><b>Nombre</b>"
                    + "</td>"
                    + "<td><b>Apellido </b>"
                    + "</td>"
                    + "<td><b>Usuario</b>"
                    + "</td>"
                    + "<td><b>Clave</b>"
                    +"</td>"
                    +"<td><b>Privilegio</b>"
                    + "</td>"
                    + "</tr>");
            try{
                //donde se hace la consulta
                String nom, apa, user, clave, privi, q, q2;
                int id;
                // query
                //q = "select nom_usu,appat_usu,apmat_usu,tel_usu from usuario";
                q2 = "select * from usuario";
                //obtemer db                
                set = con.createStatement();
                rs = set.executeQuery(q2);
                //recorrer todos los usuarios
                while(rs.next()){
                     id =  rs.getInt("usuario_Codigo");
                    nom = rs.getString("usuario_Nombre");    
                    apa = rs.getString("usuario_Apellido"); 
                    user = rs.getString("usuario_User");
                    clave = rs.getString("usuario_Clave"); 
                   privi = rs.getString("usuario_Privilegio");
                    //salida html
                    out.println("<tr>"
                               +"<td>"+id+"</td>"
                               +"<td>"+nom+"</td>"
                               +"<td>"+apa+"</td>"
                               +"<td>"+user+"</td>"
                               +"<td>"+clave+"</td>"
                               +"<td>"+privi+"</td>"        
                               + "</tr>");
                }
                //cierro conexiones
                rs.close();
                set.close();
            }catch (Exception e){
                    System.out.println("No encontro la tabla");
                    out.println("<a href='registro.html'>Rregresar al Registro</a>");
                    System.out.println(e.getMessage());
                    System.out.println(e.getStackTrace());//hilo de error
               }
            out.println("</table>"
                    +"<div>"
                    +"<form action=\"BorrarUsu\">"
                    +"<br>"
                    +"<h1>Borra Registros</h1>"
                    +"ID:<input type=\"text\" name=\"borrar\" required maxlength=\"10\">"
                    +" <br> <input type=\"submit\" value=\"Borrar Registro\">"
                    +"</form>"
                    +"</div>"+"</div>");
            out.println("</table>"
                    +"<div>"
                    +"<form action=\"EditarUsu\">"
                    +"<br>"
                    +"<h1>Editar Registro</h1>"
                    +"ID:<input type=\"text\" name=\"editar\" required maxlength=\"10\">"
                    +" <br> <input type=\"submit\" value=\"Editar Registro\">"
                    +"</form>"
                    +"</div>"+"</div>");
            out.println("<a href='registro.html'>Rregresar al Registro</a>");
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
}