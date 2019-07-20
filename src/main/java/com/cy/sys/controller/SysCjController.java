package com.cy.sys.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.cy.sys.pojo.JsonResult;
import com.cy.sys.pojo.PageObject;
import com.cy.sys.pojo.SysCj;
import com.cy.sys.service.SysCjService;

@RestController
@RequestMapping("/cj/")
public class SysCjController {
	@Autowired
	private SysCjService sysCjService;

	/*
	 * @RequestMapping("doFindPageObjects") public JsonResult doFindPageObjects(
	 * String username,Integer pageCurrent) { PageObject<SysCj> po=
	 * sysCjService.findPageObjects( username,pageCurrent); return new
	 * JsonResult(po); }
	 * 
	 * @RequestMapping("doSaveObject")
	 * 
	 * @ResponseBody public JsonResult doSaveObject(SysCj entity){
	 * sysCjService.saveObject(entity); return new JsonResult("save ok"); }
	 */

	// 查询表中所有数据

	@RequestMapping("doFindPageObjects")
	public JsonResult doFindObjects(String cjTitle, Integer pageCurrent) {

		PageObject<SysCj> Objects = sysCjService.findPageObjects(cjTitle, pageCurrent);
		return new JsonResult(Objects);
	}

	// 向表中添加新数据
	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(SysCj entity) {
		sysCjService.saveObject(entity);
		return new JsonResult("insert ok");
	}

	// 根据奖惩主题模糊查询

	/*
	 * @RequestMapping("doFindObjectByCjTitle") public JsonResult
	 * doFindObjectByCjTitle(String cjTitle) { sysCjService.findObject(cjTitle);
	 * return new JsonResult("find ok"); }
	 */

	//@RequestMapping("doFindObjectByCjTitle")
	public JsonResult doFindObject(String cjTitle) {
		List<SysCj> findObject = sysCjService.findObject(cjTitle);
		return new JsonResult(findObject);
		
	}
	// 根据id删除记录
	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObjectById(Integer id) {
		sysCjService.deleteObjectById(id);
		return new JsonResult("delete ok");
	}

	// 通过cjTitle（奖惩主题）修改信息
	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObjectByCjTitle(SysCj entity) {
		sysCjService.updateObject(entity);
		return new JsonResult("update ok");
	}
}
