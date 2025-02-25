package com.spring.ulgi.book.model.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.ulgi.book.model.store.BookStore;
import com.spring.ulgi.book.model.vo.BookVO;


@Repository
public class BookStoreLogic implements BookStore {

	@Override
	public int insertBook(SqlSession session, BookVO book) {
		int result = session.insert("BookMapper.insertBook", book);
		return result;
	}

	@Override
	public int deleteBook(SqlSession session, int bookNo) {
		int result = session.delete("BookMapper.deleteBook", bookNo);
		return result;
	}

	@Override
	public List<BookVO> selectListAll(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<BookVO> bList = session.selectList("BookMapper.selectListAll", null, rowBounds);
		return bList;		
	}

	@Override
	public List<BookVO> selectSearchList(SqlSession session, Map<String, String> paramMap, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<BookVO> searchList = session.selectList("BookMapper.selectSearchList", paramMap, rowBounds);
		return searchList;
	}

	@Override
	public BookVO selectOneByNo(SqlSession session, int bookNo) {
		BookVO book = session.selectOne("BookMapper.selectOneByNo", bookNo);
		return book;
	}

	@Override
	public int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("BookMapper.getTotalCount");
		return totalCount;
	}
	@Override
	public int getTotalCount(SqlSession session, Map<String, String> paramMap) {
		int totalCount = session.selectOne("BookMapper.getSearchCount", paramMap);
	    return totalCount;
	}


}
