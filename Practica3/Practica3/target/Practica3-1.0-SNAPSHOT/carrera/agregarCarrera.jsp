<%-- 
    Document   : agregarCarrera
    Created on : 24 mar. 2022, 07:16:01
    Author     : darkdestiny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="com.ipn.mx.modelos.dao.CarreraDAO" %>
<%@page import="java.sql.SQLException" %>
<%@page import="com.ipn.mx.modelos.dto.CarreraDTO" %>
<!DOCTYPE html>
<html>

<head>
    <title>Registro Carrera Servlet</title>
    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' />
    <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'></script>
</head>

<body>
    <header>
        <nav class='navbar navbar-expand-lg navbar-light bg-light'>
            <div class='container-fluid'>
                <a class='navbar-brand' href='#'>Proyecto Base</a>
                <button class='navbar-toggler' type='button' data-bs-toggle='collapse'
                    data-bs-target='#navbarSupportedContent' aria-controls='navbarSupportedContent'
                    aria-expanded='false' aria-label='Toggle navigation'>
                    <span class='navbar-toggler-icon'></span>
                </button>
                <div class='collapse navbar-collapse' id='navbarSupportedContent'>
                    <ul class='navbar-nav me-auto mb-2 mb-lg-0'>
                        <li class='nav-item'>
                            <a class='nav-link active' aria-current='page' href='#'>Home</a>
                        </li>
                        <li class='nav-item'>
                            <a class='nav-link active' aria-current='page'
                                href='/ProyectoBase/carrera/nuevaCarrera.html'>Nueva Carrera</a>
                        </li>
                        <li class='nav-item'>
                            <a class='nav-link active' aria-current='page'
                                href='/ProyectoBase/ListadoServlet'>Listado Carreras</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <div class='container'>
    <%
        try {
            CarreraDAO dao =  new CarreraDAO();
            CarreraDTO dto =  new CarreraDTO();
            dto.getEntidad().setNombreCarrera(request.getParameter("txtNombreCarrera"));
            dto.getEntidad().setDescripcionCarrera(request.getParameter("txtDescripcionCarrera"));
            dao.create(dto);
            out.println("<div class='alert alert-success mt-5' role='alert'>Registro exitoso</div>");
            out.println(request.getParameter("txtNombreCarrera"));
            out.println(request.getParameter("txtDescripcionCarrera"));
            
        } catch (SQLException e) {
            out.println("<div class='alert alert-danger mt-5' role='alert'>Error al registrar</div>");
            System.out.println("Error al crear carrera Servlet");
            e.printStackTrace();
        }
    %>

<a class='btn btn-primary' href='/Practica3/carrera/listaDeCarreras.jsp' role='button'>Listado de carreras</a>
</div>
</body>
</html>
