/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.main;

import app.buisness.Employee;
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
public class EditEmployee extends HttpServlet {

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
       
        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("emp");
         String name = request.getParameter("name");
       String dob= request.getParameter("dob");
       String college = request.getParameter("clgname");
       String email = request.getParameter("email");
       String pass= request.getParameter("pwd");
       String cnpass= request.getParameter("cnfpwd");
       String resume = request.getParameter("upldrsm");
       String message="";
       //System.out.println("edit emplooyee me naam hai... "+ name);
       pass=pass.trim();
        String url="/editEmployee.jsp";
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query="UPDATE  employee SET name=?, email=?, dob=?, college=?, password=?, resume=? WHERE id=?";
        
        try {
            PreparedStatement ps= connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, dob);
            ps.setString(4, college);
            ps.setString(5, pass);
            ps.setString(6, resume);
            ps.setInt(7, employee.getId());
            ps.executeUpdate();
            Employee emp = new Employee(employee.getId() , name, dob, college,  email, pass ,resume);
            session.setAttribute("emp", emp);
            url="/EmployeeProfile";
            
        } catch (SQLException ex) {
            message="something went wrong please try again";
            
            Logger.getLogger(EditEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
