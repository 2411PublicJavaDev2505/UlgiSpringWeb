package com.spring.ulgi.book.model.vo;

public class SearchVO {
	private String searchCondition;
	private String searchKeyword;
	
	public SearchVO() {
		super();
	}

	public SearchVO(String searchCondition, String searchKeyword) {
		super();
		this.searchCondition = searchCondition;
		this.searchKeyword = searchKeyword;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	@Override
	public String toString() {
		return "SearchVO [searchCondition=" + searchCondition + ", searchKeyword=" + searchKeyword + "]";
	}
	
}
