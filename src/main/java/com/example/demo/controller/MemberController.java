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
	
	@RequestMapping("")
	public String getMember(String id) {
		String str = "";
		dao.getMember(id);
		return str;
	}

	@RequestMapping("/all/updateMember")
	public String updateMember(MemberVo m) {
		String str ="수정 완료";
//		String m1 = m.getPwd();
//		System.out.println(m1);
//		MemberVo mv = new MemberVo();
//		String v = mv.getPwd();
//		System.out.println(v);
//		dao.updateMember(m);
//		System.out.println(str);
		return str;
	}
	
	@RequestMapping("/all/insertMember")
	public String insertMember(MemberVo m) {
		String str="";
		dao.insertMember(m);
		return str;
	}

}
