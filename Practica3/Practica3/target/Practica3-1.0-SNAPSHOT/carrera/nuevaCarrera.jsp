<%-- 
    Document   : nuevaCarrera
    Created on : 24 mar. 2022, 07:15:45
    Author     : darkdestiny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registrar carrera</title>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Proyecto Base</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/ProyectoBase/carrera/nuevaCarrera.html">Nueva Carrera</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/ProyectoBase/AgregarAlumno">Nuevo Alumno</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/ProyectoBase/ListadoServlet">Listado Carreras</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/ProyectoBase/ListadoAlumnos">Listado Alumnos</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <div class="container">
            <main>
                <section>
                    <h1 class="d-md-flex justify-content-md-center mt-3">Registro de una nueva Carrera</h1>
                    <form action="/Practica3/carrera/agregarCarrera.jsp" name="frmDatos" accept-charset="UTF-8">
                        <div class="mb-3">
                            <label for="txtNombreCarrera" class="form-label">Nombre de la Carrera: </label>
                            <input class="form-control" type="text" name="txtNombreCarrera" id="txtNombreCarrera" required maxlength="70" placeholder="Carrera">
                        </div>
                        <div class="mb-3">
                            <label for="txtDescripcionCarrera" class="form-label">Descripción Carrera</label>
                            <input class="form-control" type="text" name="txtDescripcionCarrera" id="txtDescripcionCarrera" required maxlength="500" placeholder="Descripcion">
                        </div>
                        <div class="d-md-flex justify-content-md-end">
                            <input type="submit" class="btn btn-primary" name="cmdEnviar" value="Registrar">
                        </div>
                    </form>
                </section>
            </main>
            <footer>

            </footer>
        </div>
    </body>
</html>

