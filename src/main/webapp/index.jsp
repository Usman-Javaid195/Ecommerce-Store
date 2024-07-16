<%-- 
    Document   : index
    Created on : Apr 24, 2024, 7:58:27 PM
    Author     : usman
--%>
<%@page import="com.mycompany.mavenproject3.helper.Helper"%>
<%@page import="com.mycompany.mavenproject3.entities.Category"%>
<%@page import="com.mycompany.mavenproject3.dao.CategoryDao"%>
<%@page import="com.mycompany.mavenproject3.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.mavenproject3.dao.ProductDao"%>
<%@page import="com.mycompany.mavenproject3.helper.FactoryProvider" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <%@include file="componenets/common_css_js.jsp"%> 
    </head>
    <body>
        <%@include file="componenets/navbar.jsp"%> 
        <div class="row mt-3 mx-2">
            <%
               String cat=request.getParameter("category");
                ProductDao dao=new ProductDao(FactoryProvider.getFactory());
               List<Product> list=null;
               
                if(cat==null||cat.equals("all"))
                {
                list=dao.getAllProducts();
            }
            else{
            int cid=Integer.parseInt(cat.trim());
           list=dao.getAllProductsByID(cid);
            }
                
                
                CategoryDao cdao= new CategoryDao(FactoryProvider.getFactory());
               List<Category> clist= cdao.getCategories();           
            %>
            
            <!--show categories--> 
           <div class="col-md-2 mt-4">
               <div class="list-group">
                    <a href="index.jsp?category=all" class="list-group-item list-group-item-action active" aria-current="true">
    All Products
  </a>
           
               <%
                   for(Category c:clist)
                   {
                   %>
                   <a href="index.jsp?category=<%= c.getCategory_ID()%>" class="list-group-item list-group-item-action"><%=c.getCategory_name()%></a>
                   
                   
                   <%
                       }
                   %>
               </div>
               
        </div>
            <!--show products-->
       <div class="col-md-8">
    <div class="card">
        <div class="row no-gutters">
            <% for(Product p: list) { %>
            
            <div class="col-md-4">
                <img src="img/<%= p.getpPhoto() %>" class="card-img" alt="...">
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h5 class="card-title"><%= p.getpName() %></h5>
                    <p class="card-text"><%= Helper.get10Words(p.getpDesc()) %></p>
                </div>
                
           <% try{        %>
<button onclick="add_to_cart(<%=p.getProduct_ID()%>, '<%= p.getpName()%>', <%= p.getPriceAfterDiscount()%>)" class="btn custom-bg text-white mt-4" >Add to Cart</button>
                     <button class="btn btn-outline-success mt-4" >Rs. <%= p.getPriceAfterDiscount() %>/- <span class="text-secondary discount-label">Rs. <%=p.getpPrice()%> , <%=p.getpDiscount() %>% off</span></button> 
                     <% } 
                     catch(Exception e){
                     e.printStackTrace();}%>

                
            </div>
            <% } 
            if(list.size()==0)
{
out.println("<h3>No Products in this Category</h3>");
}
            
            
            %>
        </div>
    </div>  
</div>
        </div>
                 
                 
                     
            <%@include file="componenets/common_modals.jsp" %>

           
    </body>
</html>
