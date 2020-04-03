package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MemberDao;
import com.example.demo.db.DBManager;
import com.example.demo.vo.MemberVo;
import com.google.gson.Gson;

@RestController
public class MemberController {
	
	@Autowired
	private MemberDao dao;
	
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}

	
	@RequestMapping("/all/insertMember")
	public String insertMember(MemberVo m) {
		String str="";
		dao.insertMember(m);
		return str;
	}
	
	@RequestMapping(value = "/all/listMember", produces = "application/json;charset=UTF-8")
	public String listMember() {
		String str = "";
		List<MemberVo> list = DBManager.listAll();
		Gson gson = new Gson();
		str = gson.toJson(list);
		return str;
	}

}
