package com.cy.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.sys.pojo.JsonResult;
import com.cy.sys.pojo.SysTrain;
import com.cy.sys.service.SysTrainService;

@Controller
public class SysTrainController {

	@Autowired
	private SysTrainService service;
	/**
	 * 查询所有培训信息
	 * @return JsonResult
	 */
	@RequestMapping("doTrainFindObjects")
	public JsonResult dofindobjects() {
		List<SysTrain> list = service.findObjects();
		JsonResult result = new JsonResult();
		//将查询到的培训信息封装到JsonResult
		result.setData(list);
		result.setState(1);
		result.setMessage("query ok");
		return result;
	}
	/**
	 * 插入一条培训记录
	 * @param result 前端传过来的JsonResult
	 * @return JsonResult
	 */
	@RequestMapping("doTrainAddObject")
	public JsonResult doAddTrainObject(JsonResult result) {
		//将收到的JsonResult里面的data提取出来,转化为Train
		SysTrain train = (SysTrain)result.getData();
		service.addTrainObject(train);
		return new JsonResult("insert ok!");
	}
	/**
	 * 根据id查询培训信息
	 * @param result
	 * @return JsonResult
	 */
	@RequestMapping("doFindTrianObjectById")
	public JsonResult doFindTrianObjectById(JsonResult result) {
		//将收到的JsonResult里面的data提取出来,转化为Integer
		Integer id = (Integer)result.getData();
		service.findTrainObjectById(id);
		return new JsonResult("query ok!");
	}
	
	/**
	 * 根据id删除培训信息
	 * @param result
	 * @return JsonResult
	 */
	@RequestMapping("doDeleteTrianObjectById")
	public JsonResult doDeleteTrianObjectById(JsonResult result) {
		//将收到的JsonResult里面的data提取出来,转化为Integer
		Integer id = (Integer)result.getData();
		service.deleteTrainObjectById(id);
		return new JsonResult("delete ok!");
	}
	


}
