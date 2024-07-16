/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.mavenproject3.servlets;

import com.mycompany.mavenproject3.dao.UserDao;
import com.mycompany.mavenproject3.entities.Customer;
import com.mycompany.mavenproject3.helper.FactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author usman
 */
public class LoginServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            
            //validations
            
            //Authentication
            UserDao userDao =new UserDao(FactoryProvider.getFactory());
            Customer user=  userDao.getUserEmailAndPasword(email, password);
            HttpSession httpsession= request.getSession();
            if(user==null)
            {
                out.println("<h1> Invalid Details</h1>");
                httpsession.setAttribute("message","Invalid Login Details!");
                response.sendRedirect("login.jsp");
               
            }
            else
                out.println("<h1> Welcome "+ user.getCustomer_Name()+" </h1>");
            httpsession.setAttribute("current-user",user);
            if(user.getUserType().equals("Admin")){
                response.sendRedirect("Admin.jsp");
            }
            else if(user.getUserType().equals("Normal"))
            {
                response.sendRedirect("Normal.jsp");
            }
            else
                out.println("Unidentified User Type");
            
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

