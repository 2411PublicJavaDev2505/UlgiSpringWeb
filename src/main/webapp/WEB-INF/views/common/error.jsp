<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>에러페이지</title>
	<link rel="stylesheet" href="../resources/css/reset.css">
	<link rel="stylesheet" href="../resources/css/header.css">
	<link rel="stylesheet" href="../resources/css/error.css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"/>
		<div id="main">
			<div class="error-box">
				<div class="errorCode">
					${errorCode }
				</div>
				<div class="errorMessage">
					${errorMessage }				
				</div>
			</div>
		</div>	
	</div>
</body>
</html>