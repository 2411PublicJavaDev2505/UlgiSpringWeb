package com.spring.ulgi.book.model.service;

import java.util.List;
import java.util.Map;

import com.spring.ulgi.book.model.vo.BookVO;


public interface BookService {
	
	/**
	 * 도서 추가
	 * @param session, book
	 * @return int
	 */
	int insertBook(BookVO book);

	/**
	 * 도서 삭제
	 * @param session, bookNo
	 * @return int
	 */
	int deleteBook(int bookNo);

	/**
	 * 도서 전체 조회 (도서 목록 메인)
	 * @param session, int
	 * @return List
	 */
	List<BookVO> selectListAll(int currentPage);
	
	/**
	 * 검색 리스트 조회
	 * @param session, paramMap, currentPage
	 * @return List
	 */
	List<BookVO> selectSearchList(Map<String, String> paramMap, int currentPage);
	
	/**
	 * 상세페이지 조회
	 * @param session, bookNo
	 * @return int
	 */
	BookVO selectOneByNo(int bookNo);
	
	/**
	 * 페이지네이션(콘텐츠 갯수)
	 * @param session
	 * @return int
	 */
	int getTotalCount();
	/**
	 * 검색 후 페이지네이션
	 * @param session, search
	 * @return int
	 */
	int getTotalCount(Map<String, String> paramMap);

}
