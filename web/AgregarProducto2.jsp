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
    Producto pro=new Producto().buscarProducto(Integer.parseInt(request.getParameter("cod")));
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
    <section id="main-content">
 
  <tr>
    <td colspan="2">

        <form name="frmPrincipal" action="SAgregarCarro"  method="post">

        <table width="100%" border="0" cellpadding="0">
      <tr>
        <td width="17%" ><span class="Estilo3">Codigo:</span></td>
        <td width="83%"><label>
          <input name="txtCodigo" type="text" id="txtCodigo" size="10" readonly value="<%=pro.getProducto_codigo() %>" >
        </label></td>
      </tr>
      <tr>
        <td><span class="Estilo3">Producto:</span></td>
        <td><input name="txtProducto" type="text" id="txtProducto" size="60" readonly value="<%=pro.getProducto_nombre() %>" ></td>
      </tr>
      <tr>
        <td><span class="Estilo3">Precio:</span></td>
        <td><input name="txtPrecio" type="text" id="txtPrecio" size="15" readonly value="<%=pro.getProducto_precio() %>"></td>
      </tr>
      <tr>
        <td><span class="Estilo3">Stock:</span></td>
        <td><input name="txtStock" type="text" id="txtStock" size="15" readonly value="<%=pro.getProducto_stock() %>"></td>
      </tr>
      <tr>
        <td><span class="Estilo3">Cantidad Pedir:</span></td>
        <td><input name="txtCantidadPedir" type="text" id="txtCantidadPedir" value="1" size="15"></td>
      </tr>
      <tr>
       <td><label>
        &nbsp;
        </label></td> 
        <td><label>
          <input type="submit" name="button" id="button" value="Registrar">
        </label></td>
      </tr>
    </table>

    </form>

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
