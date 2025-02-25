package com.spring.ulgi.customer.model.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.spring.ulgi.customer.controller.dto.InsertRequest;
import com.spring.ulgi.customer.controller.dto.UpdateRequest;
import com.spring.ulgi.customer.model.vo.Customer;

public interface CustomerStore {

	List<Customer> selectCustomerList(SqlSession session, int currentPage);

	int getTotalCount(SqlSession session);

	int getTotalCount(SqlSession session, Map<String, String> searchMap);

	List<Customer> selectCustomerList(SqlSession session, Map<String, String> searchMap, int currentPage);

	Customer selectOneByUserno(SqlSession session, int userNo);

	int updateCustomer(SqlSession session, UpdateRequest customer);

	int deleteCustomer(SqlSession session, int userNo);

	int customerInsert(SqlSession session, InsertRequest customer);

}
