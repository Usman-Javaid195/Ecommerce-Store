
 <%@include file="componenets/common_modals.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
           <%@include file="componenets/common_css_js.jsp"%> 
          
    </head>
    <body>
        <%@include file="componenets/navbar.jsp"%> 
        <div class="container">
            <div class="row">
                <div class="col-md-6 offset-3">
                    <div class="card mt-3">
                        <div class="card-header custom-bg text-white">
                            <h2>Login</h2>
                        </div>
                        <div class="card-body">
                            <form action="LoginServlet" method="post">
                                <%@include file="componenets/message.jsp" %>
                                <div class="mb-3">
                                  <label for="exampleInputEmail1" class="form-label">Email address</label>
                                  <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                                  <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                                </div>
                                <div class="mb-3">
                                  <label for="exampleInputPassword1" class="form-label">Password</label>
                                  <input name="password" type="password" class="form-control" id="exampleInputPassword1">
                                </div>
                                <a href="register.jsp"> Create your account</a>
                                <div class="container text-center"> 
                                    <button type="submit" class="btn btn-primary custom-bg border-0">Submit</button>
                                <button type="reset" class="btn btn-primary custom-bg border-0">Reset</button>
                                </div>
                              </form>
                        </div>
                        
                    </div>
                </div>
               
                    
            </div>
        </div>
    </body>
</html>
