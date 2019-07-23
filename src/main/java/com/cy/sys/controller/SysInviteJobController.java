package com.cy.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.sys.pojo.JsonResult;
import com.cy.sys.pojo.SysInviteJob;
import com.cy.sys.service.SysInviteJobService;






@RestController
@RequestMapping("/log/")
public class SysInviteJobController {
	
	@Autowired
	SysInviteJobService sysInviteJobService;
	
	/**
	 * 保存应聘人信息
	 * @param entity
	 * @return
	 */
	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(SysInviteJob entity) {
		sysInviteJobService.saveInviteJobMes(entity);
		return new JsonResult("save ok");	
	}


}
