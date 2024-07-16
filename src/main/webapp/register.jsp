<%-- 
    Document   : register
    Created on : Apr 30, 2024, 7:12:53 PM
    Author     : usman
--%>
 <%@include file="componenets/common_modals.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New User</title>
        
         <%@include file="componenets/common_css_js.jsp"%> 
    

    </head>
    <body>
        
          <%@include file="componenets/navbar.jsp"%> 
          <div class="container-fluid">
          <div class="row mt-5">
              <div class="col-md-4 offset-md-4">
                  <div class="card">
                      <%@include file="componenets/message.jsp" %>
                      <div class="card-body">
                        <h3>CREATE AN ACCOUNT</h3>
                  <form action="RegisterServlet" method="post">
                      <div class="mb-3">
                         <label for="name" class="form-label">Username</label>
                            <input name="user_name" type="text" class="form-control" id="name" placeholder="Enter here" aria-describedby="emailHelp">
                               
                       </div>
                       <div class="mb-3">
                         <label for="email" class="form-label">Email</label>
                            <input name="user_email" type="email" class="form-control" id="email" placeholder="Enter here" aria-describedby="emailHelp">
                               
                       </div>
                       <div class="mb-3">
                         <label for="password" class="form-label">Password</label>
                            <input name="user_password" type="password" class="form-control" id="password" placeholder="Enter here" aria-describedby="emailHelp">
                               
                       </div>
                       <div class="mb-3">
                         <label for="phone" class="form-label">Phone</label>
                            <input name="user_phone" type="number" class="form-control" id="phone" placeholder="Enter here" aria-describedby="emailHelp">
                               
                       </div>
                       <div class="mb-3">
                         <label for="address" class="form-label">Address</label>
                         <textarea name="user_address" style="height:200px;" class="form-control" placeholder="Enter your address"></textarea>
                       </div>
                      <div class="container text-center">
                          <button class ="btn btn-outline-success">Register</button>
                          <button class ="btn btn-outline-warning">Reset</button></div>
                  </form>
                  </div>
                  </div>
              </div>
          </div>
         </div>
    </body>
</html>
