package com.spring.ulgi.customer.model.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ulgi.customer.controller.dto.InsertRequest;
import com.spring.ulgi.customer.controller.dto.UpdateRequest;
import com.spring.ulgi.customer.model.service.CustomerService;
import com.spring.ulgi.customer.model.store.CustomerStore;
import com.spring.ulgi.customer.model.vo.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	private CustomerStore cStore;
	private SqlSession session;
	
	@Autowired
	public CustomerServiceImpl(CustomerStore cStore, SqlSession session) {
		this.cStore = cStore;
		this.session = session;
	}
	
	@Override
	public List<Customer> selectCustomerList(int currentPage) {
		return cStore.selectCustomerList(session, currentPage);
	}

	@Override
	public int getTotalCount() {
		return cStore.getTotalCount(session);
	}

	@Override
	public int getTotalCount(Map<String, String> searchMap) {
		return cStore.getTotalCount(session,searchMap);
	}

	@Override
	public List<Customer> selectCustomerList(Map<String, String> searchMap, int currentPage) {
		return cStore.selectCustomerList(session,searchMap,currentPage);
	}

	@Override
	public Customer selectOneByUserNo(int userNo) {
		return cStore.selectOneByUserno(session, userNo);
	}

	@Override
	public int updateCustomer(UpdateRequest customer) {
		return cStore.updateCustomer(session, customer);
	}

	@Override
	public int deleteCustomer(int userNo) {
		return cStore.deleteCustomer(session, userNo);
	}

	@Override
	public int customerInsert(InsertRequest customer) {
		return cStore.customerInsert(session, customer);
	}

}
