/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.encuesta;
import modelosDAO.EncuestaDAO;

/**
 *
 * @author JosselynMartinez
 */
@WebServlet(name = "ControllerEncuesta", urlPatterns = {"/ControllerEncuesta"})
public class ControllerEncuesta extends HttpServlet {

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
        try{
        //consulta general
        EncuestaDAO encuestadao = new EncuestaDAO();
        List<encuesta> consulta = encuestadao.listar();
        
            request.setAttribute ("consulta",consulta);
            RequestDispatcher dispatcher = request.getRequestDispatcher("consulta.jsp");
            dispatcher.forward(request,response);
        
        
        /*if(consulta == null){
             processRequest(request, response);
        }*/
        }catch (Exception e) {
            e.printStackTrace();
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
        
    String action = request.getParameter("action");
        
    // Agregar
    if ("agregar".equals(action)) {
        String nombre = request.getParameter("nombre");
        String sexo = request.getParameter("sexo");
        String deporte = request.getParameter("deporte");
        String estudio = request.getParameter("estudio");
        String tema = request.getParameter("tema");
        encuesta nueva = new encuesta(nombre, sexo, deporte, estudio, tema);
        
        try {
            EncuestaDAO encuestaDao = new EncuestaDAO();
            encuestaDao.agregar(nueva);
           this.doGet(request, response);
        } catch (IOException | ClassNotFoundException | ServletException e) {
        }
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
