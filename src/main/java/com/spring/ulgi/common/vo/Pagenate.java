package com.spring.ulgi.common.vo;

public class Pagenate {

	private int startNavi;
	private int endNavi;
	private int maxPage;
	private int currentPage;
	
	public Pagenate() {}

	public Pagenate(int startNavi, int endNavi, int maxPage, int currentPage) {
		super();
		this.startNavi = startNavi;
		this.endNavi = endNavi;
		this.maxPage = maxPage;
		this.currentPage = currentPage;
	}

	public int getStartNavi() {
		return startNavi;
	}

	public int getEndNavi() {
		return endNavi;
	}

	public int getMaxPage() {
		return maxPage;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	@Override
	public String toString() {
		return "Pagenate [startNavi=" + startNavi + ", endNavi=" + endNavi + ", maxPage=" + maxPage + ", currentPage="
				+ currentPage + "]";
	}
	
}
