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
public class OpeningsServlet extends HttpServlet {

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
        
      HttpSession session = request.getSession(false);
       Employee emp = (Employee) session.getAttribute("emp");
       String url="/openings.jsp";
       String message= request.getParameter("message");
               if(message!=null)
               {
                   request.setAttribute("message", message);
               }
       ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
       if(emp!=null)
       {
           //emp already   logged in..
           int emp_id=emp.getId();
           
           String query="select * from employer where id not in ( select cmp_id from status where status.emp_id=?)";
           try {
               System.out.println("Empoyee id is "+ emp.getId());
               PreparedStatement ps= connection.prepareStatement(query);
               ps.setInt(1, emp_id);
                ResultSet rs= ps.executeQuery();
                List<Employer> employer_list= new ArrayList<Employer>();
                while(rs.next())
                {
                 Employer employer = new  Employer(rs.getInt("id"), rs.getString("name"), rs.getString("company_name"), rs.getString("email"), rs.getString("website"), rs.getString("job_profile"), rs.getString("skills_required"), rs.getString("password"));
                 employer_list.add(employer);
                }
                session.setAttribute("employer_list", employer_list);
                
           } catch (SQLException ex) {
               Logger.getLogger(OpeningsServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }
       else
       {
           //list all openings
           String query = "select *  from employer";
           try {
               PreparedStatement ps= connection.prepareStatement(query);
               ResultSet rs= ps.executeQuery();
               List<Employer> employer_list= new ArrayList<Employer>();
                while(rs.next())
                {
                 Employer employer = new  Employer(rs.getInt("id"), rs.getString("name"), rs.getString("company_name"), rs.getString("email"), rs.getString("website"), rs.getString("job_profile"), rs.getString("skills_required"), rs.getString("password"));
                 employer_list.add(employer);
                }
                session.setAttribute("employer_list", employer_list);
           } catch (SQLException ex) {
               Logger.getLogger(OpeningsServlet.class.getName()).log(Level.SEVERE, null, ex);
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
