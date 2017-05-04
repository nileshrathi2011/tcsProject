/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.main;

import app.buisness.Employer;
import app.data.ConnectionPool;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nilesh rathi
 */
public class EditEmployer extends HttpServlet {

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
        HttpSession session = request.getSession();
        Employer employer = (Employer) session.getAttribute("employer");
         String name = request.getParameter("name");
                String CompanyName = request.getParameter("cmpname");
                String email = request.getParameter("email");
                String companyWeb = request.getParameter("cmpweb");
                String jobProfile = request.getParameter("jp");
                String skills = request.getParameter("skills");
                String password = request.getParameter("pwd");
                String cnfPassword = request.getParameter("cnfpwd");
                String message="";
                String url="/editEmployer.jsp";
                password=password.trim();
                
                ConnectionPool pool=ConnectionPool.getInstance();
                     Connection connection = pool.getConnection();
                     String query="UPDATE  employer SET website=?, email=?, name=?, company_name=?, job_profile=?, skills_required=?, password=? WHERE id=?";
        try {
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,companyWeb );
            ps.setString(2,email);
            ps.setString(3, name);
            ps.setString(4, CompanyName);
            ps.setString(5,jobProfile );
            ps.setString(6, skills );
            ps.setString(7, password);
            ps.setInt(8,employer.getId());
            ps.executeUpdate();
            Employer employerUpdated = new Employer(employer.getId(),name,CompanyName,email, companyWeb, jobProfile,skills,password);
            session.setAttribute("employer",employerUpdated);
            url="/EmployerProfile";
        } catch (SQLException ex) {
            Logger.getLogger(EditEmployer.class.getName()).log(Level.SEVERE, null, ex);
             message="Sorry! Something went wrong with the server .. please try again";
                        request.setAttribute("message", message);
        }
        
        pool.freeConnection(connection);
         request.setAttribute("message", message);
       getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
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
