<%-- 
    Document   : error
    Created on : 15-nov-2012, 18:52:14
    Author     : J.gutierrez
--%>
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
<title>.:PAW-Agregar Productos</title>
<style type="text/css">
<!--
body {
	background-color: #FFFF99;
}
body,td,th {
	font-family: Arial, Helvetica, sans-serif;
}
</style>
</head>
<body>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="84" bgcolor="#FF0000"><img src="img/carritorx8[1].jpg" width="84" height="77" /></td>
    <td width="716" bgcolor="#FF0000"><h1 style="color:#FFFFFF">Carrito de Compas con JSP y Sesiones</h1></td>
  </tr>
  <tr align="center">
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr align="center">
    <td colspan="2">
      <h4><a href="MostrarProductos.jsp">Consultar Productos</a> | <a href="AgregarProducto1.jsp">Agregar al Carrito</a> | <a href="SCerrarSesion">Cerrar Sesion</a> </h4></td>
  </tr>
  <tr>
    </tr>

  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
</table>
<center><h1>SUCEDIO UN ERROR HAGA CLIC <a HREF="login.jsp">AQUI PARA VOLVER</a></h1></center>
</body>
</html>