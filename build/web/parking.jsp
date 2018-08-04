<%-- 
    Document   : parking
    Created on : Jul 16, 2018, 8:35:55 AM
    Author     : Dell
--%>

<%@include file="shared/header.jsp"%>
<div class="form-row">
    <div class="form-group col-md-12 text-center">
        <label>Vehicle_no</label>
        <input type="text" id="vehicleno" name="vehicleno" class="form-control" placeholder="Set vehicle no" required>
    </div>
</div>
<%--<c:set var="count" value="0" scope="page" />--%>
<c:forEach items="${checklist}" var="e">
    <input type="checkbox" data-content ="${e.key}" data-toggle="tooltip" title="location: ${e.key}" value="${e.key}" class="mb-4 seats ${e.key}"<c:if test="${e.value eq 0}">checked</c:if>>
    <%--<c:set var="count" value="${count + 1}" scope="page"/>--%>
    <%--<c:if test="${count=='16'}"><br><c:set var="count" value="0" scope="page" /></c:if>--%>

</c:forEach>
<br>
<button class="btn btn-primary mt-4" onclick="call();M.toast({html: 'Parked'});">Add</button>
<table class="responsive-table highlight header-fixed mt-4">
    <thead>
        <tr>
            <th>Park id</th>
            <th>Vehicle_no</th>
            <th>Time parked</th>
            <th>Time returned</th>
            <th>Location</th>
            <th>Date</th>
            <th>Operation</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${parklist}" var="p">
            <tr id="park-${p.park_id}" onclick="rowHandler('${p.time_parked}', '${p.time_returned}')" >
                <td><c:out value="${p.park_id}" /></td>
                <td><c:out value="${p.vehicle_no}" /></td>
                <td><c:out value="${p.time_parked}" /></td>
                <td><c:out value="${p.time_returned}" /></td>
                <td><c:out value="${p.location_id}" /></td>
                <td><c:out value="${p.date}" /></td>
                <td>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter2" onclick ="removeVehicle('${p.location_id}', '${p.park_id}')">Remove</button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<%@include file="shared/footer.jsp"%>	
