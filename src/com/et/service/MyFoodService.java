package com.et.service;

import java.util.List;
import java.util.Map;

public interface MyFoodService {
	/**
	 * ²éÑ¯
	 * @param foodname
	 * @return
	 */
	public abstract List<Map<String, Object>> queryAllFood(String foodname);
	/**
	 * É¾³ý
	 * @param foodId
	 */
	public abstract void deleteFood(String foodId);
	/**
	 * Ìí¼Ó
	 * @param foodName
	 * @param price
	 */
	public abstract void saveFood(String foodName, String price);
	/**
	 * ÐÞ¸Ä
	 * @param foodId
	 * @param foodName
	 * @param price
	 */
	public abstract void updateFood(String foodId, String foodName, String price);

}