package com.et.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.et.dao.MyFoodDao;
import com.et.mapper.FoodMapper;

@Repository
public class MyFoodDaoImpl implements MyFoodDao {
	@Autowired
	FoodMapper mapper;
	
	public List<Map<String, Object>> queryAllFood(String foodname){
		return mapper.queryAllFood(foodname);
		
	}
	public void deleteFood(String foodId){
		mapper.deleteFood(foodId);
	}
	public void saveFood(String foodName,String price){
		mapper.saveFood(foodName, price);
	}
	public void updateFood(String foodId,String foodName,String price){
		mapper.updateFood(foodId, foodName, price);
	}

}
