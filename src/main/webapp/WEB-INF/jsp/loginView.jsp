<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Task 1 Login</title>
		<link rel="stylesheet" href="styles.css">
	</head>

	<body>
		<form:form action="validate" method="post">
			<fieldset>
				<legend>Login</legend>
				<div>
					<label for="passwordInputBox">Password:</label>
					<input type="text" name="password" id="passwordInputBox" placeholder="Password is '123'" autocomplete="off"/>
					<p style="color:red">${redirectMessage}</p>
				</div>
				<div>
					<input type="submit" value="Login" />
				</div>
			</fieldset>
		</form:form>
			<a href="${pageContext.request.contextPath}index.html">Return to index</a>
	</body>
</html>