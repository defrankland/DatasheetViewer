<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<title>New User Registration</title>
<h1>Enter your info:</h1>
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

</style>
</head>
<body onload='document.NewUserForm.username.focus();'>
	
	<c:if test="${not empty error}">
			<div class="error">${error}</div>
	</c:if>
		
	<form name='NewUserForm'
			action="<c:url value='/register' />" method='POST'>

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
					<td>Email:</td>
					<td><input type='text' name='email' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="register" type="submit"
						value="Register" /></td>
				    
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
		
</body>
</html>