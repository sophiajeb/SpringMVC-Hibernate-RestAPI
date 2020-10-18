<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>University Enrollments</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2> List of Users </h2>  
    <table>
        <tr>
            <td>id</td><td>Username</td><td>Password</td><td>First Name</td><td>Last Name</td><td>Phone number</td><td>email</td><td>Role</td><td></td>
        </tr>
        <c:forEach items="${user}" var="user">
            <tr>
            <td><a href="<c:url value='/edit-${user.user_id}-user' />">${user.user_id}</a></td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.first_name}</td>
            <td>${user.last_name}</td>
            <td>${user.mobile_phone}</td>
            <td>${user.email}</td>
            <td>${user.role}</td>
            
            <td><a href="<c:url value='/delete-${user.user_id}-user' />">delete</a></td>
            <td><a href="<c:url value='//edit-${user.user_id}-user' />">Update</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/new' />">Add New User</a>
</body>
</html>