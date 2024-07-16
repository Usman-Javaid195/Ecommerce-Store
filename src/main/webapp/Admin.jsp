<%@page import="java.util.Map"%>
<%@page import="com.mycompany.mavenproject3.helper.Helper"%>
<%@page import="com.mycompany.mavenproject3.entities.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.mavenproject3.helper.FactoryProvider"%>
<%@page import="com.mycompany.mavenproject3.dao.CategoryDao"%>
<%@page import="com.mycompany.mavenproject3.entities.Customer" %>
<%
    
    Customer user=(Customer)session.getAttribute("current-user");
    if(user==null)
    {
    session.setAttribute("message","You are not logged in. Please Login first.");
    response.sendRedirect("login.jsp");
    return;
    
 }
 else
 {
    if(user.getUserType().equals("Normal")){
    session.setAttribute("message", "You are not admin.");
    response.sendRedirect("login.jsp");
    return;
}
}
%>
 <%@include file="componenets/common_modals.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
                  CategoryDao ccdao=new CategoryDao(FactoryProvider.getFactory());
                  List<Category> list=ccdao.getCategories();
                  //getting count
                 Map<String,Integer>m= Helper.getCounts(FactoryProvider.getFactory());
                    %>
                    
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
         <%@include file="componenets/common_css_js.jsp"%> 
    </head>
    
    <body>
         <%@include file="componenets/navbar.jsp"%> 
         <div class="container Admin mt-3">
             <div class="container-fluid">
                 <%@include file="componenets/message.jsp" %>
             </div>
             <div class="row mt-3">
                 <!-- column 1 -->
                 <div class="col-md-4">
                     <div class="card">
                        
                         <div class="card-body text-center">
                             <div class="container">
                                 <img style="max-width: 125px"class="image-fluid rounded-circle" src="img/Users.png" alt="user_icon"/>
                             </div>
                             <h1><%=m.get("userCount")%></h1>
                              <h1 class="text-uppercase text-muted">Users</h1>
                         </div>
                     </div>
                     
                     
                 </div>
                  <!-- column 2 -->
                 <div class="col-md-4">
                     <div class="card">
                        
                         <div class="card-body text-center">
                               <div class="container">
                                 <img style="max-width: 125px"class="image-fluid " src="img/Category.png" alt="category_icon"/>
                             </div>
                             <h1><%=list.size()%></h1>
                              <h1 class="text-uppercase text-muted">Categories</h1>
                         </div>
                     </div>
                     
                     
                     
                 </div>
                  <!-- column 3 -->
                 <div class="col-md-4">
                     <div class="card">
                        
                         <div class="card-body text-center">
                               <div class="container">
                                 <img style="max-width: 125px"class="image-fluid " src="img/Product.png" alt="product_icon"/>
                             </div>
                             <h1><%=m.get("productCount")%></h1>
                              <h1 class="text-uppercase text-muted" >Products</h1>
                         </div>
                     </div>
                     
                     
                     
                 </div>
                 
             </div>
             <div class="row mt-3">
                 <div class="col-md-6">
                      <div class="card">
                        
                         <div class="card-body text-center" data-bs-toggle="modal" data-bs-target="#add-category-modal">
                               <div class="container">
                                 <img style="max-width: 125px"class="image-fluid " src="img/plus.png" alt="addCategory_icon"/>
                             </div>
                              <h1 class="text-uppercase text-muted" >Add Category</h1>
                         </div>
                     </div>
                 </div>
                 <div class="col-md-6">
                      <div class="card">
                        
                         <div class="card-body text-center" data-bs-toggle="modal" data-bs-target="#add-product-modal">
                               <div class="container">
                                 <img style="max-width: 125px"class="image-fluid " src="img/addProduct.png" alt="addProduct_icon"/>
                             </div>

                              <h1 class="text-uppercase text-muted" >Add Product</h1>
                         </div>
                     </div>
                 </div>
             </div>
         </div>
         <!-- Add Category modal -->
         <!-- Button trigger modal -->

<!-- Modal -->
<div class="modal fade" id="add-category-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header custom-bg text-white">
        <h5 class="modal-title" id="exampleModalLabel">Fill category details</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
          <form action="ProductOperationServlet" method="post">
              <input type="hidden" name="operation" value="addcategory">
              <div class="form-group">
                  <input type="text" class="form-control" name="catTitle" placeholder="Enter category title" required/>
                  
              </div>
              <div class="form-group">
                  <textarea style="height:300px" class="form-control mt-2" placeholder="Enter category description" name="catDescription" required></textarea>
              </div>
              <div class="container text-center">
                  <button class="btn btn-outline-success">Add Category</button>
                   <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
       
              </div>
          </form>
      </div>
   
    </div>
  </div>
</div>
<!-- Product Modal -->
<div class="modal fade" id="add-product-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header custom-bg text-white">
        <h5 class="modal-title" id="exampleModalLabel">Product details</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
          <form action="ProductOperationServlet" method="post" enctype="multipart/form-data">
              <input type="hidden" name="operation" value="addproduct"/>
              <div class="form-group">
                  <input type="text" class="form-control" name="pName" placeholder="Enter product name" required/>
                  
              </div>
              <div class="form-group">
                  <textarea style="height:100px" class="form-control mt-2" placeholder="Enter prodcut description" name="pDesc" required></textarea>
              </div>
              <div class="form-group">
                  <input type="number" class="form-control mt-2" name="pPrice" placeholder="Enter product price" required/>
                  
              </div>
              <div class="form-group">
                  <input type="text" class="form-control mt-2" name="pDiscount" placeholder="Enter product discount" required/>
                  
              </div>
              <div class="form-group">
                  <input type="text" class="form-control mt-2" name="pQuantity" placeholder="Enter product quantity" required/>
                  
              </div>
              
              <div class="form-group">  
                 
                  <select name="catId" class="form-control" id="">
                      <%
                          for(Category c:list){
                          
                          %>
                      <option value="<%= c.getCategory_ID()%>"><%= c.getCategory_name()%></option>
                      <% }%>
                      
                  </select>
              </div>
              <div class="form-group">
                  <label for="pPid">Select picture of product</label>
                  <input type="file" id="pPhoto" name="pPhoto" required />
              </div>
              <div class="container text-center">
                  <button class="btn btn-outline-success">Add Product</button>
                   <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
       
              </div>
          </form>
      </div>
   
    </div>
  </div>
</div>
    </body>
</html>
