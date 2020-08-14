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
        Vector<Detalleventa> vectorDetalles=(Vector<Detalleventa>)session.getAttribute("detalleVenta");
        Vector<Producto> vectorStock=null;
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
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
 
  
  
  <tr>
    <td colspan="2">

      <table width="100%" border="0">
          <tr>
            <td width="68%"><h4>Nombre</h4></td>
            <td width="16%" align="right" valign="top"><h4><span class="Estilo3">Cantidad</span></h4></td>
            <td width="16%" align="right" valign="top"><h4><span class="Estilo3">Sub Total</span></h4></td>
          </tr>

          <%
            for(Detalleventa det:vectorDetalles){
                Producto pro=new Producto().buscarProducto(det.getProducto_codigo());
          %>
          <tr>
            <td><%=pro.getProducto_nombre() %></td>
            <td align="right" valign="top"><%=det.getDetventa_cantidad() %></td>
            <td align="right" valign="top"><%=det.getDetventa_subtotal() %></td>
          </tr>
          <%}%>

        </table>
    </td>
  </tr>
  <tr>
      <td colspan="2">
           &nbsp; 
      </td>
  </tr>
      <td colspan="2">
               &nbsp;&nbsp;&nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;
               &nbsp;&nbsp;&nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;
               &nbsp;&nbsp;&nbsp;  &nbsp;    &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;
               <a href="SFinalizarCompra">FINALIZAR COMPRA</a>  
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