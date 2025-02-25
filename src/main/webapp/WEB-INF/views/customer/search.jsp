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
							<button type="submit">추가</button>
						</form>
					</div>
					<form class="list-form" action="/customer/search" method="get">
						<div class="search">
							<div class="select">
								<select name="searchCondition">
									<option value="userNo" <c:if test="${search.searchCondition == 'userNo' }">selected</c:if>>고객번호</option>
									<option value="userId" <c:if test="${search.searchCondition == 'userId' }">selected</c:if>>고객아이디</option>
									<option value="userName" <c:if test="${search.searchCondition == 'userName' }">selected</c:if>>이름</option>
								</select>
							</div>
							<div class=input>
								<c:if test="${search.searchCondition == 'userNo' }">
									<input type="number" class="search-input" name="searchKeyword" placeholder="검색어를 입력하세요" value="${search.searchKeyword }">								
								</c:if>
								<c:if test="${search.searchCondition ne 'userNo' }">
									<input type="text" class="search-input" name="searchKeyword" placeholder="검색어를 입력하세요" value="${search.searchKeyword }">								
								</c:if>
								
							</div>
							<div class="searchbtn">
								<button type="submit">검색</button>
							</div>
						</div>
					</form>
				</div>
				<div class="list">
					<table class="customer-table">
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
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="pagination">
					<c:if test="${page.startNavi ne 1 }">
						<a href="/customer/search?currentPage=${page.startNavi -1 }&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}" class="prev">&lt;</a>
					</c:if>	
					<c:forEach begin="${page.startNavi }" end="${page.endNavi }" var="p">
						<a href="/customer/search?currentPage=${p }&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}" <c:if test="${page.currentPage == p }">style="color: #fff; background-color:#2d336a;"</c:if>>${p }</a>
					</c:forEach>
					<c:if test="${page.endNavi ne page.maxPage }">
						<a href="/customer/search?currentPage=${page.endNavi +1}&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}" class="next">&gt;</a>
					</c:if> 
				</div>
			</div>
		</main>
	</div>
</body>
</html>