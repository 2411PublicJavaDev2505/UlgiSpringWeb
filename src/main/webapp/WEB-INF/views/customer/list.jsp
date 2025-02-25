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
	<link rel="stylesheet" href="../resources/css/list.css">
</head>
<body>
	<div id= "container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<main id="main">
			<div class="title">
				<h1>회원 관리</h1>
			</div>
			<div class="content">
				<div class="menu">
					<div class="insert">
						<form action="/customer/insert"  method="get">
							<button type="submit" class="list-button">추가</button>
						</form>
					</div>
					<form class="list-form" action="/customer/search" method="get">
						<div class="search">
							<div class="select">
								<select class="search-select" name="searchCondition">
									<option value="userNo">고객번호</option>
									<option value="userId">고객아이디</option>
									<option value="userName">이름</option>
								</select>						
							</div>
							<div class="input">
								<input type="text" class="search-input" name="searchKeyword" placeholder="검색어를 입력하세요">						
							</div>
							<div class="searchbtn">
								<button type="submit" class="search-button">검색</button>
							</div>
						</div>
					</form>
				</div>
				<div class="list">
					<table>
						<thead>
							<tr>
								<th class="table listno">번호</th>
								<th class="table userNo">고객번호</th>
								<th class="table userId">고객아이디</th>
								<th class="table userName">이름</th>
								<th class="table gender">성별</th>
								<th class="table enrollDate">가입일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${cList }" var="customer" varStatus="i">
								<tr>
									<td class="table listno">${(page.currentPage-1)*10 + i.index + 1}</td>
									<td class="table userNo"><a href="/customer/detail?userNo=${customer.userNo}">${customer.userNo }</a></td>
									<td class="table userId"><a href="/customer/detail?userNo=${customer.userNo}">${customer.userId }</a></td>
									<td class="table userName"><a href="/customer/detail?userNo=${customer.userNo}">${customer.userName }</a></td>
									<td class="table gender">${customer.gender }</td>
									<td class="table enrollDate">${customer.enrollDate }</td>
									<td></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="pagination">
					<c:if test="${page.startNavi ne 1 }">
						<a href="/customer/list?currentPage=${page.startNavi -1 }" class="prev">&lt;</a>
					</c:if>	
					<c:forEach begin="${page.startNavi }" end="${page.endNavi }" var="p">
						<a href="/customer/list?currentPage=${p }" <c:if test="${page.currentPage == p }">style="color: #fff; background-color:#2d336a;"</c:if>>${p }</a>
					</c:forEach>
					<c:if test="${page.endNavi ne page.maxPage }">
						<a href="/customer/list?currentPage=${page.endNavi +1}" class="next">&gt;</a>
					</c:if> 
				</div>
			</div>
		</main>
	</div>
</body>
</html>