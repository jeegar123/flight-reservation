<%--
  Created by IntelliJ IDEA.
  User: Vinod
  Date: 4/24/2020
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Flights</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"/>
</head>
<body>
<%int i=0;%>
    <div class="container">
        <table class="table-bordered w-100 text-center">
            <thead>
            <tr>
                <th>Sr no</th>
                <th>Flight Number</th>
                <th>Arrival City</th>
                <th>Departure City</th>
                <th>Departure Time</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="flight" items="${flightList}">
                    <tr>
                        <td><%=i++%></td>
                        <td>${flight.flightNumber}</td>
                        <td>${flight.arrivalCity}</td>
                        <td>${flight.departureCity}</td>
                        <td>${flight.estimateDepartmentTime}</td>
                        <td><a href="${pageContext.request.contextPath}/reservationPage?id=${flight.id}" class="btn btn-primary">Select</a></td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>
    </div>
</body>
</html>
