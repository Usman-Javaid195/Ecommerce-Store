<%@page import="com.mycompany.mavenproject3.entities.Customer"%>
<%
     Customer user1=(Customer)session.getAttribute("current-user");
%>


<nav class="navbar navbar-expand-lg navbar-dark custom-bg">
    
  <div class="container">
    <a class="navbar-brand" href="index.jsp">PCWorld</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
        </li>
       
        
        
      </ul>
        <ul class="navbar-nav ml-auto">
    <li class="nav-item active">
        <a class="nav-link active" aria-current="page" href="#!" data-bs-toggle="modal" data-bs-target="#cart">
            <i class="bi bi-cart "></i><span class="ml-2 cart-items"></span>
        </a>
    </li>
    <%
    if(user1==null){
    %>
    <li class="nav-item active">
        <a class="nav-link active" aria-current="page" href="login.jsp">Login</a>
    </li>
    <li class="nav-item active">
        <a class="nav-link active" aria-current="page" href="register.jsp">Register</a>
    </li>
    <% }
    else {
    %>
    <li class="nav-item active">
        <a class="nav-link active" aria-current="page" href="!#"><%=user1.getCustomer_Name()%></a>
    </li>
    <li class="nav-item active">
        <a class="nav-link active" aria-current="page" href="LogoutServlet">Logout</a>
    </li>
    <%}%>
</ul>

    </div>
  </div>
</nav>