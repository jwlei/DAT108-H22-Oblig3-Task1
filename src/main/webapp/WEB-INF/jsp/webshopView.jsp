<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Task 1 - WebShop</title>
	<link rel="stylesheet" href="css/styles.css">
</head>

<body>
	<h1>Cart</h1>
	<div style="min-width: 150px; width: 15vw; display: flex; flex-direction: column; justify-content: center">
		<form action="addItem" method="post">
		  <fieldset>
			  <legend>Add a new item to cart</legend>
			  	<input type="text" name="item" autocomplete="off" placeholder="2-20 chars"/>
				<input type="submit" value="Add to cart" />
			  	<span style="color:red">${redirectMessage}</span>
		  </fieldset>
		</form>

		<fieldset>
			<legend>Cart content</legend>
			<table style="min-width: 150px">
				<c:forEach var="item" items="${cart.items}">
					<tr>
						<td>
							<form action="removeItem" method="post"  modelAttribute="itemForDeletion">
								<div style="display: block; float: left">
									<input type="submit" value="Delete" style="justify-items: left">
									<p style="display: inline-block; text-align: right;">${item.name}</p>
									<input type="hidden" name="itemForDeletion" value="${item.name}">

								</div>

							</form>
						</td>
					</tr>
				</c:forEach>
			</table><br>
		</fieldset>
	</div>
	<a href="${pageContext.request.contextPath}index.html">Return to index</a>
</body>

</html>