package com.spring.ulgi.common;


import com.spring.ulgi.common.vo.Pagenate;

public class PageUtil {

	public static Pagenate getPagenate(int totalCount, int currentPage) {
		int boardLimit = 10;
		int naviLimit = 5;
		int startNavi = (currentPage-1)/naviLimit*naviLimit+1;
		int endNavi = startNavi + naviLimit - 1;
		int maxPage = totalCount%boardLimit == 0 ? totalCount/boardLimit : totalCount/boardLimit+1;
		if(endNavi > maxPage)
			endNavi = maxPage;
		Pagenate page = new Pagenate(startNavi, endNavi, maxPage, currentPage);
		return page;
	}


}
