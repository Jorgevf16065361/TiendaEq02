<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

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
    <section id="main-content">
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  
  
  <tr>
    <td colspan="2"><h1>SE REGISTRO LA COMPRA DE FORMA CORRECTA</h1></td>
  </tr>

  
</table>
    
    </section>
          <footer id="main-footer">
		<p>&copy; 2020 <a href="https://www.icel.edu.mx/campus/ciudad-de-mexico/ermita/" target="_blank">Universidad ICEL</a></p>
		<span class="site-desc">Proyecto Final Programación de la Red Mundial</span>
	</footer> <!-- / #main-footer -->
</body>
</html>
