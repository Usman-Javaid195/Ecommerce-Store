<%
     Customer user=(Customer)session.getAttribute("current-user");
    if(user==null)
    {
    session.setAttribute("message","You are not logged in. Please Login first.");
    response.sendRedirect("login.jsp");
    return;
}
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                 <%@include file="componenets/common_css_js.jsp"%> 

        <title>Checkout</title>
    </head>
    <body>
                 <%@include file="componenets/navbar.jsp"%> 
                 <div class="container">
                     <div class="row mt-5">
                         <div class="col-md-6">
                             <!--Cart info-->
                             <div class="card">
                                 <div class="card-body">
                                     <h3 class="text-center mb-3">
                                         Your selected items
                                     </h3>
                                     <div class="cart-body">
                                         
                                     </div>
                                 </div>
                             </div>
                         </div>
                         <div class="col-md-6">
                             <!--form details-->
                             <div class="card">
                                 <div class="card-body">
                                     <h3 class="text-center mb-3">
                                         Your details for order
                                     </h3>
                                     <form action="!#">
                                         
                                                <label for="exampleInputEmail1" class="form-label">Email address</label>
                                                <input value="<%=user.getEmail()%>" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                                                <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                                              
                                                                                     <div class="mb-3">
                                                <label for="name" class="form-label">Your name</label>
                                                <input value="<%=user.getCustomer_Name()%>" type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter name">
                                              </div>
                                                <div class="mb-3">
                                                <label for="name" class="form-label">Your phone number</label>
                                                <input value="<%=user.getPhonenumber()%>" type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter contact number">
                                              </div>
                                                                                     <div class="mb-3">
                                              <label for="exampleFormControlTextarea1" class="form-label">Your Shipping address</label>
                                              <textarea value="<%=user.getAddress()%>"class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="Enter your address"></textarea>
                                            </div>
                                         <div class="container text-center">
                                             <button class="btn btn-outline-success" onclick="removeItems()"><a href="Ordered.jsp">Order now</a></button>
                                             <button class="btn btn-outline-primary"> <a href="index.jsp">Continue Shopping</a></button>
                                         </div>
                                     </form>
                                     
                                 </div>
                             </div>
                             
                             
                             
                             
                             
                         </div>
                     </div>
                 </div>
        
      
                 
    </body>
</html>
