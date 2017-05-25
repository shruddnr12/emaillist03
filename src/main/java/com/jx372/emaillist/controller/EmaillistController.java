package com.jx372.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jx372.emaillist.dao.EmaillistDao;
import com.jx372.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {

	@Autowired
	private EmaillistDao emaillistDao;
	
	@RequestMapping("/list")
	public String list(Model model){
		List<EmaillistVo> list = emaillistDao.getList();
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping("/form")
	public String form(){
		return "/WEB-INF/views/form.jsp"; //내일은 return "form"이라고 만들꺼다
	}
	
	@RequestMapping( value = "/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute EmaillistVo vo){
		emaillistDao.insert(vo);
		return "redirect:/list";
	}
}
