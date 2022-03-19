package com.ipn.mx.controlador;

import com.ipn.mx.modelos.dao.CarreraDAO;
import com.ipn.mx.modelos.dto.CarreraDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Fernando Mtz
 */
@WebServlet(name = "ListadoServlet", urlPatterns = {"/ListadoServlet"})
public class ListadoServlet extends HttpServlet {

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
            out.println("<title>Listado Carreras</title>");
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet'/>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container mt-5'>");
            
            out.println("<table class='table table-striped'>");
            out.println("<tr><th>Clave carrera</th><th>Nombre Carrera</th><th>Descripcion</th><th>Eliminar</th><th>Actualizar</th></tr>");
            
            CarreraDAO dao = new CarreraDAO();
            CarreraDTO dto = new CarreraDTO();
            try {
                List resultados = dao.readAll();
                for(int i = 0; i < resultados.size(); i++) {
                    dto = (CarreraDTO) resultados.get(i);
                    //Los links pasar parametros por metodo get al servlet
                    out.println("<tr>");
                    out.println("<td><a class='btn btn-info' href='' role='button'>"+dto.getEntidad().getIdCarrera()+"</a></td>"); //Consultar una carrera
                    out.println("<td>"+dto.getEntidad().getNombreCarrera()+"</td>");
                    out.println("<td>"+dto.getEntidad().getDescripcionCarrera()+"</td>");
                    out.println("<td><a class='btn btn-danger' href='' role='button'>"+dto.getEntidad().getIdCarrera()+"</a></td>"); //Eliminar
                    out.println("<td><a class='btn btn-primary' href='' role='button'>"+dto.getEntidad().getIdCarrera()+"</a></td>"); //Actualizar
                    out.println("</tr>");
                }

            } catch (SQLException ex) {
                out.println("<div class='alert alert-danger mt-5' role='alert'>Error al consultar todo Servlet</div>");
                System.out.println("Error al readAll en Servlet");
                ex.printStackTrace();
            }
            out.println("</table");
            out.println("</div>");
            out.println("</body>");
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
