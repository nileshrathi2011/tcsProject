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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        
        String name=request.getParameter("username");
        String password=request.getParameter("password");
        String checkbox=request.getParameter("employerLogin");
        name=name.trim();
        
        System.out.println("name: "+name);
        System.out.println("password: "+ password);  
        System.out.println("checkbox: "+ checkbox );  
        
        String url="/index.html";
        
        //yaha par connection pool lekar database se data uthaunga
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        if(connection!=null)
        {
            System.out.println("connection hai bhai..");
        }
        String uname = null,pass = null;
        if(checkbox == null)
        {
            
            try {
            //yaha par queries chengi
            String query="SELECT * FROM employee WHERE email = ?";
           PreparedStatement ps= connection.prepareStatement(query);
           
           ps.setString(1,name);
           System.out.println("bro yaha bhi...");
            ResultSet rs= ps.executeQuery();
             rs.first();
            // uname = rs.getString("name");
              //System.out.println("yaha tak poch gya hai bro..");
             pass = rs.getString("password");
         //   System.out.println("name is : "+uname);
            System.out.println("pass is : "+pass);
            
            if(password.trim().equals(pass))
        {
            Employee emp= new Employee(rs.getString("name"), rs.getString("dob"),rs.getString("college"), rs.getString("email"), rs.getString("password"), rs.getString("resume"));
            System.out.println("yaha par pochch gaya");
            HttpSession session = request.getSession();
            
            session.setAttribute("emp", emp);
            url="/employeeprofile.jsp";
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        
        else
        {
            // employer login
        }
        
        
        //connection free
        pool.freeConnection(connection);
        
        
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        
    }

    

}
