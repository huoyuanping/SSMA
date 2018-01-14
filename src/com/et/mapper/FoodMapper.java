package com.et.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface FoodMapper {
	/**
	 * ��ѯ
	 */
	@Select("select * from food where foodname like '%${foodname}%'")
	public List<Map<String, Object>> queryAllFood(@Param("foodname")String foodname);
	/**
	 * ɾ��
	 */
	@Delete("delete from food where foodid=#{0}")
	public void deleteFood(String foodId);
	/**
	 * ���
	 */
	@Insert("insert into food(foodid,foodname,price) values((select IFNULL(max(foodid),0)+1 from food f),#{0},#{1})")
	public void saveFood(String foodName,String price);
	/**
	 * �޸�
	 */
	@Update("update food set foodname=#{1},price=#{2} where foodid=#{0}")
	public void updateFood(String foodId,String foodName,String price);
}
