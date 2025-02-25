<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>대여리스트 페이지</title>
	<link rel="stylesheet" href="../resources/css/reset.css">
	<link rel="stylesheet" href="../resources/css/header.css">
	<link rel="stylesheet" href="../resources/css/list.css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"/>
		<main id="main">
			<div class="title">
				<h1>대여 관리</h1>		
			</div>
			<div class="content">
				<div class="menu">
					<div class="insert">
						<form action="/lease/insert">
							<button>추가</button>
						</form>
					</div>
					<form action="/lease/search" method="get">
						<div class="search">
							<div class="select">
								<select name="searchCondition" class="select">
									<option value="userId">회원아이디</option>
									<option value="bookName">책이름</option>
								</select>							
							</div>
							<div class="input">
								<input type="text" name="searchKeyword" placeholder="검색어를 입력하세요">							
							</div>
							<div class="searchbtn">
								<button type="submit">검색</button>
							</div>
						</div>
					</form>			
				</div>
				<div class="list">
					<table>
						<thead>
							<tr>
								<th class="table listno">번호</th>
								<th class="table leaseno">대여번호</th>
								<th class="table bookno">책이름</th>
								<th class="table userid">고객아이디</th>
								<th class="table username">고객명</th>
								<th class="table leasedate">대여일</th>
								<th class="table returndate">반납일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lList }" var="list" varStatus="i">
								<tr>
									<td class="table listno">${(page.currentPage-1)*10 + i.index + 1}</td>
									<td class="table leaseno">${list.leaseNo }</td>
									<td class="table bookno"><a href="/lease/detail?leaseNo=${list.leaseNo }">${list.bookName }</a></td>
									<td class="table userid">${list.userId }</td>
									<td class="table username">${list.userName }</td>
									<td class="table leasedate">${list.leaseDate }</td>
									<td class="table returndate">${list.returnDate }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="pagination">
					<c:if test="${page.startNavi ne 1 }">
						<a href="/lease/list?currentPage=${page.startNavi-1 }">&lt;</a>
					</c:if>
					<c:forEach begin="${page.startNavi }" end="${page.endNavi }" var="i">
						<a href="/lease/list?currentPage=${i }" <c:if test="${page.currentPage == i }">style="color: #fff; background-color:#2d336a;"</c:if>>${i }</a>
					</c:forEach>
					<c:if test="${page.endNavi ne page.maxPage }">
						<a href="/lease/list?currentPage=${page.endNavi+1 }">&gt;</a>
					</c:if>			
				</div>
			</div>
		</main>
	</div>
</body>
</html>