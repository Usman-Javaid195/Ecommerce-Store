/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.mavenproject3.servlets;
import com.mycompany.mavenproject3.entities.*;
import com.mycompany.mavenproject3.helper.FactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author usman
 */
public class RegisterServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
          try{
              String customer_Name=request.getParameter("user_name");
              String email=request.getParameter("user_email");
              String password=request.getParameter("user_password");
              String phonenumber=request.getParameter("user_phone");
              String address=request.getParameter("user_address");
              
              if(customer_Name.isEmpty())
              {
                  out.println("Name is blank");
                  return;
              }
              
              Customer customer=new Customer(customer_Name, email, address, password, phonenumber,"Normal");
              Session hibernateSession= FactoryProvider.getFactory().openSession();
              Transaction tx=hibernateSession.beginTransaction();
              int customer_id=(int)hibernateSession.save(customer);
              tx.commit();
              hibernateSession.close();
              HttpSession httpsession= request.getSession();
              httpsession.setAttribute("message", "Registration Successful!");
              response.sendRedirect("register.jsp");
              return; 
          }
          catch(Exception e){e.printStackTrace();}
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
