package com.spring.ulgi.customer.model.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.ulgi.customer.controller.dto.InsertRequest;
import com.spring.ulgi.customer.controller.dto.UpdateRequest;
import com.spring.ulgi.customer.model.store.CustomerStore;
import com.spring.ulgi.customer.model.vo.Customer;

@Repository
public class CustomerStoreLogic implements CustomerStore{

	@Override
	public List<Customer> selectCustomerList(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBound = new RowBounds(offset, limit);
		return session.selectList("CustomerMapper.selectCustomerList", null, rowBound);
	}

	@Override
	public int getTotalCount(SqlSession session) {
		return session.selectOne("CustomerMapper.getTotalCount");
	}

	@Override
	public int getTotalCount(SqlSession session, Map<String, String> searchMap) {
		return session.selectOne("CustomerMapper.getTotalCountBySearch",searchMap);
	}

	@Override
	public List<Customer> selectCustomerList(SqlSession session, Map<String, String> searchMap, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBound = new RowBounds(offset, limit);
		return session.selectList("CustomerMapper.selectCustomerListBySearch",searchMap,rowBound);
	}

	@Override
	public Customer selectOneByUserno(SqlSession session, int userNo) {
		return session.selectOne("CustomerMapper.selectOneByUserNo",userNo);
	}

	@Override
	public int updateCustomer(SqlSession session, UpdateRequest customer) {
		return session.update("CustomerMapper.updateCustomer", customer);
	}

	@Override
	public int deleteCustomer(SqlSession session, int userNo) {
		return session.delete("CustomerMapper.deleteCustomer",userNo);
	}

	@Override
	public int customerInsert(SqlSession session, InsertRequest customer) {
		return session.insert("CustomerMapper.customerInsert",customer);
	}

}
