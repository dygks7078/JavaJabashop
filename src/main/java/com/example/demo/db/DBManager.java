  
package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.GoodsVo;
import com.example.demo.vo.MemberVo;
import com.example.demo.vo.OrderVo;

public class DBManager {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public static MemberVo selectMember(String username){
		SqlSession session = factory.openSession();
		MemberVo m = session.selectOne("member.selectMember", username);
		session.close();
		return m;
	}
	
	
	public static List<GoodsVo> listAllgs(){
		SqlSession session = factory.openSession();
		List<GoodsVo> list = session.selectList("goods.selectAll");
		session.close();
		return list;
	}
	
	
	public static int insertGoods(GoodsVo g) {
		int re =  -1;
		SqlSession session = factory.openSession();
		re= session.insert("goods.insert", g);
		session.commit();
		session.close();
		return re;
	}
	
	public static GoodsVo getGoods(int no) {
		
		SqlSession session = factory.openSession();
		GoodsVo g = session.selectOne("goods.detail", no);
		session.close();
		
		return g;
	}

	public static int deleteGoods(GoodsVo g) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.delete("goods.deleteGoods", g);
		session.close();
		return re;
	}
	
	public static int updateGoods(GoodsVo g) {
		int re =  -1;
		SqlSession session = factory.openSession();
		re= session.update("goods.updateGoods",g);
		session.close();
		return re;
	}

	public static int insertMember(MemberVo m) {
		int re =  -1;
		SqlSession session = factory.openSession();
		re= session.insert("member.insert", m);
		session.commit();
		session.close();
		return re;
	}
	
	public static List<MemberVo> listAll(){
		SqlSession session = factory.openSession();
		List<MemberVo> list = session.selectList("member.selectAll");
		session.close();
		return list;
	}
	
	public static int deleteMember(MemberVo m) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.delete("member.delete", m);
		session.commit();
		session.close();
		return re;
	}
	
	public static int updateMember(MemberVo m) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.update("member.update", m);
		return re;
	}
	
	
	
	public static MemberVo getMember(String id) {
		MemberVo m = new MemberVo();
		SqlSession session = factory.openSession();
		m = session.selectOne("member.getMember",id);
		session.close();
		return m;
	}
	
	//show orderList
	public static List<OrderVo> orderList(){
		SqlSession session = factory.openSession();
		List<OrderVo> list = session.selectList("order.orderList");
		session.close();
		return list;
	}
	
	public static GoodsVo getGoods(GoodsVo g) {
		SqlSession session = factory.openSession();
		GoodsVo gv =session.selectOne("goods.getGoods", g);
		session.close();
		return gv;
	}
	
	//order
	public static int order(OrderVo o) {
		SqlSession session = factory.openSession();
		int re = session.insert("order.insert", o);
		int re1 = session.update("goods.orderGoods", o);
		
		if(re>0 && re1>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return (re+re1);
	}
	
//	
//	public static List<MemberVo> selectMemberAll(){
//		SqlSession session = factory.openSession();
//		List<MemberVo> list  = session.selectList("member.selectAll");
//		session.close();
//		return list;
//	}
//	
//	public static MemberVo selectMember(String username){
//		SqlSession session = factory.openSession();
//		MemberVo m = session.selectOne("member.selectMember",username);
//		session.close();
//		return m;
//	}
//
//	public static int insertMember(MemberVo m) {
//		int re =  -1;
//		SqlSession session = factory.openSession();
//		re= session.insert("member.insert",m);
//		session.commit();
//		session.close();
//		return re;
//	}
}