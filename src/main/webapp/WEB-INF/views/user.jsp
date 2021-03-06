<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Person Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Login
</h1>

<c:url var="addAction" value="/login" ></c:url>

<form:form action="${addAction}" commandName="loginBean">
<table>
	<tr>
		<td colspan="2">
		<form:label path="description">
				<spring:message text="${loginBean.description}"/>
		</form:label>
	</tr>
	<tr>
		<td>
			<form:label path="username">
				<spring:message text="Enter your username"/>
			</form:label>
		</td>
		<td>
			<form:input path="username"/>
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="password">
				<spring:message text="Enter your password"/>
			</form:label>
		</td>
		<td>
			<form:input path="password"/>
		</td> 
	</tr>
	<tr>
		<td colspan="2">
		<form:label path="message">
				<spring:message text="${loginBean.message}"/>
		</form:label>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="Submit" />
	</tr>
</table>
</form:form>

</body>
</html>
