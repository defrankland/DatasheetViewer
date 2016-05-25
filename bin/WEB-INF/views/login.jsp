<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login {
	width: 350px;
	padding: 20px;
	background: rgb(235,235,255);
	-webkit-border-radius: 20px;
	-moz-border-radius: 20px;
	border: 5px solid #000;
}
</style>
</head>
<body onload='document.loginForm.username.focus();'>

	

	<div id="login">
		<h1>Datasheet Viewer Login</h1>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<h4>Login</h4>
   
		<form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST'>

			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='username'></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td><br><input name="login" type="submit"
						value="Submit" /></td>
				    
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
		
		<h4>New User?</h4>
		<form name='NewUserForm'
			action="<c:url value='/register' />" method='GET'>
			<input name="registration" type="submit" value="Sign Up" />
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
				    
	</div>

</body>
</html>