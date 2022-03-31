<%-- 
    Document   : listaDeCarreras
    Created on : 24 mar. 2022, 07:15:23
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Carrera</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Escuela Web</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/ProyectoBase_3/carrera/nuevaCarrera.jsp">Nueva Carrera</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/ProyectoBase_3/AgregarAlumno">Nuevo Alumno</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/ProyectoBase_3/carrera/listaDeCarreras.jsp">Listado Carreras</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/ProyectoBase_3/ListadoAlumnos">Listado Alumnos</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <div class="container">
            <div class="mb-3"></div>
            <div class="card border-primary">
                <div class="card-header text-primary">
                    <h1 class="text-center">
                        Listado de Carreras
                    </h1>
                </div>
                <div class="card-body text-primary">
                    <a href="nuevaCarrera.jsp" class="btn btn-outline-primary">Nuevo</a>   
                    <table class="table table-striped">
                        <tr>
                            <th>Clave de la Carrera</th>
                            <th>Nombre de la Carrera</th>
                            <th>Descripción de la Carrera</th>
                            <th>Eliminar</th>
                            <th>Actualizar</th>

                        </tr>
                        <%
                        CarreraDAO dao = new CarreraDAO();
                        List lista = dao.readAll();
                        if(lista != null){
                            for(int i =0; i < lista.size(); i++){
                                CarreraDTO dto = (CarreraDTO) lista.get(i);
                            %>
                            <tr>
                                <td>
                                     <a href="verCarrera.jsp?id=<%= dto.getEntidad().getIdCarrera() %>" class="btn btn-outline-info">
                                        <%= dto.getEntidad().getIdCarrera() %>
                                    </a>
                                </td>
                                <td>
                                    <%=dto.getEntidad().getNombreCarrera() %>
                                </td>
                                <td>
                                    <%= dto.getEntidad().getDescripcionCarrera() %>
                                </td>
                                <td>
                                    <button type='button' class='btn btn-danger' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick="setIdEliminar(<%=dto.getEntidad().getIdCarrera()%>)">Eliminar</button>
                                </td>
                                <td>
                                    
                                    <a href="actualizarCarrera.jsp?id=<%= dto.getEntidad().getIdCarrera() %>" class="btn btn-outline-success">
                                        Actualizar
                                    </a>
                                </td>
                            </tr>
                            
                            <%
                            }
                        }else{
                            out.println("<td colspan=5> No hay registros a mostrar </td>");
                        }

                        %>


                    </table>
                        
                        
                        <!<!-- Aqui va modal -->    
                        
                        <div id='idEliminar'></div>
                        <div class='modal fade' id='exampleModal' tabindex='-1' aria-labelledby='exampleModalLabel' aria-hidden='true'>
                        <div class='modal-dialog modal-dialog-centered'>
                        <div class='modal-content'>
                        <div class='modal-header'>
                        <h5 class='modal-title' id='exampleModalLabel'>Eliminar</h5>
                        <button type='button' class='btn-close' data-bs-dismiss='modal' aria-label='Close'></button>
                        </div>
                        <div class='modal-body'>
                        <p>¿Desea eliminar este registro?</p>
                        </div>
                        <div class='modal-footer'>
                        <button type='button' class='btn btn-secondary' data-bs-dismiss='modal'>Cerrar</button>
                        <button type='button' class='btn btn-danger' onclick='sendEliminar()'>Eliminar</button>
                        </div>
                        </div>
                        </div>
                        </div>
            
                </div>
            </div>

        </div>
    </body>
    <script>
    function setIdEliminar(id){document.getElementById('idEliminar').setAttribute('valor', id);}
    function sendEliminar(){window.location.replace('/Practica3/carrera/eliminarCarrera.jsp?idCarrera='+document.getElementById('idEliminar').getAttribute('valor'));}
    </script> 
</html>