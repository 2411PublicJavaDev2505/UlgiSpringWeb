package com.spring.ulgi.customer.model.service;

import java.util.List;
import java.util.Map;

import com.spring.ulgi.customer.controller.dto.InsertRequest;
import com.spring.ulgi.customer.controller.dto.UpdateRequest;
import com.spring.ulgi.customer.model.vo.Customer;

public interface CustomerService {

	List<Customer> selectCustomerList(int currentPage);

	int getTotalCount();

	int getTotalCount(Map<String, String> searchMap);

	List<Customer> selectCustomerList(Map<String, String> searchMap, int currentPage);

	Customer selectOneByUserNo(int userNo);

	int updateCustomer(UpdateRequest customer);

	int deleteCustomer(int userNo);

	int customerInsert(InsertRequest customer);

}
