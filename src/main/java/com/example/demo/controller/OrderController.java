package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.DBManager;
import com.example.demo.vo.OrderVo;
import com.google.gson.Gson;

@RestController
public class OrderController {

	@GetMapping("/purchase")
	public String purchase(OrderVo o) {
		String str = "";
		
		
		
		return str;
	}
	
	@GetMapping("/orderList")
	public String orderList() {
		
		return (new Gson()).toJson( DBManager.orderList() );
	}
}
