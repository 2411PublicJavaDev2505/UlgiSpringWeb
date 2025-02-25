<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 관리</title>
	<link rel="stylesheet" href="../resources/css/reset.css">
	<link rel="stylesheet" href="../resources/css/header.css">
	<link rel="stylesheet" href="../resources/css/insert.css">
</head>
<body>
	<div id="container">
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<main>
			<p class="content-title">회원 관리 - 추가하기</p>
			<form action="/customer/insert" method="post">
				<table class="detail">
					<tr>
						<td class="tbTitle">고객아이디</td>
						<td class="tbContent"><input type="text" name="userId"></td>
					</tr>
					<tr>
						<td class="tbTitle">이름</td>
						<td class="tbContent"><input type="text" name="userName"></td>
					</tr>
					<tr>
						<td class="tbTitle">나이</td>
						<td class="tbContent"><input type="number" name="userAge"></td>
					</tr>
					<tr>
						<td class="tbTitle">주소</td>
						<td class="tbContent"><input type="text" name="addr"></td>
					</tr>
					<tr>
						<td class="tbTitle">성별</td>
						<td class="tbContent">	
							<div class="radio">
								<div class="male">
									남: <input type="radio" name="gender" value="M">
								</div>
								<div class="female">
									여: <input type="radio" name="gender" value="F">							
								</div>								
							</div>
						</td>
					</tr>
				</table>
				<button class="delete-button" type="submit">추가</button>
			</form>
			</main>
		</div>
	</body>
</html>