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
	
	/**添加部门信息*/
	@RequestMapping("doSaveObjects")
	public JsonResult doFindPageObjects(SysDepartment entity) {
		sysDepartmentService.saveDeptObject(entity);
		return new JsonResult("save ok");
	}

}
