package com.newlecture.web.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.NoticeView;

@Controller
@RequestMapping("/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeDao noticeDao;
	/*
	@RequestMapping("list")
	public void list() {
		//NoticeDao noticeDao = new NoticeDao;가아니라 Autowired
		System.out.println("notice list 요청이있었습니다.");
		
	}
	*/
	/*
	@RequestMapping("list")
	public String list(Model model) throws ClassNotFoundException, SQLException {
		List<NoticeView> list = noticeDao.getList();
		model.addAttribute("list", list);
		return "notice/list";
	}
	*/

	
	//입력방법 1: 서블릿 기능을 이용한 입력방법
	/*
	@RequestMapping("list")
	public String list(Model model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		int page = 1;
		String p= request.getParameter("p");
		if(p != null && !p.equals(""))
			page = Integer.parseInt(p);
		
		List<NoticeView> list = noticeDao.getList(page);
		
		model.addAttribute("list", list);
		
		return "notice/list";
	}
	*/
	
	
	//입력방법 2: 스프링 기능을 이용한 입력방법
	/*
	@RequestMapping("list") // list?p=1
	public String list(Model model, int p) throws ClassNotFoundException, SQLException {
		
		List<NoticeView> list = noticeDao.getList(p);
		
		model.addAttribute("list", list);
		
		return "notice/list";
	}
	*/
	
	//입력방법 3: 
	/*
	@RequestMapping("list") // list?p=1
	public String list(Model model, @RequestParam("p") Integer page) throws ClassNotFoundException, SQLException {
		
		List<NoticeView> list = noticeDao.getList(page);
		
		model.addAttribute("list", list);
		
		return "notice/list";
	}
	*/
	
	//입력방법 4: 기본값도 설정해줄 수 있다.
		@RequestMapping("list") // list?p=1
		public String list(Model model
				//, @RequestParam(name="p", defaultValue="1") Integer page 이렇게 내려쓰는게 효율적
				, @RequestParam(name="p", defaultValue="1") Integer page
				) throws ClassNotFoundException, SQLException {
			
			List<NoticeView> list = noticeDao.getList(page);
			
			model.addAttribute("list", list);
			
			return "notice.list";
		}
	
	
	
}
