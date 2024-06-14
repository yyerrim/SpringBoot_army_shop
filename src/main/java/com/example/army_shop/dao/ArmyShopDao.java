package com.example.army_shop.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ArmyShopDao {
	@Autowired
	JdbcTemplate jt;

	// public List<Map<String, Object>> select(String year, String month) {
	// 	String sql = "select * from army_shop"
	// 			+ " where year = " + year
	// 			+ " and month = " + month;
	// 	return jt.queryForList(sql);
	// }
	// 원래 sql 문장으로 쓰는건 안좋은거임 -> 해킹당함
	// 아래가 더 좋은 방식
	public List<Map<String, Object>> select(String year, String month) {
		String sql = "select * from army_shop"
				+ " where year=? "
				+ " and month=?";
		return jt.queryForList(sql, year, month); // ? 순서에 맞춰서 변수 넣어주기
	}
}
