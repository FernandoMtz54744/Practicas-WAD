package com.ipn.mx.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.ipn.mx.modelos.dao.AlumnoDAO;

import com.ipn.mx.modelos.dto.AlumnoDTO;
import com.ipn.mx.modelos.dto.CarreraDTO;
import com.ipn.mx.modelos.dao.CarreraDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 *
 * @author Fernando Mtz
 */

@WebServlet(name = "ListadoAlumnos", urlPatterns = {"/ListadoAlumnos"})
public class ListadoAlumnos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listado Alumnos</title>");
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet'/>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'></script>");
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
            out.println("<a class='nav-link active' aria-current='page' href='/ProyectoBase/AgregarAlumno'>Nueva Alumno</a>");
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

            out.println("<div class='container mt-5'>");
            out.println("<table class='table table-striped'>");
            out.println("<tr><th>Clave Alumno</th><th>Nombre</th><th>Apellido Paterno</th><th>Apellido Materno</th><th>Email</th><th>Nombre Carrera</th><th>Eliminar</th><th>Actualizar</th></tr>");
            
            AlumnoDAO dao = new AlumnoDAO();
            AlumnoDTO dto = new AlumnoDTO();
            CarreraDTO carreraDTO = new CarreraDTO();
            CarreraDAO carreraDAO = new CarreraDAO();
            try {
                List resultados = dao.readAll();
                for(int i = 0; i < resultados.size(); i++) {
                    dto = (AlumnoDTO) resultados.get(i);
                    carreraDTO.getEntidad().setIdCarrera(Long.valueOf(dto.getEntidad().getCarrera()));
                    carreraDTO = carreraDAO.read(carreraDTO);
                    //Los links pasar parametros por metodo get al servlet
                    out.println("<tr>");
                    out.println("<td><a class='btn btn-info' href='/ProyectoBase/MostrarAlumno?idAlumno="+dto.getEntidad().getIdAlumno()+"' role='button'>Consultar</a></td>"); //Actualizar
                    out.println("<td>"+dto.getEntidad().getNombreAlumno()+"</td>");
                    out.println("<td>"+dto.getEntidad().getPaternoAlumno()+"</td>");
                    out.println("<td>"+dto.getEntidad().getMaternoAlumno()+"</td>");
                    out.println("<td>"+dto.getEntidad().getEmailAlumno()+"</td>");;  
                    out.println("<td>"+carreraDTO.getEntidad().getNombreCarrera()+"</td>");  
                    out.println("<td><button type='button' class='btn btn-danger' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='setIdEliminar("+dto.getEntidad().getIdAlumno()+")'>Eliminar</button></td>"); //Eliminar
                    out.println("<td><a class='btn btn-primary' href='/ProyectoBase/ActualizarAlumno?idAlumno="+dto.getEntidad().getIdAlumno()+"' role='button'>Actualizar</a></td>"); //Actualizar
                    out.println("</tr>");
                }
            }catch (SQLException ex) {
                out.println("<div class='alert alert-danger mt-5' role='alert'>Error al consultar todo Servlet</div>");
                System.out.println("Error al readAll en Servlet");
                ex.printStackTrace();
            }
            out.println("</table");
            out.println("</div>");
            out.println("<div id='idEliminar'></div>");

            out.println("<div class='modal fade' id='exampleModal' tabindex='-1' aria-labelledby='exampleModalLabel' aria-hidden='true'>");
            out.println("<div class='modal-dialog modal-dialog-centered'>");
            out.println("<div class='modal-content'>");
            out.println("<div class='modal-header'>");
            out.println("<h5 class='modal-title' id='exampleModalLabel'>Eliminar</h5>");
            out.println("<button type='button' class='btn-close' data-bs-dismiss='modal' aria-label='Close'></button>");
            out.println("</div>");
            out.println("<div class='modal-body'>");
            out.println("<p>¿Desea eliminar este registro?</p>");
            out.println("</div>");
            out.println("<div class='modal-footer'>");
            out.println("<button type='button' class='btn btn-secondary' data-bs-dismiss='modal'>Cerrar</button>");
            out.println("<button type='button' class='btn btn-danger' onclick='sendEliminar()'>Eliminar</button>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
        
            out.println("</body>");
            out.println("<script>");
            out.println("function setIdEliminar(id){document.getElementById('idEliminar').setAttribute('valor', id);};");
            out.println("function sendEliminar(){window.location.replace('/ProyectoBase/EliminarAlumno?idAlumno='+document.getElementById('idEliminar').getAttribute('valor'));}");
            out.println("</script>");
            
            out.println("</html>");
        }
    }

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
