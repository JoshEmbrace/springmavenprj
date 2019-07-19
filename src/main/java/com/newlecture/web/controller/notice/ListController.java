package com.newlecture.web.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.NoticeView;


@Repository
public class ListController implements Controller {
	
	@Autowired
	private NoticeDao noticeDao;
	
	/*
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	*/

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//NoticeDao noticeDao = new OracleNoticeDao();
		
		List<NoticeView> list = noticeDao.getList();
		
		ModelAndView mv = new ModelAndView("admin/notice/list");

		mv.addObject("list", list);
		return mv;
	}
	
}
