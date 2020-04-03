package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MemberDao;
import com.example.demo.vo.MemberVo;

@RestController
public class MemberController {
	
	@Autowired
	private MemberDao dao;
	
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}

	
	@RequestMapping("/insertMember")
	public String insertMember(MemberVo m) {
		String str="";
		dao.insertMember(m);
		return str;
	}

}
