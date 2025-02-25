package com.spring.ulgi.lease.model.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ulgi.lease.controller.dto.LeaseInsertRequest;
import com.spring.ulgi.lease.model.service.LeaseService;
import com.spring.ulgi.lease.model.store.LeaseStore;
import com.spring.ulgi.lease.model.vo.Library;

@Service
public class LeaseServiceImpl implements LeaseService{

	private LeaseStore lStore;
	private SqlSession session;
	
	@Autowired
	public LeaseServiceImpl(LeaseStore lStore, SqlSession session) {
		this.lStore = lStore;
		this.session = session;
	}
	
	@Override
	public List<Library> selectLeaseList(int currentPage) {
		return lStore.selectLeaseList(session, currentPage);
	}

	@Override
	public int getTotalCount() {
		return lStore.getTotalCount(session);
	}

	@Override
	public int getTotalCount(Map<String, String> searchMap) {
		return lStore.getTotalCount(session, searchMap);
	}

	@Override
	public List<Library> selectLeaseList(int currentPage, Map<String, String> searchMap) {
		return lStore.selectLeaseList(session, currentPage, searchMap);
	}

	@Override
	public List<String> selectBooknameList() {
		return lStore.selectBooknameList(session);
	}

	@Override
	public List<String> selectUseridList() {
		return lStore.selectUseridList(session);
	}

	@Override
	public int selectBooknoByBookname(String bookName) {
		return lStore.selectBooknoByBookname(session, bookName);
	}

	@Override
	public int leaseInsert(LeaseInsertRequest lease) {
		return lStore.leaseInsert(session, lease);
	}

	@Override
	public Library selectOneByLeaseNo(int leaseNo) {
		return lStore.selectOneByLeaseNo(session,leaseNo);
	}

	@Override
	public int leaseDelete(int leaseNo) {
		return lStore.leaseDelete(session, leaseNo);
	}

}
