package com.spring.ulgi.lease.model.service;

import java.util.List;
import java.util.Map;

import com.spring.ulgi.lease.controller.dto.LeaseInsertRequest;
import com.spring.ulgi.lease.model.vo.Library;

public interface LeaseService {

	List<Library> selectLeaseList(int currentPage);

	int getTotalCount();

	int getTotalCount(Map<String, String> searchMap);

	List<Library> selectLeaseList(int currentPage, Map<String, String> searchMap);

	List<String> selectBooknameList();

	List<String> selectUseridList();

	int selectBooknoByBookname(String bookName);

	int leaseInsert(LeaseInsertRequest lease);

	Library selectOneByLeaseNo(int leaseNo);

	int leaseDelete(int leaseNo);

}
