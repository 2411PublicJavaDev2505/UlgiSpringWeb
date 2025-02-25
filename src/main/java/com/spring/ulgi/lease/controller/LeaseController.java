package com.spring.ulgi.lease.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.ulgi.common.PageUtil;
import com.spring.ulgi.common.vo.Pagenate;
import com.spring.ulgi.lease.controller.dto.LeaseInsertRequest;
import com.spring.ulgi.lease.model.service.LeaseService;
import com.spring.ulgi.lease.model.vo.Library;

@Controller
@RequestMapping("/lease")
public class LeaseController {

	private LeaseService lService;
	
	@Autowired
	public LeaseController(LeaseService lService) {
		this.lService = lService;
	}
	
	@GetMapping("/list")
	public String showLeaseList(Model model
			,@RequestParam(value="currentPage", defaultValue = "1") int currentPage) {
		try {
			int totalCount = lService.getTotalCount();
			List<Library> lList = lService.selectLeaseList(currentPage);
			Pagenate page = PageUtil.getPagenate(totalCount, currentPage);
			
			model.addAttribute("page",page);
			model.addAttribute("lList",lList);
			return "lease/list";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",e.getMessage());
			return "common/error";
		}
	}
	
	@GetMapping("/search")
	public String searchLeaseList(Model model
			,@RequestParam(value="currentPage",defaultValue = "1") int currentPage
			,@RequestParam("searchCondition") String searchCondition
			,@RequestParam("searchKeyword") String searchKeyword) {
		try {
			Map<String,String> searchMap = new HashMap<String, String>();
			searchMap.put("searchCondition", searchCondition);
			searchMap.put("searchKeyword", searchKeyword);
			int totalCount = lService.getTotalCount(searchMap);
			List<Library> lList = lService.selectLeaseList(currentPage, searchMap);
			Pagenate page = PageUtil.getPagenate(totalCount, currentPage);
			
			model.addAttribute("search",searchMap);
			model.addAttribute("page",page);
			model.addAttribute("lList",lList);
			return "lease/search";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",e.getMessage());
			return "common/error";
		}
	}
	
	@GetMapping("/insert")
	public String showLeaseInsert(Model model) {
		try {
			List<String> bList = lService.selectBooknameList();
			List<String> uList = lService.selectUseridList();
			model.addAttribute("bList",bList);
			model.addAttribute("uList",uList);
			return "lease/insert";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",e.getMessage());
			return "common/error";
		}
	}
	
	@PostMapping("/insert")
	public String leaseInsert(Model model
			,@RequestParam("bookName") String bookName
			,@RequestParam("userId") String userId) {
		try {
			int bookNo = lService.selectBooknoByBookname(bookName);
			LeaseInsertRequest lease = new LeaseInsertRequest(bookNo, userId);
			int result = lService.leaseInsert(lease);
			if(result > 0) {
				return "redirect:/lease/list";
			}else {
				model.addAttribute("errorMessage","대출이 완료되지 않았습니다.");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",e.getMessage());
			return "common/error";
		}
	}
	
	@GetMapping("/detail")
	public String showLeaseDetail(Model model
			,@RequestParam("leaseNo") int leaseNo) {
		try {
			Library library = lService.selectOneByLeaseNo(leaseNo);
			if(library != null) {
				model.addAttribute("library",library);
				return "lease/detail";
			}else {
				model.addAttribute("errorMessage","데이터를 찾을 수 없습니다.");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",e.getMessage());
			return "common/error";
		}
	}
	
	@GetMapping("/delete")
	public String leaseDelete(Model model
			,@RequestParam("leaseNo") int leaseNo) {
		try {
			int result = lService.leaseDelete(leaseNo);
			if(result > 0) {
				return "redirect:/lease/list";
			}else {
				model.addAttribute("errorMessage","데이터 삭제에 실패했습니다.");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",e.getMessage());
			return "common/error";
		}
	}
}
