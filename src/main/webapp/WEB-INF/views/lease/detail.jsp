<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>대여리스트 페이지</title>
	<link rel="stylesheet" href="../resources/css/reset.css">
	<link rel="stylesheet" href="../resources/css/header.css">
	<link rel="stylesheet" href="../resources/css/detail.css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"/>
		<main>
			<h3 class="content-title">대여 관리 - 상세페이지</h3>
			<form action="/lease/delete" method="get">
				<table class="detail">
					<tr>
						<td class="tbTitle">대여번호</td>
						<td class="tbContent">${library.leaseNo }</td>
					</tr>
					<tr>
						<td class="tbTitle">책이름</td>
						<td class="tbContent">${library.bookName }</td>
					</tr>
					<tr>
						<td class="tbTitle">고객아이디</td>
						<td class="tbContent">${library.userId }</td>
					</tr>
					<tr>
						<td class="tbTitle">대여일</td>
						<td class="tbContent">${library.leaseDate }</td>
					</tr>
					<tr>
						<td class="tbTitle">반납일</td>
						<td class="tbContent">${library.returnDate }</td>
					</tr>
				</table>
				<div class="delete-button">
					<a href="javascript:void(0)" onclick="delYesOrNo(${library.leaseNo });" type="submit">삭제</a>			
				</div>
			</form>			
		</main>
	</div>
	<script type="text/javascript">
		function delYesOrNo(leaseNo) {
			var val = confirm("정말 삭제하시겠습니까?");
			if(val){
				location.replace("/lease/delete?leaseNo="+leaseNo);
			}
		}
	</script>
</body>
</html>