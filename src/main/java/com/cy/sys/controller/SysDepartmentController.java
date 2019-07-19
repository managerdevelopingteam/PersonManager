package com.cy.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cy.sys.pojo.JsonResult;
import com.cy.sys.pojo.PageObject;
import com.cy.sys.pojo.SysDepartment;
import com.cy.sys.service.SysDepartmentService;


@RestController
@RequestMapping("/department/")
public class SysDepartmentController {
	@Autowired
	private SysDepartmentService sysDepartmentService;
	
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(
			String username,Integer pageCurrent) {
		PageObject<SysDepartment> po=
				sysDepartmentService.findPageObjects(
						username,pageCurrent);
		return new JsonResult(po);
	}
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysDepartment entity){
		sysDepartmentService.saveObject(entity);
		return new JsonResult("save ok");
	}
	

}
