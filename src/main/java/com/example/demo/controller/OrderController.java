package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.DBManager;
import com.example.demo.vo.OrderVo;
import com.google.gson.Gson;

@RestController
public class OrderController {

	@GetMapping("/all/order")
	public String purchase(OrderVo o) {
		String str = "";
		
		//주문한 상품의 재고 수량을 불러온다.
		int goods_qty = DBManager.getGoods(o.getNo()).getQty();
		
		//재고수량이 주문수량보다 많은지 확인, 아니면 주문불가
		if(o.getOrder_qty() <= goods_qty) {
			
			int re = DBManager.order(o);
			if(re > 1) {
				str = "성공적으로 주문하였습니다.";
			}else {
				str = "주문에 실패하였습니다.";
			}
			
		}else {
			str = "상품의 재고가 부족합니다.";
		}
		
		return str;
	}
	
	@GetMapping("/all/orderList")
	public String orderList() {
		
		return (new Gson()).toJson( DBManager.orderList() );
	}
}
