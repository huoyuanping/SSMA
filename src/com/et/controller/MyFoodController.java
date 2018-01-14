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
	 *������ֱ�ӷ��ض���  springmvc�Զ�ת��json(Ĭ���ǲ����� ��Ҫ��Ϣת����(MappingJackson2HttpMessageConverter)
	 *�Ḳ���ֽ��������Ϣת��������ͬʱ���ֽ��������Ϣת����ByteArrayHttpMessageConverter)
	 *���ע��@ResponseBody
	 */
	@ResponseBody
	@RequestMapping(value="/queryAllList",method={RequestMethod.GET})
	public List<Map<String, Object>> foodMap(String foodname) throws UnsupportedEncodingException, IOException{
		List<Map<String, Object>> queryFood=ms.queryAllFood(foodname);
		return queryFood;
	
	}
	/**
	 * ɾ������
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
	 * ��ӷ���
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
	 * �޸ķ���
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
