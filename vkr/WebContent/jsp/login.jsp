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
<title>Login</title>
</head>

<body class="body_color shadow">
	<div class="intro">
		<div class="intro_content">
			<div class=flex>
				<div class="main row my-2">
					<div class="col-6 col-md-4 remove">
						<img src="${pageContext.request.contextPath}/img/photo_login.png"
							alt="logo.png" class="img-responsive png_shadow remove"
							height="255" width="300">
					</div>
					<div class="col-6 col-md-4 text-center remove">
						<img src="${pageContext.request.contextPath}/img/logo.png"
							alt="logo.png"
							class="img-responsive center-img png_shadow remove" height="140"
							width="140">
					</div>
					<div class="col-6 col-md-4 login_center">
						<form class="bg-light p-2 mr-2 inline_form shadow float-right"
							name="loginForm" method="POST" action="main">
							<input type="hidden" name="command" value="login" /> <strong>Login:</strong><br />
							<input type="text" name="login" value="" /> <br />
							<strong>Password:</strong><br /> <input type="password"
								name="password" value="" /> <br />
							<c:if test="${errorLogin == true}">
								<strong>Wrong login or password!</strong>
							</c:if>
							<br /> <input type="submit"
								class="btn btn-success btn-xs float-right" value="Enter" />
						</form>
					</div>
				</div>
				<footer class="navbar-fixed-bottom shadow headfoot_top remove">
					<jsp:include page="/jsp/footer.jsp" />
				</footer>
			</div>
		</div>
		<div class="video">
			<video class=video_media
				src="${pageContext.request.contextPath}/video/background.mp4"
				autoplay muted loop></video>
		</div>
	</div>
</body>
</html>