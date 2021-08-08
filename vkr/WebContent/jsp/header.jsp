<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ru">
<head>
<!-- bootstrap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<!-- custom -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/custom/custom.css">
</head>
<body>
	<div class="d-flex justify-content-end" style="height: 50px;">
		<div class="p-1">
			<a role="button" class="btn btn-success shadow_min"
				href="main?command=profile">Profile</a>
		</div>
		<div class="p-1">
			<a role="button" class="btn btn-success shadow_min"
				href="main?command=logout">Exit</a>
		</div>
	</div>
</body>