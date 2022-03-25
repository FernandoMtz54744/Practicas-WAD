<%-- 
    Document   : eliminarCarrera
    Created on : 24 mar. 2022, 07:16:14
    Author     : darkdestiny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ipn.mx.modelo.dao.CarreraDAO" %>
<%@page import="java.sql.SQLException" %>
<%@page import="java.util.List" %>
<%@page import="com.ipn.mx.modelo.dto.CarreraDTO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
        CarreraDAO dao = new CarreraDAO();
        CarreraDTO dto = new CarreraDTO();
        dto.getEntidad().setIdCarrera(Long.parseLong(request.getParameter("id")));
        try {
            dto = dao.read(dto);
            out.println(dto);

        } catch (SQLException ex) {
            
        }
        %>
    </body>
</html>
