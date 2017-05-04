/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.main;

import app.buisness.Employee;
import app.data.ConnectionPool;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
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
public class ApplyForPosition extends HttpServlet {

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
            Employee emp = (Employee) session.getAttribute("emp");
            String message=" ";
            String url="/OpeningsServlet";
            ConnectionPool pool=ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            if(emp!=null)
            {
                //employee already logged in
                int emp_id = emp.getId();
                int cmp_id = Integer.parseInt(request.getParameter("employerId"));
                String query="insert into status values(?,?,'Applied')";
                try {
                    PreparedStatement ps= connection.prepareStatement(query);
                    ps.setInt(1, emp_id);
                    ps.setInt(2, cmp_id);
                      ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(ApplyForPosition.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else
            {
                //send a message to log in first
                message="Either Login Or Register First";
                request.setAttribute("message", message);
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
