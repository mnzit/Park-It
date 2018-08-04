<%-- 
    Document   : editstaff
    Created on : Jul 15, 2018, 10:47:43 PM
    Author     : Dell
--%>
<%           response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expries", "0");
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<%@include file="shared/header.jsp"%>
<div class="jumbotron mt-4">
    <h1 class="display-4 text-center demo"></h1>
    <c:forEach items="${staffbyid}" var="s">
        <form method="post" action="StaffController" autocomplete="off">
            <div class="form-row text-center">
                <div class="form-group col-md-1">
                    <label>Staff id</label>
                    <input readonly="readonly" type="number" value="${s.staff_id}" name="staff_id" class="form-control" placeholder="Name">
                </div>
                <div class="form-group col-md-5">
                    <label>Name</label>
                    <input type="text" value="${s.name}" name="name" class="form-control" placeholder="Name">
                </div>
                <div class="form-group col-md-6">
                    <label>Password</label>
                    <input type="password" value="${s.password}" name="password" class="form-control" placeholder="password">
                </div>
                <div class="form-group col-md-3">
                    <label>Salary</label>
                    <input type="number" value="${s.salary}" name="salary" class="form-control" placeholder="Salary">
                </div>
                <div class="form-group col-md-3">
                    <label>Phone no</label>
                    <input type="number" value="${s.phone_no}" name="phone_no" class="form-control"  placeholder="Phone no" min="10">
                </div>
                <div class="form-group col-md-3">
                    <label>Address</label>
                    <input type="text" value="${s.address}" name="address" class="form-control" placeholder="Address">
                </div>
                <div class="form-group col-md-3">
                    <label>Citizenship no</label>
                    <input type="text" value="${s.citizenship_no}" name="citizenship_no" class="form-control" placeholder="Citizenship no">
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
    </div>
</div>
</div>
</form>
</c:forEach>
</div>
<%@include file="shared/footer.jsp"%>	
