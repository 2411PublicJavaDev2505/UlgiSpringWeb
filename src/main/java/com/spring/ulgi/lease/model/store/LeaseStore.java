package com.spring.ulgi.lease.model.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.spring.ulgi.lease.controller.dto.LeaseInsertRequest;
import com.spring.ulgi.lease.model.vo.Library;

public interface LeaseStore {

	List<Library> selectLeaseList(SqlSession session, int currentPage);

	int getTotalCount(SqlSession session);

	int getTotalCount(SqlSession session, Map<String, String> searchMap);

	List<Library> selectLeaseList(SqlSession session, int currentPage, Map<String, String> searchMap);

	List<String> selectBooknameList(SqlSession session);

	List<String> selectUseridList(SqlSession session);

	int selectBooknoByBookname(SqlSession session, String bookName);

	int leaseInsert(SqlSession session, LeaseInsertRequest lease);

	Library selectOneByLeaseNo(SqlSession session, int leaseNo);

	int leaseDelete(SqlSession session, int leaseNo);

}
