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
    if(user.getUserType().equals("Admin")){
    session.setAttribute("message", "You are not normal.");
    response.sendRedirect("login.jsp");
    return;
}
if(user.getUserType().equals("Normal")){
response.sendRedirect("index.jsp");
}
}
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Normal</title>
          <%@include file="componenets/common_css_js.jsp"%> 
    </head>
    <body>
          <%@include file="componenets/navbar.jsp"%> 
        <h1>Normal Page</h1>
    </body>
</html>
