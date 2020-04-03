package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.GoodsVo;

@Repository
public class GoodsDao {

	public int updateGoods(GoodsVo g) {
		return DBManager.updateGoods(g);
	}

	public int deleteGoods(GoodsVo g) {
		return DBManager.deleteGoods(g);
	}
	
}
