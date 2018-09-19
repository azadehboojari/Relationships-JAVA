  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   



    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>home page</title>
	 
	</head>
<body>
<h1>New License</h1>
<form:form action="/person/license" method="post">
    <p>
        <select name="person">
			<option selected="selected">Select person</option>
			<c:forEach items="${person}" var="person">
				<option value="${person.id}">${person.firstName} ${person.lastName}</option>
			</c:forEach>
		</select>
    </p>
     
   	<label for="state">State:</label>
		<input type="text" name="state">
		<label for="date">Date:</label>
		<input type="date" name="date">
    <input type="submit" value="Submit"/>
</form:form>   
</body>
</html> 