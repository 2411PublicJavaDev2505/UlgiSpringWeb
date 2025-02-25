package com.spring.ulgi.book.model.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.spring.ulgi.book.model.service.BookService;
import com.spring.ulgi.book.model.store.BookStore;
import com.spring.ulgi.book.model.vo.BookVO;


@Service
public class BookServiceImpl implements BookService {
	
	private BookStore bStore;
	private SqlSession session;
	
	public BookServiceImpl(BookStore bStore, SqlSession session) {
		this.bStore = bStore;
		this.session = session;
	}

	@Override
	public int insertBook(BookVO book) {
		int result = bStore.insertBook(session, book);
		return result;
	}

	@Override
	public int deleteBook(int bookNo) {
		int result = bStore.deleteBook(session, bookNo);
		return result;
	}

	@Override
	public List<BookVO> selectListAll(int currentPage) {
		List<BookVO> bList = bStore.selectListAll(session, currentPage);
		return bList;
	}

	@Override
	public List<BookVO> selectSearchList(Map<String, String> paramMap,int currentPage) {
		List<BookVO> searchList = bStore.selectSearchList(session, paramMap, currentPage);
		return searchList;
	}

	@Override
	public BookVO selectOneByNo(int bookNo) {
		BookVO book = bStore.selectOneByNo(session, bookNo);
		return book;
	}
	
	@Override
	public int getTotalCount() {
		int totalCount = bStore.getTotalCount(session);
		return totalCount;
	}
	@Override
	public int getTotalCount(Map<String, String> paramMap) {
		int totalCount = bStore.getTotalCount(session, paramMap);
		return totalCount;
	}
	

}
