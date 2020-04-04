package com.example.demo.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
	public String updateMember(String id, String pwd) {
		String str ="";
		MemberVo m = new MemberVo();
		
		
		
//		if(id.equals(m.getId()) &&  pwd.equals(m.getPwd())) {
//			dao.updateMember(m);
//		}
//		String m1 = m.getPwd();
//		System.out.println(m1);
//		MemberVo mv = new MemberVo();
//		String v = mv.getPwd();
//		System.out.println(v);
//		dao.updateMember(m);
//		System.out.println(str);
		
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
