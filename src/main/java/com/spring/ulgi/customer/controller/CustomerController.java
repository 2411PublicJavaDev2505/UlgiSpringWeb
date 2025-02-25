package com.spring.ulgi.customer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.ulgi.common.PageUtil;
import com.spring.ulgi.common.vo.Pagenate;
import com.spring.ulgi.customer.controller.dto.InsertRequest;
import com.spring.ulgi.customer.controller.dto.UpdateRequest;
import com.spring.ulgi.customer.model.service.CustomerService;
import com.spring.ulgi.customer.model.vo.Customer;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerService cService;
	
	public CustomerController(CustomerService cService) {
		this.cService = cService;
	}

	@GetMapping("/list")
	public String showCustomerList(Model model
			,@RequestParam(value="currentPage", defaultValue = "1") int currentPage) {
		try {
			int totalCount = cService.getTotalCount();
			List<Customer> cList = cService.selectCustomerList(currentPage);
			Pagenate page = PageUtil.getPagenate(totalCount, currentPage);
			model.addAttribute("page",page);
			model.addAttribute("cList",cList);
			return "customer/list";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",e.getMessage());
			return "common/error";
		}
	}
	
	@GetMapping("/search")
	public String searchCustomerList(Model model
			,@RequestParam("searchCondition") String searchCondition
			,@RequestParam("searchKeyword") String searchKeyword
			,@RequestParam(value="currentPage", defaultValue = "1") int currentPage) {
		try {
			Map<String,String> searchMap = new HashMap<String, String>();
			searchMap.put("searchCondition", searchCondition);
			searchMap.put("searchKeyword", searchKeyword);
			int totalCount = cService.getTotalCount(searchMap);
			Pagenate page = PageUtil.getPagenate(totalCount, currentPage);
			
			List<Customer> cList = cService.selectCustomerList(searchMap, currentPage);
			
			model.addAttribute("search",searchMap);
			model.addAttribute("cList",cList);
			model.addAttribute("page",page);
			
			return "customer/search";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",e.getMessage());
			return "common/error";
		}
	}
	
	@GetMapping("/detail")
	public String showCustomerDetail(Model model
			,@RequestParam("userNo") int userNo) {
		try {
			Customer customer = cService.selectOneByUserNo(userNo);
			if(customer != null) {
				model.addAttribute("customer",customer);
				return "customer/detail";
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
	
	@PostMapping("/update")
	public String customerUpdate(Model model
			,@ModelAttribute UpdateRequest customer) {
		try {
			int result = cService.updateCustomer(customer);
			if(result > 0) {
				model.addAttribute("userNo",customer.getUserNo());
				return "redirect:/customer/detail";
			}else {
				model.addAttribute("errorMessage","데이터 수정에 실패하였습니다.");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",e.getMessage());
			return "common/error";
		}
	}
	
	@GetMapping("/delete")
	public String customerDelete(Model model
			,@RequestParam("userNo") int userNo) {
		try {
			int result = cService.deleteCustomer(userNo);
			if(result > 0) {
				return "redirect:/customer/list";
			}else {
				model.addAttribute("errorMessage","데이터 삭제에 실패하였습니다.");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",e.getMessage());
			return "common/error";
		}
	}
	
	@GetMapping("/insert")
	public String showCustomerInsert(Model model) {
		try {
			return "/customer/insert";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",e.getMessage());
			return "common/error";
		}
	}
	
	@PostMapping("/insert")
	public String customerInsert(Model model
			,@ModelAttribute InsertRequest customer) {
		try {
			int result = cService.customerInsert(customer);
			if(result > 0) {
				return "redirect:/customer/list";
			}else {
				model.addAttribute("errorMessage","데이터 삽입에 실패하였습니다.");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",e.getMessage());
			return "common/error";
		}
	}
}
