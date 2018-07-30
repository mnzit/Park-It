<%-- 
    Document   : member
    Created on : Jul 16, 2018, 8:58:49 AM
    Author     : Dell
--%>
<%           response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expries", "0");
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>

<%@include file="header.jsp"%>
<h1 class="display-4 text-center demo"> Manage Members</h1>
<form method="post" action="MemberController" autocomplete="off" class="mb-4">
    <div class="form-row text-center">
        <div class="form-group col-md-4">
            <label>Name</label>
            <input type="text"  name="name" class="form-control" placeholder="Name" required>
        </div>
        <div class="form-group col-md-4">
            <label>Vehicle No.</label>
            <input type="text" name="vehicleNo" class="form-control" placeholder="Vehicle No." required>
        </div>

        <div class="form-group col-md-4">
            <label for="inputState">State</label>
            <select id="inputState" class="form-control" name="state">
                <option>Car</option>
                <option selected>Bike</option>
            </select>
        </div>
        <div class="form-group col-md-4">
            <label>Phone no</label>
            <input type="text" name="phone_no" class="form-control" id="phoneNo" placeholder="Phone no" required>
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
<table class="responsive-table highlight header-fixed">
    <thead>
        <tr>
            <th>Member id</th>
            <th>Name</th>
            <th>Vehicle no.</th>
            <th>Type</th>
            <th>Phone no</th>
            <th>Address</th>
            <th>Citizenship no</th>
            <th>Operation</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach items="${memberlist}" var="m">
            <tr id="member-${m.member_id}">
                <td><c:out value="${m.member_id}" /></td>
                <td><c:out value="${m.name}" /></td>
                <td><c:out value="${m.vehicle_no}" /></td>
                <td><c:out value="${m.type}" /></td>
                <td><c:out value="${m.phone_no}" /></td>
                <td><c:out value="${m.address}" /></td>
                <td><c:out value="${m.citizenship_no}" /></td>
                <td>
                     <a href="MemberUpdater?memberid=<c:out value="${m.member_id}"/>" class="btn btn-primary mr-4 clicker">Edit</a>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter2" onclick ="dataSender('${m.member_id}','memberDelete')">Delete</button>                </td>
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
                <button type="button" class="btn btn-secondary" onclick ="deleteData();M.toast({html: 'One Member Deleted'});" data-dismiss="modal">Yes</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">No</button>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>	
