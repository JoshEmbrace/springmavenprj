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
		//NoticeDao noticeDao = new NoticeDao;���ƴ϶� Autowired
		System.out.println("notice list ��û���־����ϴ�.");
		
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

	
	//�Է¹�� 1: ���� ����� �̿��� �Է¹��
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
	
	
	//�Է¹�� 2: ������ ����� �̿��� �Է¹��
	/*
	@RequestMapping("list") // list?p=1
	public String list(Model model, int p) throws ClassNotFoundException, SQLException {
		
		List<NoticeView> list = noticeDao.getList(p);
		
		model.addAttribute("list", list);
		
		return "notice/list";
	}
	*/
	
	//�Է¹�� 3: 
	/*
	@RequestMapping("list") // list?p=1
	public String list(Model model, @RequestParam("p") Integer page) throws ClassNotFoundException, SQLException {
		
		List<NoticeView> list = noticeDao.getList(page);
		
		model.addAttribute("list", list);
		
		return "notice/list";
	}
	*/
	
	//�Է¹�� 4: �⺻���� �������� �� �ִ�.
		@RequestMapping("list") // list?p=1
		public String list(Model model
				//, @RequestParam(name="p", defaultValue="1") Integer page �̷��� �������°� ȿ����
				, @RequestParam(name="p", defaultValue="1") Integer page
				) throws ClassNotFoundException, SQLException {
			
			List<NoticeView> list = noticeDao.getList(page);
			
			model.addAttribute("list", list);
			
			return "notice.list";
		}
	
	
	
}
