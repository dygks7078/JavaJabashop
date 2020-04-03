package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.MemberVo;

@Repository
public class MemberDao {

	public MemberVo selectMember(String username) {
		return DBManager.selectMember(username);
	}
	
	public MemberVo getMember(String id) {
		return DBManager.getMember(id);
	}
	
	public int deleteMember(MemberVo m) {
		return DBManager.deleteMember(m);
	}
	
	public int updateMember(MemberVo m) {
		return DBManager.updateMember(m);
	}
	
	public int insertMember(MemberVo m) {
		return DBManager.insertMember(m);
	}
	
	public List<MemberVo> listAll(){
		return DBManager.listAll();
	}
}
