<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User Registration Form</title>

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>

	<h2>Registration Form</h2>
 
	<form:form method="POST" modelAttribute="play">
	 <form:input type="hidden" path="play_id" id="play_id"/>
		<table>
			<tr>
				<td><label for="code">Code </label> </td>
				<td><form:input path="code" id="code"/></td>
				<td><form:errors path="code" cssClass="error"/></td>
		    </tr>
	    
			<tr>
				<td><label for="title">Title: </label> </td>
				<td><form:input path="title" id="title"/></td>
				<td><form:errors path="title" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="description">Description: </label> </td>
				<td><form:input path="description" id="description"/></td>
				<td><form:errors path="description" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="start_date">start_date </label> </td>
				<td><form:input path="start_date" id="start_date"/></td>
				<td><form:errors path="start_date" cssClass="error"/></td>
		    </tr>
                    
                    <tr>
				<td><label for="end_date">end_date </label> </td>
				<td><form:input path="end_date" id="end_date"/></td>
				<td><form:errors path="end_date" cssClass="error"/></td>
		    </tr>
                    
                    <tr>
				<td><label for="room_id">room_id </label> </td>
				<td><form:input path="room_id" id="room_id"/></td>
				<td><form:errors path="room_id" cssClass="error"/></td>
		    </tr>
                    
	
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	
</body>
</html>