<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<title>WebStore Login</title>
</head>
<body>
    <jsp:include page="header.jsp" />

	<h1>Login</h1>
 
	<form name='loginForm'
		action="<c:url value='/j_spring_security_check' />" method='POST'>
 
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td />
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
	<br/><br/>
</body>
</html>