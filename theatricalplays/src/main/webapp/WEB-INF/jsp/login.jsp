<%@page contentType="text/html" pageEncoding="windows-1253"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1253">
        <title>Login</title>
        
        <style>

	.error {
		color: #ff0000;
	}
</style>

    </head>
    <body>
      <h2>Login Form</h2>
 
	<form:form action="login" method="POST" modelAttribute="login">
	 
		<table>
			<tr>
				<td><label for="username">Username </label> </td>
				<td><form:input path="username" id="username"/></td>
				<td><form:errors path="username" cssClass="error"/></td>
		    </tr>
	    
			<tr>
				<td><label for="password">Password: </label> </td>
				<td><form:input path="password" id="password" type="password"/></td>
				<td><form:errors path="password" cssClass="error"/></td>
		    </tr>
                    	<tr>
				<td colspan="3">
					<input type="submit" value="Login"/>
				</td>
			</tr>
		</table>
	</form:form>
    </body>
</html>
