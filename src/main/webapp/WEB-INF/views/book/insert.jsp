<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>도서 - 추가하기</title>
		<link rel="stylesheet" href="../resources/css/reset.css">
		<link rel="stylesheet" href="../resources/css/header.css">
		<link rel ="stylesheet" href="../resources/css/insert.css">
	</head>
	<body>
		<div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"/>
			<main>
				<p class="content-title">도서 관리 - 추가하기</p>
				<form action="/book/insert" method="post">
				<table class="detail">
					<tr>
						<td class="tbTitle">제목</td>
						<td><input type="text" name="bookName" ></td>
					</tr>
					<tr>
						<td class="tbTitle">글쓴이</td>
						<td><input type="text" name="bookWriter" ></td>
					</tr>
					<tr>
						<td class="tbTitle">가격</td>
						<td><input type="number" name="bookPrice"></td>
					</tr>
					<tr>
						<td class="tbTitle">출판사</td>
						<td><input type="text" name="publisher" ></td>
					</tr>
					<tr>
						<td class="tbTitle">장르</td>
						<td><input type="text" name="genre" ></td>
					</tr>
				</table>
				<button class="delete-button">도서 등록</button>			
			</form>
			</main>
		</div>
	</body>
</html>