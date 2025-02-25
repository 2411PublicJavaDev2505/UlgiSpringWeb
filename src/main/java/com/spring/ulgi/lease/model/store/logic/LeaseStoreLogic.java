package com.spring.ulgi.lease.model.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.ulgi.lease.controller.dto.LeaseInsertRequest;
import com.spring.ulgi.lease.model.store.LeaseStore;
import com.spring.ulgi.lease.model.vo.Library;

@Repository
public class LeaseStoreLogic implements LeaseStore{

	@Override
	public List<Library> selectLeaseList(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit+1;
		RowBounds rowbound = new RowBounds(offset, limit);
		return session.selectList("LeaseMapper.selectLeaseList",null,rowbound);
	}

	@Override
	public int getTotalCount(SqlSession session) {
		return session.selectOne("LeaseMapper.getTotalCount");
	}

	@Override
	public int getTotalCount(SqlSession session, Map<String, String> searchMap) {
		return session.selectOne("LeaseMapper.getTotalCountBySearch",searchMap);
	}

	@Override
	public List<Library> selectLeaseList(SqlSession session, int currentPage, Map<String, String> searchMap) {
		int limit = 10;
		int offset = (currentPage-1)*limit+1;
		RowBounds rowbound = new RowBounds(offset, limit);
		return session.selectList("LeaseMapper.selectLeaseListBySearch",searchMap,rowbound);
	}

	@Override
	public List<String> selectBooknameList(SqlSession session) {
		return session.selectList("LeaseMapper.selectBooknameList");
	}

	@Override
	public List<String> selectUseridList(SqlSession session) {
		return session.selectList("LeaseMapper.selectUseridList");
	}

	@Override
	public int selectBooknoByBookname(SqlSession session, String bookName) {
		return session.selectOne("LeaseMapper.selectBooknoByBookname",bookName);
	}

	@Override
	public int leaseInsert(SqlSession session, LeaseInsertRequest lease) {
		return session.insert("LeaseMapper.leaseInsert",lease);
	}

	@Override
	public Library selectOneByLeaseNo(SqlSession session, int leaseNo) {
		return session.selectOne("LeaseMapper.selectOneByLeaseNo",leaseNo);
	}

	@Override
	public int leaseDelete(SqlSession session, int leaseNo) {
		return session.delete("LeaseMapper.leaseDelete",leaseNo);
	}

}
