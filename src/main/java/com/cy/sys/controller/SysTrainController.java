package com.cy.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.sys.pojo.JsonResult;
import com.cy.sys.pojo.PageObject;
import com.cy.sys.pojo.SysTrain;
import com.cy.sys.service.SysTrainService;

@RestController
@RequestMapping("train/")
public class SysTrainController {

	@Autowired
	private SysTrainService service;
	/**
	 * 	查询所有培训信息
	 * @return JsonResult
	 */
	@RequestMapping("doFindPageObjects")
	public JsonResult dofindobjects(String tnMan,Integer pageCurrent) {
			PageObject<SysTrain> po=service.findPageObjects(tnMan,pageCurrent);
			return new JsonResult(po);
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
		@RequestMapping("doFindObjectById")
		public JsonResult doFindTrianObjectByTnMan(Integer id) {
			SysTrain sysTrain = service.findTrainObjectById(id);
			return new JsonResult(sysTrain);
		}

		/**
		 * 根据id删除培训信息
		 * @param result
		 * @return JsonResult
		 */
		@RequestMapping("doDeleteObject")
		public JsonResult doDeleteTrianObjectById(Integer id) {
			service.deleteTrainObjectById(id);
			return new JsonResult("delete ok!");
		}



	}
