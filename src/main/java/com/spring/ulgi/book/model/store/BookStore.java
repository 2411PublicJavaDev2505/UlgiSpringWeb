package com.spring.ulgi.book.model.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.spring.ulgi.book.model.vo.BookVO;


public interface BookStore {
	/**
	 * 도서 추가
	 * @param session, book
	 * @return int
	 */
	int insertBook(SqlSession session, BookVO book);

	/**
	 * 도서 삭제
	 * @param session, bookNo
	 * @return int
	 */
	int deleteBook(SqlSession session, int bookNo);

	/**
	 * 도서 전체 조회 (도서 목록 메인)
	 * @param session, int
	 * @return List
	 */
	List<BookVO> selectListAll(SqlSession session, int currentPage);
	
	/**
	 * 검색 리스트 조회
	 * @param session, paramMap, currentPage
	 * @return List
	 */
	List<BookVO> selectSearchList(SqlSession session, Map<String, String> paramMap, int currentPage);
	
	/**
	 * 상세페이지 조회
	 * @param session, bookNo
	 * @return int
	 */
	BookVO selectOneByNo(SqlSession session, int bookNo);
	
	/**
	 * 페이지네이션(콘텐츠 갯수)
	 * @param session
	 * @return int
	 */
	int getTotalCount(SqlSession session);
	/**
	 * 검색 후 페이지네이션
	 * @param session, search
	 * @return int
	 */
	int getTotalCount(SqlSession session, Map<String, String> paramMap);

}
