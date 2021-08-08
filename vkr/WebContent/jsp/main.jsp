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
<title>Main</title>
</head>

<body class="body_color_main">
	<div class="flex_main">
		<div class="body_color_darkness"></div>
		<header class="headfoot_up">
			<jsp:include page="/jsp/header.jsp" />
		</header>
		<div class="main row my-5">
			<div class="col-sm-6">
				<div class="card border-dark bg-success shadow_min mb-2">
					<div class="card-body">
						<h5 class="card-title text-white">Altman Z-score</h5>
						<p class="card-text">The Z-score formula for predicting
							bankruptcy was published in 1968 by Edward I. Altman, who was, at
							the time, an Assistant Professor of Finance at New York
							University. The formula may be used to predict the probability
							that a firm will go into bankruptcy within two years. Z-scores
							are used to predict corporate defaults and an easy-to-calculate
							control measure for the financial distress status of companies in
							academic studies. The Z-score uses multiple corporate income and
							balance sheet values to measure the financial health of a
							company.</p>
					</div>
					<div class="m-2">
					<c:out value = "${textResult}"/>
						<label for="result" class="text-white">Bunkrupt:</label> <input
							type="number" class="form-control" id="result"
							aria-describedby="grossOutputHelp" readonly="readonly"
							value="${result}">
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="card border-dark bg-success shadow_min">
					<div class="card-body">
						<h5 class="card-title text-white">
							<strong>Economic performance</strong>
						</h5>
						<p class="card-text">
							<strong>In a traditional sense, the economic performance
								of a firm is a function of its success in producing benefits for
								its owners in particular, through product innovation and the
								efficient use of resources. When you talk about this type of
								economic performance in a business context, people typically
								understand you to be speaking about some form of profit.</strong>
						</p>
						<form name="neroForm" method="POST" action="main">
							<input type="hidden" name="command" value="count" />
							<div class="mb-1">
								<label for="x01" class="text-white">Firm capital and
									reserves:</label> <input type="text" class="form-control" id="x01"
									name="x01" aria-describedby="x01Help" pattern="\d+(\.\d{2})?"
									placeholder="Enter number"> <small id="x01Help"
									class="form-text">code: 1300</small>
							</div>
							<div class="mb-1">
								<label for="x02" class="text-white">Long term duties:</label> <input
									type="text" class="form-control" id="x02" name="x02"
									aria-describedby="x02Help" pattern="\d+(\.\d{2})?"
									placeholder="Enter number"> <small id="x02Help"
									class="form-text">code: 1400</small>
							</div>
							<div class="mb-1">
								<label for="x03" class="text-white">Short-term
									liabilities:</label> <input type="text" class="form-control" id="x03"
									name="x03" aria-describedby="x03Help" pattern="\d+(\.\d{2})?"
									placeholder="Enter number"> <small id="x03Help"
									class="form-text">code: 1700</small>
							</div>
							<div class="mb-1">
								<label for="x04" class="text-white">Fixed assets:</label> <input
									type="text" class="form-control" id="x04" name="x04"
									aria-describedby="x04Help" pattern="\d+(\.\d{2})?"
									placeholder="Enter number"> <small id="x04Help"
									class="form-text">code: 1100</small>
							</div>
							<div class="mb-1">
								<label for="x05" class="text-white">Current assets:</label> <input
									type="text" class="form-control" id="x05" name="x05"
									aria-describedby="x05Help" pattern="\d+(\.\d{2})?"
									placeholder="Enter number"> <small id="x05Help"
									class="form-text">code: 1200</small>
							</div>
							<div class="float-right">
								<input type="submit" class="btn btn-outline-light"
									value="Сalculate" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<footer class="navbar-fixed-bottom shadow_min headfoot_up remove">
			<jsp:include page="/jsp/footer.jsp" />
		</footer>
	</div>
</body>

</html>