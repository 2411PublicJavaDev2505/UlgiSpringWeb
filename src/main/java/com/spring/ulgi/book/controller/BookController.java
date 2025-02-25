package com.spring.ulgi.book.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.ulgi.book.model.service.BookService;
import com.spring.ulgi.book.model.vo.BookVO;
import com.spring.ulgi.common.PageUtil;
import com.spring.ulgi.common.vo.Pagenate;


@Controller
@RequestMapping("/book")
public class BookController {
	
	private BookService bService;
	
	@Autowired // 필드 의존성 주입
	public BookController(BookService bService) {
		this.bService = bService;
	}
	
	// 도서 추가
	@GetMapping("/insert")
	public String showNoticeForm(Model model) {
		try {
			return "book/insert";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", e.getMessage());
			return "common/error";
		}
	}
	@PostMapping("/insert")
	public String insertBook(
			@ModelAttribute BookVO book
			, Model model) {
		try {
			int result = bService.insertBook(book);
			if(result > 0) {
				return "redirect:/book/list";
			}else {
				model.addAttribute("errorMessage", "서비스가 완료되지 않았습니다.");
				return "common/error";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("errorMessage", e.getMessage());
			return "common/error";
		}
	}
	
	// 도서 삭제
	@GetMapping("/delete")
	public String deleteBook(
			@RequestParam("bookNo") int bookNo, Model model) {
		try {
			int result = bService.deleteBook(bookNo);
			return "redirect:/book/list";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("errorMessage",e.getMessage());
			return "common/error";
		}
	}
	
	// 도서 목록
	@GetMapping("/list")
	public String showBookList(
			@RequestParam(value="currentPage", defaultValue="1")int currentPage
			, Model model) {
		try {
			
			List<BookVO> bList = bService.selectListAll(currentPage);
			int totalCount = bService.getTotalCount();
			Pagenate page = PageUtil.getPagenate(totalCount, currentPage);			
			if(!bList.isEmpty()) {
				model.addAttribute("page",page);
				model.addAttribute("bList", bList);
				return "book/list";
			}else {
				model.addAttribute("errorMessage","데이터가 존재하지 않습니다.");
				return "common/error";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("errorMessage",e.getMessage());
			return "common/error";
		}
	}
	
	// 상세 페이지
	@GetMapping("/detail")
	public String showBookDetail(
			@RequestParam("bookNo") int bookNo ,Model model) {
		try {
			BookVO book = bService.selectOneByNo(bookNo);
			model.addAttribute("book",book);
			return "book/detail";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("errorMessage",e.getMessage());
			return "common/error";
		}
	}
	
	// 검색
	@GetMapping("/search")
	public String showSearchList(
			 @RequestParam("searchCondition") String searchCondition
			, @RequestParam("searchKeyword") String searchKeyword
			, @RequestParam(value="currentPage", defaultValue="1" )int currentPage
			, Model model) {
		try {
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("searchCondition", searchCondition);
			paramMap.put("searchKeyword", searchKeyword);
			List<BookVO> searchList = bService.selectSearchList(paramMap, currentPage);
			int totalCount = bService.getTotalCount(paramMap);
			Pagenate page = PageUtil.getPagenate(totalCount, currentPage);
			model.addAttribute("page",page);
			model.addAttribute("searchList", searchList);
			model.addAttribute("searchCondition", searchCondition);
			model.addAttribute("searchKeyword", searchKeyword);
			return "book/search";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",e.getMessage());
			return "common/error";
		}
	}
	
}
