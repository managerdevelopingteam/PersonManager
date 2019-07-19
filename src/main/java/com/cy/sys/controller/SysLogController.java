package com.cy.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.sys.pojo.JsonResult;
import com.cy.sys.pojo.PageObject;
import com.cy.sys.pojo.SysLog;
import com.cy.sys.service.SysLogService;
@RestController
@RequestMapping("/log/")
public class SysLogController {
	@Autowired
	private SysLogService sysLogService;
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(
			String username,Integer pageCurrent) {
		PageObject<SysLog> po=
				sysLogService.findPageObjects(
						username,pageCurrent);
		return new JsonResult(po);
	}

}
