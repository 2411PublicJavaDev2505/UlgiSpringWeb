<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>도서목록 - 상세페이지</title>
		<link rel="stylesheet" href="../resources/css/reset.css">
		<link rel="stylesheet" href="../resources/css/header.css">
		<link rel="stylesheet" href="../resources/css/detail.css">
		
	</head>
	<body>
		<div id="container">
			<jsp:include page="/WEB-INF/views/include/header.jsp"/>
			<main>
				<h3 class="content-title">도서 관리 - 상세페이지</h3>
				<form action="/book/detail" method="get">
				<table class="detail">
					<tr>
						<td class="tbTitle">책번호</td>
						<td class="tbContent">${book.bookNo }</td>
					</tr>
					<tr>
						<td class="tbTitle">제목</td>
						<td class="tbContent">${book.bookName }</td>
					</tr>
					<tr>
						<td class="tbTitle">글쓴이</td>
						<td class="tbContent">${book.bookWriter }</td>
					</tr>
					<tr>
						<td class="tbTitle">가격</td>
						<td class="tbContent">${book.bookPrice }</td>
					</tr>
					<tr>
						<td class="tbTitle">출판사</td>
						<td class="tbContent">${book.publisher }</td>
					</tr>
					<tr>
						<td class="tbTitle">장르</td>
						<td class="tbContent">${book.genre }</td>
					</tr>
				</table>
				<div class="delete-button">
					<a href="javascript:void(0)" onclick="delYesOrNo(${book.bookNo });" type="submit">삭제</a>
				</div>			
			</form>
			</main>
		</div>
		<script type="text/javascript">
			function delYesOrNo(bookNo) {
				var val = confirm("정말 삭제하시겠습니까?");
				if(val){
					location.replace("/book/delete?bookNo="+bookNo);
				}
			}
		</script>
	</body>
</html>