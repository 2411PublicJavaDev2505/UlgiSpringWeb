<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>회원관리 페이지</title>
	<link rel="stylesheet" href="../resources/css/reset.css">
	<link rel="stylesheet" href="../resources/css/header.css">
	<link rel="stylesheet" href="../resources/css/detailcustomer.css">
</head>
<body>
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<main>
			<h3 class="cuscontent-title">회원관리 페이지</h3>
			<form action="/customer/update" method="post">
				<table class="cusdetail">
					<tr>
						<td class="tbTitle">고객번호</td>
						<td class="tbContent inputText"><input type="text" value="${customer.userNo }" name="userNo" readonly></td>
					</tr>
					<tr>
						<td class="tbTitle">고객아이디</td>
						<td class="tbContent inputText"><input type="text" value="${customer.userId }" readonly ></td>
					</tr>
					<tr>
						<td class="tbTitle"><div class=" modify"><div>이름</div><div class="star">*</div></div></td>
						<td class="tbContent inputText"><input type="text" value="${customer.userName }" name="userName" ></td>
					</tr>
					<tr>
						<td class="tbTitle">나이</td>
						<td class="tbContent inputText"><input type="text" value="${customer.userAge }" readonly ></td>
					</tr>				
					<tr>
						<td class="tbTitle modify"><div class="modify"><div>주소</div><div class="star">*</div></div></td>
						<td class="tbContent inputText"><input type="text" value="${customer.addr }" name="addr" ></td>
					</tr>
					<tr>
						<td class="tbTitle">성별</td>
						<td class="tbContent radio">
							남 : <input type="radio" name="gender" value="${customer.gender }" disabled <c:if test="${customer.gender == 'M' }">checked</c:if>>						
							여 : <input type="radio" name="gender" value="${customer.gender }" disabled <c:if test="${customer.gender == 'F' }">checked</c:if>>
						</td>
					</tr>
					<tr>
						<td class="tbTitle">가입일</td>
						<td class="tbContent inputText"><input type="text" value="${customer.enrollDate }" readonly ></td>
					</tr>								
				</table>
				<div class="button">				
					<div class="modify-button">
						<button type="submit">수정</button>
					</div>
					<div class="delete-button">
						<a href="javascript:void(0)" onclick="delYesOrNo(${customer.userNo });" type="submit">삭제</a>			
					</div>
				</div>
			</form>
		</main>
	<script type="text/javascript">
		function delYesOrNo(userNo) {
			var val = confirm("정말 삭제하시겠습니까?");
			if(val){
				location.replace("/customer/delete?userNo="+userNo);
			}
		}
	</script>
</body>
</html>