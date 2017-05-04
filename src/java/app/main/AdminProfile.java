/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.main;

import app.buisness.Employee;
import app.buisness.Employer;
import app.data.ConnectionPool;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class AdminProfile extends HttpServlet {

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
        HttpSession session  = request.getSession();
        String url="/adminProfile.jsp";
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query1="select * from employee";
        try {
            PreparedStatement ps= connection.prepareStatement(query1);
            ResultSet rs= ps.executeQuery();
            List<Employee> employeeList = new ArrayList<Employee>();
            while(rs.next())
            {
                Employee employee = new Employee(rs.getInt("id"), rs.getString("name"),rs.getString("dob"),rs.getString("college") ,rs.getString("email"), rs.getString("resume"), rs.getString("password"));
                employeeList.add(employee);
            }
            session.setAttribute("employeeList", employeeList);
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String query2="select * from employer";
        try {
            PreparedStatement ps2= connection.prepareStatement(query2);
            ResultSet rs2= ps2.executeQuery();
            List<Employer> employerList = new ArrayList<Employer>();
            while(rs2.next())
            {
                Employer employer = new Employer(rs2.getInt("id"), rs2.getString("name"), rs2.getString("company_name"), rs2.getString("email"), rs2.getString("website"), rs2.getString("job_profile"), rs2.getString("skills_required"), rs2.getString("password"));
                employerList.add(employer);
            }
            session.setAttribute("employerList", employerList);
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminProfile.class.getName()).log(Level.SEVERE, null, ex);
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
