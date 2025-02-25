<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>을지도서관 - 도서 목록</title>
		<link rel="stylesheet" href="../resources/css/reset.css">
		<link rel="stylesheet" href="../resources/css/header.css">
		<link rel="stylesheet" href="../resources/css/list.css">
	</head>
	<body>
		<div id="container">
			<jsp:include page="/WEB-INF/views/include/header.jsp"/>
			<main id="main">
				<section class="title">
					<h1>조회 목록</h1>
				</section>
				<div class="content">
					<div class="menu">
						<div class="insert">
							<form action="/book/insert">
								<button>추가</button>
							</form>
						</div>
					<form action="/book/search" method="get">
						<div class="search">
							<div class="select">
								<select name="searchCondition">
									<option value="all" <c:if test="${searchCondition eq 'all' }">selected</c:if>>전체</option>
									<option value="code" <c:if test="${searchCondition eq 'code' }">selected</c:if>>책번호</option>
									<option value="title"<c:if test="${searchCondition eq 'title' }">selected</c:if>>책제목</option>
									<option value="writer"<c:if test="${searchCondition eq 'writer' }">selected</c:if>>작가명</option>
								</select>
							</div>
							<div class="input">
								<input type="text" class="input" name="searchKeyword" value="${searchKeyword }" placeholder="검색어를 입력하세요">
							</div>
							<div class="searchbtn">
								<button type="submit">검색</button>
							</div>
						</div>
					</form>
					</div>
				</div>
				<section class="list">
					<table>
						<thead>
							<tr>
								<th class="table listno">번호</th>
								<th class="table leaseno">책번호</th>
								<th class="table bookno">제목</th>
								<th class="table writer">글쓴이</th>
								<th class="table price">가격</th>
								<th class="table publisher">출판사</th>
								<th class="table genre">장르</th>
						</thead>
						<tbody>
							<c:forEach items="${searchList }" var="book" varStatus="i">
								<tr>
									<td class="table listno">${i.count }</td>
									<td class="table leaseno">${book.bookNo }</td>
									<td class="table bookno"><a href="/book/detail?bookNo=${book.bookNo }">${book.bookName }</a></td>
									<td class="table writer">${book.bookWriter }</td>
									<td class="table price">${book.bookPrice }</td>
									<td class="table publisher">${book.publisher }</td>
									<td class="table genre">${book.genre }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				<div class="pagination">
					<c:if test="${page.startNavi ne 1 }">
						<a href="/book/search?currentPage=${page.startNavi-1 }&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}" class="prev">&lt;</a>
					</c:if>
					<c:forEach begin="${page.startNavi }" end="${page.endNavi }" var="p">
						<a href="/book/search?currentPage=${p }&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}" <c:if test="${page.currentPage == p }">style="color: #fff; background-color:#2d336a;"</c:if>>${p }</a>
					</c:forEach>
					<c:if test="${page.endNavi ne page.maxPage }">
						<a href="/book/search?currentPage=${page.endNavi+1 }&searchCondition=${searchCondition}&searchKeyword=${searchKeyword}" class="next">&gt;</a>
					</c:if>
				</div>
				</section>
			</main>
		</div>
	</body>
</html>