/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.ipn.mx.modelos.dao.CarreraDAO;
import com.ipn.mx.modelos.dto.CarreraDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Fernando Mtz
 */
@WebServlet(name = "MostrarCarrera", urlPatterns = {"/MostrarCarrera"})
public class MostrarCarrera extends HttpServlet {

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
            CarreraDAO carreraDao = new CarreraDAO();
            CarreraDTO carreraDto = new CarreraDTO();
            carreraDto.getEntidad().setIdCarrera(Long.parseLong(request.getParameter("idCarrera")));
            try{
                carreraDto = carreraDao.read(carreraDto); 

            }catch(SQLException e){
                System.out.println("Error al cerrar conexion");
            }

            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet MostrarCarrera</title>"); 
                out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet'/>");
                out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'></script>");           
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='container mt-4'>");
                out.println("<main>");
                out.println("<section>");
                out.println("<h1 class='d-md-flex justify-content-md-center mt-3'>Carrera</h1>");                                                                         
                out.println("<form method='post' action='/ProyectoBase/ListadoServlet' name='frmDatos'>");
                out.println("<div class='mb-3'>");
                out.println("<label for='txtIdCarrera' class='form-label'>Id Carrera:</label>");
                out.println("<input class='form-control' value='"+carreraDto.getEntidad().getIdCarrera()+"' type='text' name='txtIdCarrera' id='txtIdCarrera' readOnly>"); 
                out.println("<label for='txtNombreCarrera' class='form-label'>Nombre de la Carrera: </label>");
                out.println("<input class='form-control' value='"+carreraDto.getEntidad().getNombreCarrera()+"' type='text' name='txtNombreCarrera' id='txtNombreCarrera' required maxlength='50' placeholder='Carrera' readOnly>");
                out.println("</div>"); 
                out.println("<div class='mb-3'>"); 
                out.println("<label for='txtDescripcionCarrera' class='form-label'>Descripcion Carrera</label>");
                out.println("<input class='form-control' value='" + carreraDto.getEntidad().getDescripcionCarrera() +"'  type='text' name='txtDescripcionCarrera' id='txtDescripcionCarrera' required maxlength='50' placeholder='Descripcion'  readOnly>");
                out.println("</div>");
                out.println("<div class='d-md-flex justify-content-md-end'>");
                out.println("<input type='submit' class='btn btn-primary' name='cmdRegresar' value='Regresar'>");
                out.println("</div>");
                out.println("</form>"); 
                out.println("</section>"); 
                out.println("</main>");
                out.println("<footer>"); 
                out.println("</footer>"); 
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
