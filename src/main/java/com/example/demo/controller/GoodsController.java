package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.DBManager;
import com.example.demo.vo.GoodsVo;
import com.google.gson.Gson;

@RestController
public class GoodsController {
	
	
	@RequestMapping(value = "/list", produces = "application/json;charset=UTF-8")
	public String list(HttpServletRequest request) {
		String str = "";
		List<GoodsVo> list = DBManager.listAllgs();
		Gson gson = new Gson();
		str = gson.toJson(list);
		return str;
	}
	
	
	@RequestMapping("/insertGoods")
	public String insertEmp(GoodsVo g) {
		String str = "false";
		int re = DBManager.insertGoods(g);
		if ( re > 0) {
			str = "등록에 성공하였습니다.";
		}else {
			str = "등록에 실패하였습니다.";
		}
		return str;
	}
	@RequestMapping("/deleteGoods")
	public String deleteGoods(GoodsVo g, HttpServletRequest request) {
		String str = "ok";
		DBManager.deleteGoods(g);
		return str;
	}
	
	@RequestMapping("/updateGoods")
	public String updateEmp(GoodsVo g, HttpServletRequest request) {
		String str = "ok";
		DBManager.updateGoods(g);
		return str;
	}
	
	
}
