<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="ru">

<head>
<!-- for media -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- bootstrap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<!-- custom -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/custom/custom.css">
<!-- title -->
<title>Profile</title>
</head>

<body class="body_color_main">
	<div class="flex_main">
		<div class="body_color_darkness"></div>
		<div class="d-flex bd-highlight headfoot_up" style="height: 70px;">
			<div class="p-1">
				<a role="button" class="btn btn btn-success shadow_min"
					href="main?command=main">Back</a>
			</div>
		</div>

		<h3 class="text-center text-white text_shadow_min headfoot_up">User's
			profile</h3>
		<hr />
		<div class="container up_content my-2">
			<div class="d-flex justify-content-center">
				<form role=”form” class="bg-light p-2 inline_form shadow">
					<div class="mb-2">
						Type of user:
						<c:choose>
							<c:when test="${userNow.userGroup == 1}">
								<br />
								<strong>user</strong>
								<br />
							</c:when>
							<c:when test="${userNow.userGroup == 2}">
								<br />
								<strong>moder</strong>
								<br />
							</c:when>
							<c:when test="${userNow.userGroup == 3}">
								<br />
								<strong>admin</strong>
								<br />
							</c:when>
						</c:choose>
						<br /> E-mail: ${userNow.email} <br />
					</div>
					<div class=”form-group”>
						Login: ${userNow.login} <br /> <input type="hidden"
							name="command" value="changeLogin" /> New login: <br /> <input
							type="text" name="login" value="" /> <br /> <input
							type="submit"
							class="btn btn-success btn-xs shadow_min float-left"
							value="Sumbit" /> <br />
					</div>
					<br />
					<div class=”form-group”>
						Password: ${userNow.login} <br /> <input type="hidden"
							name="command" value="changePassword" />New password: <br /> <input
							type="text" name="password" value=""><br /> <input
							type="submit"
							class="btn btn-success btn-xs shadow_min float-left"
							value="Submit" /> <br />
					</div>
				</form>
			</div>
		</div>
		<footer class="navbar-fixed-bottom shadow_min headfoot_up remove">
			<jsp:include page="/jsp/footer.jsp" />
		</footer>
	</div>
</body>
</html>