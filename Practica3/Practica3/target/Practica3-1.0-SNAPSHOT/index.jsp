<%-- 
    Document   : index
    Created on : 18 mar. 2022, 09:32:35
    Author     : fer y esme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inicio</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
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
                                <a class="nav-link active" aria-current="page" href="/Practica3/carrera/nuevaCarrera.jsp">Nueva Carrera</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/Practica3/AgregarAlumno">Nuevo Alumno</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/Practica3/carrera/listaDeCarreras.jsp">Listado Carreras</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/Practica3/ListadoAlumnos">Listado Alumnos</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <main>
            <div class="d-flex flex-column align-items-center mt-3">
                <img src="img/escuela.png" alt="Escuela" />
                <h3><b>Escuela web</b></h3>
                <p>El mejor lugar para aprender en línea</p>
            </div>
        </main>
    </body>
</html>
