<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>도서관리 - 메인</title>
		<link rel="stylesheet" href="../resources/css/reset.css">
		<link rel="stylesheet" href="../resources/css/header.css">
		<link rel="stylesheet" href="../resources/css/list.css">
				
	</head>
	<body>
		<div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"/>
			<main id="main">
				<div class="title">
					<h1>도서 목록 전체</h1>
				</div>
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
								<select class="search-select" name="searchCondition">
									<option value="all" <c:if test="${searchCondition eq 'all' }">selected</c:if>>전체</option>
									<option value="code" <c:if test="${searchCondition eq 'code' }">selected</c:if>>책번호</option>
									<option value="title"<c:if test="${searchCondition eq 'title' }">selected</c:if>>책제목</option>
									<option value="writer"<c:if test="${searchCondition eq 'writer' }">selected</c:if>>작가명</option>
								</select>
							</div>
							<div class="input">
								<input type="text" class="search-input" name="searchKeyword" value="${searchKeyword }" placeholder="검색어를 입력하세요">
							</div>
							<div class="searchbtn">
								<button type="submit" class="search-button">검색</button>
							</div>
						</div>
					</form>
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
							</tr>	
						</thead>
						<tbody>
							<c:forEach items="${bList }" var="book" varStatus="i">
								<tr>
									<td class="table listno">${i.count}</td>
									<td class="table leaseno">${book.bookNo }</td>
									<td class="table bookno"><a href="/book/detail?bookNo=${book.bookNo }">${book.bookName }</a></td>
									<td class="table writer">${book.bookWriter }</td>
									<td class="table price"">${book.bookPrice }</td>
									<td class="table publisher">${book.publisher }</td>
									<td class="table genre">${book.genre }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="pagination">
						<c:if test="${page.startNavi ne 1 }">
							<a href="/book/list?currentPage=${page.startNavi-1 }" >&lt;</a>
						</c:if>
						<c:forEach begin="${page.startNavi }" end="${page.endNavi }" var="i">
							<a href="/book/list?currentPage=${i }"<c:if test="${page.currentPage == i }">style="color: #fff; background-color:#2d336a;"</c:if>>${i }</a>
						</c:forEach>
						<c:if test="${page.endNavi ne page.maxPage }">
							<a href="/book/list?currentPage=${page.endNavi+1 }" >&gt;</a>
						</c:if>
					</div>
				</section>
				</div>
			</main>
		</div>
	</body>
</html>