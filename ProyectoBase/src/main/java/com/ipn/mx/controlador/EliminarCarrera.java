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
 * @author Jaime Cortes
 * @author Esmeralda Godinez
 * @author Fernando Mtz
 */
@WebServlet(name = "EliminarCarrera", value = {"/EliminarCarrera"})
public class EliminarCarrera extends HttpServlet {

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
       
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EliminarCarrera</title>"); 
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet'/>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'></script>");           
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            try{
                carreraDao.delete(carreraDto);
                out.println("<div class='alert alert-success mt-5' role='alert'>Se elimino correctamente el registro</div>");
            }catch(Exception e){
                out.println("<div class='alert alert-danger mt-5' role='alert'>Error al eliminar</div>");
            }
                out.println("<a class='btn btn-primary' href='/ProyectoBase/ListadoServlet' role='button'>Listado de carreras</a>"); 
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
