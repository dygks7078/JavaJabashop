package com.example.demo.controller;

import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.db.DBManager;
import com.example.demo.vo.GoodsVo;
import com.google.gson.Gson;

@RestController
public class GoodsController {
	
	
	@RequestMapping(value = "/getGoods",produces = "application/json;charset=UTF-8")
	public String getGoods(GoodsVo g) {
		return(new Gson()).toJson(DBManager.getGoods(g));
	}
	
	@RequestMapping(value = "/list", produces = "application/json;charset=UTF-8")
	public String list(HttpServletRequest request) {
		String str = "";
		List<GoodsVo> list = DBManager.listAllgs();
		Gson gson = new Gson();
		str = gson.toJson(list);
		return str;
	}	
	
	@RequestMapping("/insertGoods")
	public String insertGoods(GoodsVo g, HttpServletRequest request) {
		String str = "ok";
		//String path = request.getRealPath("/resources/static/img");
		String path = "C:\\Users\\PC\\git\\JavaJabashop\\src\\main\\resources\\static\\img";
		MultipartFile uploadFile = g.getUploadFile();
		String fname = "";
		if(uploadFile != null) {
			fname = uploadFile.getOriginalFilename();
			try {
				byte []data = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		
		g.setFname(fname);
		
		DBManager.insertGoods(g);
		
		
		return str;
	}
	
	@RequestMapping("/deleteGoods")
	public String deleteGoods(GoodsVo g){
		String str = "ok";
		String path = "C:\\Users\\PC\\git\\JavaJabashop\\src\\main\\resources\\static\\img";
		MultipartFile uploadFile = g.getUploadFile();
		String fname = "";
		if(uploadFile != null) {
			fname = uploadFile.getOriginalFilename();
			try {
				byte []data = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		g.setFname(fname);
		DBManager.deleteGoods(g);
		return str;
		}
	
	@RequestMapping("/updateGoods")
	public String updateGoods(GoodsVo g) {
	String str = "ok";
	//String path = request.getRealPath("/resources/static/img");
	String path = "C:\\Users\\PC\\git\\JavaJabashop\\src\\main\\resources\\static\\img";
	MultipartFile uploadFile = g.getUploadFile();
	String fname = "";
	if(uploadFile != null) {
		fname = uploadFile.getOriginalFilename();
		try {
			byte []data = uploadFile.getBytes();
			FileOutputStream fos = new FileOutputStream(path + "/" + fname);
			fos.write(data);
			fos.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	g.setFname(fname);
	DBManager.updateGoods(g);
	return str;
	}
	
	
}
