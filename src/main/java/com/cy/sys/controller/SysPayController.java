package com.cy.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.sys.pojo.JsonResult;
import com.cy.sys.pojo.Node;
import com.cy.sys.pojo.SysPay;
import com.cy.sys.service.SysPayService;

@RestController
@RequestMapping("/pay/")
public class SysPayController {

	@Autowired
	SysPayService payService;

	// 查询表中所有数据

	@RequestMapping("doFindPageObjects")
	public JsonResult doFindObjects() {
		List<SysPay> Objects = payService.findObjects();
		return new JsonResult(Objects);
	}

	//根据年月查询数据
	@RequestMapping("doFindObjecsByMouth")
	public JsonResult doFindObjecsByMouth(String month) {
		List<SysPay> findObjectsByMonth = payService.findObjectsByMonth(month);
		JsonResult jsonResult = new JsonResult(findObjectsByMonth);
		return jsonResult;
	}
	//根据id删除
	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObjectById(Integer id) {
		payService.deleteObjectById(id);
		return new JsonResult("delete ok");
		
	}
	//根据名称模糊查询
	@RequestMapping("doFindObjectByName")
	public JsonResult doFindObjectByName(String name) {
		List<SysPay> findObjectsByName = payService.findObjectsByName(name);
		return new JsonResult(findObjectsByName);
	}
	//查询编号，姓名
	@RequestMapping("doFindObjectsByEmployee")
	public JsonResult doFindObjectsByEmployee() {
		List<Node> findObjectsByEmployee = payService.findObjectsByEmployee();
		return new JsonResult(findObjectsByEmployee);
	}
}
