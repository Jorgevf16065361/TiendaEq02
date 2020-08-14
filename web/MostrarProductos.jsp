<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="Controlador.*" %>

<%@ page session="true" %>
<%
String usuario = "";
HttpSession sesionOk = request.getSession();
if (sesionOk.getAttribute("usuario") == null) {
%>
<jsp:forward page="login.jsp">
<jsp:param name="error" value="Es
obligatorio identificarse"/>
</jsp:forward>
<%
} else {
usuario = (String)sesionOk.getAttribute("usuario");
}
%>

<%-- Validar inicio de sesion --%>


<%-- Finalizar validaciones --%>



<%-- Obtener Vector de Productos de la BD --%>

    <%
                       
        Vector<Producto> vecPro=new Producto().listaProductos();
    %>

<%-- Finalizar --%>
<html>
<head>
<title>Tienda Online</title>

<link rel="stylesheet" href="css/estilo.css">
</head>

<body>

	<header id="main-header">
		<a id="logo-header" href="index.html">
		<img src="Imagenes/logo2.png">
		</a> <!-- / #logo-header -->
                
		<nav>
                   <ul>
                <li><a href="index.html">Inicio</a></li>
                <li><a href="conocenos.html">Conocenos</a></li>
		<li><a href="productos.html">Productos</a></li>
                <li><a href="MostrarProductos.jsp">Consultar Productos</a></li>
                <li><a href="AgregarProducto1.jsp">Agregar al Carrito</a></li>
                <li><a href="contacto.html">Contactanos</a></li>
                <li><a href="SCerrarSesion">Cerrar Sesion</a></li>
               
			</ul>
		</nav><!-- / nav -->
        </header>
    
<body><br>
    <section id="main-content">
<b>Bienvenido:</b> <%=usuario%>
<table width="800" border="1" align="center" cellpadding="0" cellspacing="0">
  

    <td colspan="2">

      <table width="100%" border="0">
          <tr>
                <td width="68%"><h4>Nombre</h4></td>
                <td width="16%" align="right" valign="top"><h4><span class="Estilo3">Stock</span></h4></td>
                <td width="16%" align="right" valign="top"><h4><span class="Estilo3">Precio</span></h4></td>
                 
          </tr>

          <%
            for(Producto pro:vecPro){
          %>
          <tr>
            <td><%=pro.getProducto_nombre() %></td>
            <td align="right" valign="top"><%=pro.getProducto_stock() %></td>
            <td align="right" valign="top"><%=pro.getProducto_precio() %></td>
             
          </tr>
          <%}%>

        </table>
    </td>
  </tr>
  
</table>
          </section>
          <footer id="main-footer">
		<p>&copy; 2020 <a href="https://www.icel.edu.mx/campus/ciudad-de-mexico/ermita/" target="_blank">Universidad ICEL</a></p>
		<span class="site-desc">Proyecto Final Programación de la Red Mundial</span>
	</footer> <!-- / #main-footer -->
</body>
</html>
