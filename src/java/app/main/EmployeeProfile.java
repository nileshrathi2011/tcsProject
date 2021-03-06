/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.main;

import app.buisness.Employee;
import app.buisness.EmployeeStatus;
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
public class EmployeeProfile extends HttpServlet {

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
        Employee emp = (Employee)session.getAttribute("emp");
        int sid=emp.getId();
        String url="/index.html";
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        String query ="select employer.company_name , status.status from employer , status where status.emp_id = ? and status.cmp_id=employer.id ";
        System.out.println("Employee profile me yaha tak.....");
        System.out.println("Employee Email = " +emp.getEmail()+ " Employee Id= "+ emp.getId());
        try {
            PreparedStatement ps= connection.prepareStatement(query);
            ps.setInt(1,emp.getId());
            ResultSet rs= ps.executeQuery();
            List<EmployeeStatus> empStatList= new ArrayList<EmployeeStatus>();
            while(rs.next())
            {
                EmployeeStatus empStat = new EmployeeStatus();
                empStat.setCompanyName(rs.getString("company_name"));
                empStat.setStatus(rs.getString("status"));
                empStatList.add(empStat);
            } 
            session.setAttribute("empStatList", empStatList);
            url="/employeeprofile.jsp";
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeProfile.class.getName()).log(Level.SEVERE, null, ex);
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
