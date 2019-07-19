package com.cy.sys.controller;

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
	
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(
			String username,Integer pageCurrent) {
		PageObject<SysCj> po=
				sysCjService.findPageObjects(
						username,pageCurrent);
		return new JsonResult(po);
	}
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysCj entity){
		sysCjService.saveObject(entity);
		return new JsonResult("save ok");
	}
	

}
