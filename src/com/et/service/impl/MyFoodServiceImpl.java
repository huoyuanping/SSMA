package com.et.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.et.dao.MyFoodDao;
import com.et.service.MyFoodService;
@Service
public class MyFoodServiceImpl implements MyFoodDao, MyFoodService {
	
	@Autowired
	MyFoodDao dao;
	
	public List<Map<String, Object>> queryAllFood(String foodname){
		
		return dao.queryAllFood(foodname);
	}

	
	public void deleteFood(String foodId){
		dao.deleteFood(foodId);
	}
	
	
	public void saveFood(String foodName,String price){
		dao.saveFood(foodName, price);
	}
	
	
	public void updateFood(String foodId,String foodName,String price){
		dao.updateFood(foodId, foodName, price);
	}
	
}
