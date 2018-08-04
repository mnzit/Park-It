<%-- 
    Document   : index
    Created on : Jul 15, 2018, 1:39:52 PM
    Author     : Dell
--%>
<%@include file="shared/header.jsp"%>
</div>
    <div class="parallax display-4" style="margin-top:-100px;"></div>
     <%if (session.getAttribute("username") != null) {%>
    <a class="btn btn-success waves-light btn-small loginbtn" href="welcome.jsp" role="button">Proceed to system</a>
    <%}else{%>
     <a class="btn btn-success waves-light btn-small loginbtn" href="login.jsp" role="button">Login</a>
    <%}%>
    <div class="container">
<div class="jumbotron jumbotron-fluid text-center">
  <div class="container">
  <p class="lead">Currently park it has only login priviledges to staffs for parking management we'll soon add features to book your parking location <i>ON THE GO</i></p>
  <hr class="my-4">
  <p>Secure your wheels</p>
  </div>
</div>
</div>
<%@include file="shared/footer.jsp"%>	
