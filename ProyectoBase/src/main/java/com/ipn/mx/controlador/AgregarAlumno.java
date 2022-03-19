/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import com.ipn.mx.modelos.dao.AlumnoDAO;
import com.ipn.mx.modelos.dao.CarreraDAO;
import com.ipn.mx.modelos.dto.AlumnoDTO;
import com.ipn.mx.modelos.dto.CarreraDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando Mtz
 */
@WebServlet(name = "AgregarAlumno", urlPatterns = {"/AgregarAlumno"})
public class AgregarAlumno extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
       String idCarrera="";
        
        List carrerasID = new ArrayList(); 
            CarreraDAO carreraDAO = new CarreraDAO();
        try{
            carrerasID = carreraDAO.readAll();
        }
        catch(SQLException e){}
        
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registrar alumno</title>");
            out.println("<meta http-equiv='Content-Type' content='text/html;charset=utf-8'/>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet'/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<header>");
            out.println("<nav class='navbar navbar-expand-lg navbar-light bg-light'>");
            out.println("<div class='container-fluid'>");
            out.println("<a class='navbar-brand' href='#'>Proyecto Base</a>");
            out.println("<button class='navbar-toggler' type='button' data-bs-toggle='collapse' data-bs-target='#navbarSupportedContent' aria-controls='navbarSupportedContent' aria-expanded='false' aria-label='Toggle navigation'>");
            out.println("<span class='navbar-toggler-icon'></span>");
            out.println("</button>");
            out.println("<div class='collapse navbar-collapse' id='navbarSupportedContent'>");
            out.println("<ul class='navbar-nav me-auto mb-2 mb-lg-0'>");
            out.println("<li class='nav-item'>");
            out.println("<a class='nav-link active' aria-current='page' href='#'>Home</a>");
            out.println("</li>");
            out.println("<li class='nav-item'>");
            out.println("<a class='nav-link active' aria-current='page' href='/ProyectoBase/carrera/nuevaCarrera.html'>Nueva Carrera</a>");
            out.println("</li>");
            out.println("<li class='nav-item'>");
            out.println("<a class='nav-link active' aria-current='page' href='/ProyectoBase/AgregarAlumno'>Nuevo Alumno</a>");
            out.println("</li>");
            out.println("<li class='nav-item'>");
            out.println("<a class='nav-link active' aria-current='page' href='/ProyectoBase/ListadoServlet'>Listado Carreras</a>");
            out.println("</li>");
            out.println("<li class='nav-item'>");
            out.println("<a class='nav-link active' aria-current='page' href='/ProyectoBase/ListadoAlumnos'>Listado Alumnos</a>");
            out.println("</li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");
            out.println("</nav>");
            out.println("</header>");
            out.println("<div class='container'>");
            out.println("<main>");
            out.println("<section>");
            out.println("<h1 class='d-md-flex justify-content-md-center'>Registro de un nuevo Alumno</h1>");
            out.println("<form method='post' action='/ProyectoBase/AgregarAlumno' name='frmDatos' accept-charset='UTF-8'>");
            out.println("<div class='mb-3'>");
            out.println("<label for='txtNombreAlumno' class='form-label'>Nombre del Alumno: </label>");
            out.println("<input class='form-control' type='text' name='txtNombreAlumno' id='txtNombreAlumno' required maxlength='50' placeholder='Alumno'>");
            out.println("</div>");
            out.println("<div class='mb-3'>");
            out.println("<label for='txtPaternoAlumno' class='form-label'>Apellido Paterno: </label>");
            out.println("<input class='form-control' type='text' name='txtPaternoAlumno' id='txtPaternoAlumno' required maxlength='50' placeholder='Paterno'>");
            out.println("</div>");
            out.println("<div class='mb-3'>");
            out.println("<label for='txtMaternoAlumno' class='form-label'>Apellido Materno: </label>");
            out.println("<input class='form-control' type='text' name='txtMaternoAlumno' id='txtMaternoAlumno' required maxlength='50' placeholder='Paterno'>");
            out.println("</div>");
            out.println("<div class='mb-3'>");
            out.println("<label for='txtEmailAlumno' class='form-label'>Email: </label>");
            out.println("<input class='form-control' type='email' name='txtEmailAlumno' id='txtEmailAlumno' required maxlength='50' placeholder='Email'>");
            out.println("</div>");
            out.println("<div class='mb-3'>");
            out.println("<label for='selectCarrera' class='form-label'>Seleccione la carrera</label>");
            out.println("<select class='form-select' aria-label='Default select example' id='selectCarrera' name='selectCarrera'>");
            out.println("<option selected>Carrera</option>");
            for(int i=0; i<carrerasID.size(); i++){
                out.println("<option value='" + ((CarreraDTO)carrerasID.get(i)).getEntidad().getIdCarrera() + "'>" + ((CarreraDTO)carrerasID.get(i)).getEntidad().getNombreCarrera() + "</option>");
            }

            out.println("</select>");
            out.println("</div>");
            out.println("<div class='d-md-flex justify-content-md-end'>");
            out.println("<input type='submit' class='btn btn-primary' name='cmdEnviar' value='Registrar'>");
            out.println("</div>");
            out.println("</form>");
            out.println("</section>");
            out.println("</main>");
            out.println("<footer>");
            out.println("</footer>");
            out.println("</div>");
            out.println("<script src='https://unpkg.com/@popperjs/core@2'></script>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'></script>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        alumnoDTO.getEntidad().setNombreAlumno(request.getParameter("txtNombreAlumno"));
        alumnoDTO.getEntidad().setPaternoAlumno(request.getParameter("txtPaternoAlumno"));
        alumnoDTO.getEntidad().setMaternoAlumno(request.getParameter("txtMaternoAlumno"));
        alumnoDTO.getEntidad().setEmailAlumno(request.getParameter("txtEmailAlumno"));
        alumnoDTO.getEntidad().setCarrera(Integer.parseInt(request.getParameter("selectCarrera")));
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrarAlumno</title>"); 
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet'/>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'></script>");           
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            try{
                alumnoDAO.create(alumnoDTO);
                out.println("<div class='alert alert-success mt-5' role='alert'>Se agregó correctamente el alumno</div>");
            }
            catch(SQLException e){
                out.println("<div class='alert alert-danger mt-5' role='alert'>Error al agregar alumno</div>");
            }
            out.println("<a class='btn btn-primary' href='/ProyectoBase/ListadoAlumnos' role='button'>Listado de alumnos</a>"); 
            out.println("</body>"); 
            out.println("</html>"); 
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
