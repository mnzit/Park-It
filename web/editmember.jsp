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
<%@include file="shared/header.jsp"%>
<h1 class="display-4 text-center demo"> Manage Members</h1>
<c:forEach items="${memberbyid}" var="m">
    <form method="post" action="MemberController" autocomplete="off" class="mb-4">
        <div class="form-row text-center">
            <div class="form-group col-md-1">
                        <label>Staff id</label>
                        <input readonly="readonly" type="number" value="${m.member_id}" name="memberid" class="form-control">
                    </div>
            <div class="form-group col-md-3">
                <label>Name</label>
                <input type="text" value="${m.name}" name="name" class="form-control" placeholder="Name" required>
            </div>
            <div class="form-group col-md-4">
                <label>Vehicle No.</label>
                <input type="text" value="${m.vehicle_no} "name="vehicleNo" class="form-control" placeholder="Vehicle No." required>
            </div>

            <div class="form-group col-md-4">
                <label for="inputState">State</label>
                <select id="inputState" class="form-control" name="state">
                    <option <c:if test="${m.type eq 'Bike'}">selected</c:if>>Bike</option>
                    <option <c:if test="${m.type eq 'Car'}">selected</c:if>>Car</option>
                </select>
            </div>
            <div class="form-group col-md-4">
                <label>Phone no</label>
                <input type="text" value="${m.phone_no}" name="phone_no" class="form-control" id="phoneNo" placeholder="Phone no" required>
            </div>
            <div class="form-group col-md-4">
                <label>Address</label>
                <input type="text" value="${m.address}" name="address" class="form-control" placeholder="Address" required>
            </div>

            <div class="form-group col-md-4">
                <label>Citizenship no</label>
                <input type="text" value="${m.citizenship_no}" name="citizenship_no" class="form-control" placeholder="Citizenship no" required>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>

    </form>
</c:forEach>
<%@include file="shared/footer.jsp"%>	
