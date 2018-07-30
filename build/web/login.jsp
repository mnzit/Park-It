<%-- 
    Document   : login
    Created on : Jul 15, 2018, 1:40:12 PM
    Author     : Dell
--%>

<%@include file="header.jsp"%>

<form method="post" class="form-signin mt-5 text-center" action="Login" autocomplete="off">
    <img class="" src="img/Logo.png" alt="" width="170" height="100">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-warning alert-dismissible fade show" role="alert">
            <c:out value="${errorMessage}"/>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <div class="input-field col s6">
        <input name ="uname" id="UId" type="number" class="validate" required autofocus>
        <label for="username">User Id</label>
    </div>
    <div class="input-field col s6">
        <input id="last_name" type="password" name ="upass" class="validate" required>
        <label for="password">Password</label>
    </div>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>
<%@include file="footer.jsp"%>	
