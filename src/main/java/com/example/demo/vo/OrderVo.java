package com.example.demo.vo;

public class OrderVo {

	private int order_id;
	private String id;
	private int no;
	private int order_qty;
	private String order_date;
	
	
	public OrderVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderVo(int order_id, String id, int no, int order_qty, String order_date) {
		super();
		this.order_id = order_id;
		this.id = id;
		this.no = no;
		this.order_qty = order_qty;
		this.order_date = order_date;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setOrder_qty(int order_qty) {
		this.order_qty = order_qty;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getOrder_id() {
		return order_id;
	}
	public String getId() {
		return id;
	}
	public int getNo() {
		return no;
	}
	public int getOrder_qty() {
		return order_qty;
	}
	public String getOrder_date() {
		return order_date;
	}	

}
