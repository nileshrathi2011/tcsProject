/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.main;

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
public class DeleteProfile extends HttpServlet {

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
        HttpSession session =request.getSession();
        String url="/AdminProfile";
        String table= request.getParameter("table");
        int id = Integer.parseInt(request.getParameter("id"));
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query="";
        if(table.equals("employee"))
            query = "delete from status where emp_id =?";
        else if(table.equals("employer"))
            query = "delete from status where cmp_id=?";
        
        try {
           // String 
            PreparedStatement ps= connection.prepareStatement(query);
            ps.setInt(1, id);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         if(table.equals("employee"))
            query = "delete from employee where id =?";
        else if(table.equals("employer"))
            query = "delete from employer where id=?";
        
        try {
           
            PreparedStatement ps= connection.prepareStatement(query);
            
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteProfile.class.getName()).log(Level.SEVERE, null, ex);
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
