package com.cy.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

	//根据奖惩主题模糊查询全部数据
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(String cjTitle, Integer pageCurrent) {
		PageObject<SysCj> po = sysCjService.findPageObjects(cjTitle, pageCurrent);
		return new JsonResult(po);
	}

	//添加数据
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysCj entity) {
		sysCjService.saveObject(entity);
		return new JsonResult("save ok");
	}

	//修改数据
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysCj entity) {
		sysCjService.updateObject(entity);
		return new JsonResult("update ok");
	}

	//根据id查询单条数据
	@RequestMapping("doFindObjectById")
	public JsonResult doFindObjectById(Integer id) {
		List<SysCj> list = sysCjService.findObjectById(id);
		SysCj sysCj = list.get(0);
		return new JsonResult(sysCj);
	}

	//根据id删除数据
	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObject(Integer id) {
		sysCjService.deleteObject(id);
		return new JsonResult("delete ok");
	}

}
