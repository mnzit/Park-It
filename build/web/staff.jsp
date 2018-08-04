<%-- 
    Document   : staff
    Created on : Jul 15, 2018, 8:37:32 PM
    Author     : Dell
--%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expries", "0");

    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<%@include file="shared/header.jsp"%>
<c:choose>
    <c:when test="${username eq '1001746967'}">
    </c:when>
    <c:otherwise>
        <%  response.sendRedirect("login.jsp");%>
    </c:otherwise>
</c:choose>
<h1 class="display-4 text-center demo"> Manage Staffs</h1>
<form method="post" action="StaffController" autocomplete="off" class="mb-4">
    <div class="form-row text-center">
        <div class="form-group col-md-4">
            <label>Name</label>
            <input type="text"  name="name" class="form-control" placeholder="Name" required>
        </div>
        <div class="form-group col-md-4">
            <label>Password</label>
            <input type="password" name="password" class="form-control" placeholder="Password" required>
        </div>
        <div class="form-group col-md-4">
            <label>Salary</label>
            <input type="number" name="salary" class="form-control" placeholder="Salary" required>
        </div>
        <div class="form-group col-md-4">
            <label>Phone no</label>
            <input type="number" maxlength="10" name="phone_no" class="form-control" id="phoneNo" placeholder="Phone no" required>
        </div>
        <div class="form-group col-md-4">
            <label>Address</label>
            <input type="text" name="address" class="form-control" placeholder="Address" required>
        </div>

        <div class="form-group col-md-4">
            <label>Citizenship no</label>
            <input type="text" name="citizenship_no" class="form-control" placeholder="Citizenship no" required>
        </div>

    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<table class="responsive-table highlight header-fixed mt-4">
    <thead>
        <tr>
            <th>Staff id</th>
            <th>Name</th>
            <th>Salary</th>
            <th>Phone no</th>
            <th>Address</th>
            <th>Citizenship no</th>
            <th>Password</th>
            <th>Operation</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach items="${stafflist}" var="s">
            <tr id="staff-${s.staff_id}">
                <td><c:out value="${s.staff_id}" /></td>
                <td><c:out value="${s.name}" /></td>
                <td><c:out value="${s.salary}" /></td>
                <td><c:out value="${s.phone_no}" /></td>
                <td><c:out value="${s.address}" /></td>
                <td><c:out value="${s.citizenship_no}" /></td>
                <td><c:out value="${s.password}" /></td>
                <td>
                    <a href="StaffUpdater?staffid=<c:out value="${s.staff_id}"/>" class="btn btn-primary mr-4 clicker">Edit</a>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter2" onclick ="dataSender('${s.staff_id}', 'staffDelete')">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>
<!-- Yes no Modal -->    
<div class="modal fade" id="exampleModalCenter2" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Confirm to delete record</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" onclick ="deleteData();M.toast({html: 'One Staff Deleted'});" data-dismiss="modal">Yes</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">No</button>
            </div>
        </div>
    </div>
</div>
<%@include file="shared/footer.jsp"%>	
