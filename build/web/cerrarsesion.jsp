<%-- 
    Document   : cerrarsesion
    Created on : 15-nov-2012, 19:52:38
    Author     : J.gutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<% HttpSession sesionOk = request.getSession();sesionOk.invalidate();%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cerrar sesión</title>
    </head>
    <body>
        <jsp:forward page="login.jsp"/>
    </body>
</html>
