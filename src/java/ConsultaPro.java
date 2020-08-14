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
public class ConsultaPro extends HttpServlet {

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
            out.println("<h1>Tabla de Productos</h1>"
                    + "<table border=2>"
                    + "<tr>"
                    + "<td><br><b>ID</b>"
                    + "</td>"
                    +"<td><br><b>Nombre Producto</b>"
                    + "</td>"
                    +"<td><br><b>Precio del Producto</b>"
                    + "</td>"
                    +"<td><br><b>Stock del Producto</b>"
                    + "</td>"
                    + "</tr>");
            try{
                //donde se hace la consulta
                String nom, pre, sto, q, q2;
                int id;
                // query
                q = "select producto_Nombre,producto_Precio,producto_Stock, from producto";
                q2= "select * from producto";
                //obtemer db                
                set = con.createStatement();
                rs = set.executeQuery(q2);
                //recorrer todos los registros
                while(rs.next()){
                    id =  rs.getInt("producto_Codigo");
                    nom = rs.getString("producto_Nombre");    
                    pre = rs.getString("producto_Precio"); 
                    sto = rs.getString("producto_Stock");
                     
                   
                    //salida html
                    out.println("<tr>"
                               +"<td>"+id+"</td>"
                               +"<td>"+nom+"</td>"
                               +"<td>"+pre+"</td>"
                               +"<td>"+sto+"</td>"
                               + "</tr>");
                }
                //cierro conexiones
                rs.close();
                set.close();
            }catch (Exception e){
                    System.out.println("No encontro la tabla");
                    System.out.println(e.getMessage());
                    System.out.println(e.getStackTrace());//hilo de error
               }
           out.println("</table>"
                    +"<div>"
                    +"<form action=\"BorrarPro\">"
                    +"<br>"
                    +"<h1>Borra Productos</h1>"
                    +"ID:<input type=\"text\" name=\"borrar\"required maxlength=\"10\">"
                    +" <br> <input type=\"submit\" value=\"Borrar Producto\">"
                    +"</form>"
                    +"</div>"+"</div>");
            out.println("</table>"
                    +"<div>"
                    +"<form action=\"EditarPro\">"
                    +"<br>"
                    +"<h1>Editar Producto</h1>"
                    +"ID:<input type=\"text\" name=\"editar\" required maxlength=\"10\">"
                    +" <br> <input type=\"submit\" value=\"Editar Producto\">"
                    +"</form>"
                    +"</div>"+"</div>");
            out.println("<a href='productos.html'>Rregresar al Producto</a>");
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