package com.et.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.et.service.MyFoodService;

@Controller
public class MyFoodController {
	@Autowired
	MyFoodService ms;
	
	/**
	 *第三种直接返回对象  springmvc自动转成json(默认是不可以 需要消息转换器(MappingJackson2HttpMessageConverter)
	 *会覆盖字节数组的消息转换器所有同时加字节数组的消息转换器ByteArrayHttpMessageConverter)
	 *添加注解@ResponseBody
	 */
	@ResponseBody
	@RequestMapping(value="/queryAllList",method={RequestMethod.GET})
	public List<Map<String, Object>> foodMap(String foodname) throws UnsupportedEncodingException, IOException{
		List<Map<String, Object>> queryFood=ms.queryAllFood(foodname);
		return queryFood;
	
	}
	/**
	 * 删除方法
	 */
	@RequestMapping(value="/food/{foodid}",method=RequestMethod.DELETE)
	public String deleteFood(@PathVariable String foodid,OutputStream os,HttpServletResponse response) throws UnsupportedEncodingException, IOException{
		try {
			ms.deleteFood(foodid);
			os.write("1".getBytes("UTF-8"));
			
		} catch (Exception e) {
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	/**
	 * 添加方法
	 */
	@RequestMapping(value="/food",method={RequestMethod.POST})
	public String saveFood(String foodName,String price,OutputStream os,HttpServletResponse response) throws UnsupportedEncodingException, IOException{
		try {
			ms.saveFood( foodName, price);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	/**
	 * 修改方法
	 */
	@RequestMapping(value="/food/{foodid}",method={RequestMethod.PUT})
	public String updateFood(@PathVariable String foodid,String foodName,String price,OutputStream os,HttpServletResponse response) throws UnsupportedEncodingException, IOException{
		try {
			ms.updateFood(foodid, foodName, price);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}

}
