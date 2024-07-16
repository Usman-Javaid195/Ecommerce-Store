/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.mavenproject3.servlets;

import com.mycompany.mavenproject3.dao.CategoryDao;
import com.mycompany.mavenproject3.dao.ProductDao;
import com.mycompany.mavenproject3.entities.Category;
import com.mycompany.mavenproject3.entities.Product;
import com.mycompany.mavenproject3.helper.FactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import jakarta.servlet.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

@MultipartConfig
public class ProductOperationServlet extends HttpServlet {

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
 
            //Servlet 2
            //Adding category
            //Adding product
            String op=request.getParameter("operation");
            
            if("addcategory".equals(op))
            {
                //add category section
                //fethcing category data
                String title=request.getParameter("catTitle");
                String description= request.getParameter("catDescription");
                Category category =new Category();   //created category
                category.setCategory_name(title);
                category.setCategory_description(description);
                //now need to save category to database
                CategoryDao categoryDao=new CategoryDao(FactoryProvider.getFactory());
                int catId =categoryDao.saveCategory(category);
                HttpSession httpsession=request.getSession();
                httpsession.setAttribute("message","Category added successfully!");
                response.sendRedirect("Admin.jsp");
                return;
                
            }
            else if(op.trim().equals("addproduct")){
                //adding product
               String pName= request.getParameter("pName");
                String pDesc=request.getParameter("pDesc");
                int pPrice=Integer.parseInt(request.getParameter("pPrice"));
                int pDiscount= Integer.parseInt(request.getParameter("pDiscount"));
                int pQuantity=Integer.parseInt(request.getParameter("pQuantity"));
                int catId=Integer.parseInt(request.getParameter("catId"));
                Part part =request.getPart("pPhoto");
                Product p=new Product();
                p.setpName(pName);
                p.setpDesc(pDesc);
                p.setpPrice(pPrice);
              
                p.setpDiscount(pDiscount);
                p.setpQuantity(pQuantity);
                p.setpPhoto(part.getSubmittedFileName());
                
                try{//get category by ID
                CategoryDao cdao=new CategoryDao(FactoryProvider.getFactory());
                Category category=cdao.getCategoryById(catId);
                p.setCategory(category);
                //Product save
                ProductDao pdao=new ProductDao(FactoryProvider.getFactory());
                pdao.saveProduct(p);
                //uploading pic and getting pic path
                
                String path=request.getServletContext().getRealPath("img");
                System.out.println(path); //ideal file path
                File file=new File(path); //creating a File object to check if the file path exists, if not then create it
                if(!file.exists())
                {
                    file.mkdir();
                }
                String srcimgpath="C:\\Users\\usman\\OneDrive\\Documents\\NetBeansProjects\\mavenproject3\\src\\main\\webapp\\img"+File.separator+part.getSubmittedFileName();
                String imgpath=path+File.separator+part.getSubmittedFileName();  //creating the file path of the image uploaded 
                //uploading code
                    FileOutputStream fos = new FileOutputStream(imgpath);//Loading the image in the file
                    FileOutputStream fos2=new FileOutputStream(srcimgpath);
                InputStream is= part.getInputStream();
                InputStream is2=part.getInputStream();
                //reading data
                byte[] data =new byte[is.available()];
                is.read(data);
                is2.read(data);
                //writing the data
                fos.write(data);
                fos2.write(data);
                fos.close();
                fos2.close();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                
                HttpSession httpsession=request.getSession();
                httpsession.setAttribute("message","Product Saved Successfully!");
                response.sendRedirect("Admin.jsp");
            }
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
