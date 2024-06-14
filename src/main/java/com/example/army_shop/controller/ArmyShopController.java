package com.example.army_shop.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.army_shop.dao.ArmyShopDao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ArmyShopController {
	@Autowired
	ArmyShopDao armyShopDao;

	@GetMapping("army_shop/{year}/{month}")
	public List<Map<String, Object>> armyShop1(
			@PathVariable("year") String year, // int도 사용 가능
			@PathVariable("month") String month) {
		return armyShopDao.select(year, month);
	}

	@GetMapping("army_shop")
	public List<Map<String, Object>> armyShop2(
			@RequestParam(value="year", defaultValue="2021") String year,
			@RequestParam(value="month", defaultValue="5") String month) {
		return armyShopDao.select(year, month);
	}

}
