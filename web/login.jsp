<%-- 

--%>
<%@page contentType="text/html; charset=iso-8859-1" session="true" 
        language="java" import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
	<title>Tienda Online</title>

        <link rel="stylesheet" href="css/estilo.css">
</head>
<body>
    <header id="main-header">
		<a id="logo-header" href="login.jsp">
		<img src="Imagenes/logo2.png">
		</a> <!-- / #logo-header -->
                
		<nav>
                   <ul>
                
                <li><a href="conocenos.html">Conocenos</a></li>
                <li><a href="contacto.html">Contacto</a></li>
                <li><a href="registro.html">Registrarse</a></li>
                
			</ul>
		</nav><!-- / nav -->
                </header>
           
<section id="main-content">	
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr align="center">
    <td colspan="2"><h2>Iniciar Sesion</h2></td>
  </tr>
  <tr>
    
    <td width="625">
    <form name="frmPrincipal" method="post" action="SVerificarUsuario">
    <table width="620" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="131">Usuario</td>
        <td width="489"><input type="text" name="txtUsuario" id="txtUsuario" /></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><input type="password" name="txtClave" id="txtClave" /></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><input type="submit" name="btnEntrar" id="btnEntrar" value="Entrar" /></td>
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
	</footer>
</body>
</html>