<%-- 
    Document   : eliminarCarrera
    Created on : 24 mar. 2022, 07:16:14
    Author     : darkdestiny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ipn.mx.modelos.dao.CarreraDAO" %>
<%@page import="java.sql.SQLException" %>
<%@page import="java.util.List" %>
<%@page import="com.ipn.mx.modelos.dto.CarreraDTO" %>

<!DOCTYPE html>
<html>

<head>
    <title>Servlet EliminarCarrera</title>
    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' />
    <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'></script>
</head>

<body>
    <div class='container'>
        <% try{
                CarreraDAO carreraDao = new CarreraDAO();
                CarreraDTO carreraDto = new CarreraDTO();
                carreraDto.getEntidad().setIdCarrera(Long.parseLong(request.getParameter("idCarrera")));
                carreraDao.delete(carreraDto);
                out.println("<div class='alert alert-success mt-5' role='alert'>Se elimino correctamente la carrera</div>");
            }catch(Exception e){
                out.println("<div class='alert alert-danger mt-5' role='alert'>Error al eliminar</div>");
            }
            out.println("<a class='btn btn-primary' href='/Practica3/carrera/listaDeCarreras.jsp' role='button'>Listado de carreras</a>");   
        %>
</body>

</html>