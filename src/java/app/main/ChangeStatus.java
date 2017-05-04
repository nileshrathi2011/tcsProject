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
import java.sql.ResultSet;
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
public class ChangeStatus extends HttpServlet {

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
        int employeeId = Integer.parseInt(request.getParameter("applicantId"));
       Employer employer = (Employer)session.getAttribute("employer");
       int employerId = employer.getId();
       System.out.println("empoyee id = " + employeeId);
       System.out.println("empoyer id = " + employerId);
       String url="/EmployerProfile";
       // check which button is clicked
       ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
       String action = request.getParameter("action");
       if(action.equals("shortlist"))
       {
           // change status in status table
           
        String qry="update status set status='Shortlisted' where emp_id= ? and cmp_id= ? ";
                try {
                    PreparedStatement ps= connection.prepareStatement(qry);
                    
                    ps.setInt(1,employeeId);
                    ps.setInt(2,employerId);
                    ps.executeUpdate();
                    System.out.println("shortliste tak pohoch gya..");
                } catch (SQLException ex) {
                    Logger.getLogger(ChangeStatus.class.getName()).log(Level.SEVERE, null, ex);
                }
           
       }
       else if(action.equals("reject"))
       {
           
        String qry="update status set status='Rejected' where emp_id= ? and cmp_id= ? ";
                try {
                    PreparedStatement ps= connection.prepareStatement(qry);
                      ps.setInt(1,employeeId);
                    ps.setInt(2,employerId);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(ChangeStatus.class.getName()).log(Level.SEVERE, null, ex);
                }
       }
        
        pool.freeConnection(connection);
        
        
        
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
