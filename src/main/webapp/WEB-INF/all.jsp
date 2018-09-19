 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   


    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>home page</title>
	 
	</head>
<body>
	<h1>All Books</h1>
<table>
    <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>License Number</th>
            <th>Expiration Date</th>
            <th>State</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${person}" var="person" >
        <tr>
            <td><c:out value="${person.firstName}"/></td>
            <td><c:out value="${person.lastName}"/></td>
            <td><c:out value="${person.license.number}"/></td>
            <td><c:out value="${person.license.expiration_date}"/></td>
            <td><c:out value="${person.license.state}"/></td>
            <td> <a href="/person/${person.id}">Show</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/person/new">New Person</a>
<a href="/person/license">Add License</a>

	
</body>
</html>
