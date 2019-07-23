package com.cy.sys.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.sys.pojo.JsonResult;
import com.cy.sys.pojo.SysEmployee;
import com.cy.sys.service.SysEmployeeService;



@RestController
@RequestMapping("/employee/")
public class SysEmployeeController {
	@Autowired
	SysEmployeeService employeeService;
	
	/**
	 * 保存添加的员工信息
	 * @param entity
	 * @return
	 */
	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(SysEmployee entity) {
		employeeService.saveObject(entity);		
		return new JsonResult("save ok");		
	}
	
	/**
	 * 通过id查找员工信息
	 */
	@RequestMapping("doFindObjectById")
	public JsonResult doFindObjectById(Integer id){
		List<SysEmployee> result=employeeService.findObjectById(id);		
		return new JsonResult( result);
		
	}
	
	/**
	 * 保存添加的员工信息
	 * @param entity
	 * @return
	 */
	@RequestMapping(" doUpdateObject")
	public JsonResult doUpdateObject(SysEmployee entity,Integer id) {
		employeeService.updateObject(entity,id);	
		return new JsonResult("save ok");		
	}
	
	/**
	 * 删除员工信息
	 * @param entity
	 * @return
	 */
	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObject(Integer id) {
		employeeService.deleteObjectById(id);	
		return new JsonResult("delete ok");		
	}

}
