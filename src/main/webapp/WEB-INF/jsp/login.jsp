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
			<form:form action="/validate" method="post">
				<form:input path="password" />
				<form:button>Submit</form:button>

			<a href="${pageContext.request.contextPath}index.html">Return to index</a>
	</body>
</html>