package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MemberDao;
import com.example.demo.vo.MemberVo;
import com.google.gson.Gson;



@RestController
public class MemberController {
	
	@Autowired
	private MemberDao dao;
	
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/all/updateMember")
	public String updateMember(MemberVo m) {
		String str ="";
		dao.updateMember(m);
		return str;
	}
	
	@RequestMapping(value = "/all/detail", produces = "application/json;charset=UTF-8")
	public String memberInfo(MemberVo m) {
		String str ="";
		Gson gson = new Gson();
		str = gson.toJson(dao.getMember(m));
		return str;
	}
	
	@RequestMapping("/all/insertMember")
	public String insertMember(MemberVo m) {
		String str="";
		dao.insertMember(m);
		return str;
	}

}
