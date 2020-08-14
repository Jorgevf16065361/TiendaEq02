
 

package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hwongu
 */
public class SCerrarSesion extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        response.setContentType("text/html");
	PrintWriter out = response.getWriter();
        
               
        out.println("<html><head>" + 
		  "<meta http-equiv='refresh'"+"content='3;"+
		  "url=http://localhost:8080/cerrarsesion.jsp'>"
                + "<link rel=\"stylesheet\" href=\"css/estilo.css\"></link>"
                + "</head>"
                + "<body>"
                + "<header id=\"main-header\">\n" +
" 		<a id=\"logo-header\" href=\"index.html\">\n" +
"		<img src=\"Imagenes/logo2.png\">\n" +
"		</a> <!-- / #logo-header -->\n" +
"                \n" +
"		<nav>\n" +                  
"		</nav><!-- / nav -->\n" +
"               </header>"
                + "<section id=\"main-content\">"
                + "<table border=0 width=\"800\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
"  <tr align=\"center\">\n" +
"    <td colspan=\"2\"><h2><span class=\"Estilo1\">Gracias por su compra</span></h2></td>\n" +
"  </tr>\n" +
"  <tr>\n" +
"    <td width=\"175\"></td>\n" +
"    <td width=\"625\">\n"
  + "Se esta cerrando su sesión espere un momento...." +
"    \n" +
"    </td>\n" +
"  </tr>\n" +
"  <tr>\n" +
"    <td colspan=\"2\"><div align=\"center\"><strong><span class=\"Estilo2\"></span></strong>"
                + "</div></td>\n" +
"  </tr>\n" +
"</table>"
                + "</section>"
                + " <footer id=\"main-footer\">\n" +
"		<p>&copy; 2020 <a href=\"https://www.icel.edu.mx/campus/ciudad-de-mexico/ermita/\" target=\"_blank\">Universidad ICEL</a></p>\n" +
"		<span class=\"site-desc\">Proyecto Final Programación de la Red Mundial</span>\n" +
"	</footer>"
                + "</body></html>");
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}