package com.cy.sys.service;


import org.springframework.stereotype.Service;

import com.cy.sys.pojo.PageObject;
import com.cy.sys.pojo.SysDepartment;


@Service
public interface SysDepartmentService {
	PageObject<SysDepartment> findPageObjects(
			String name,Integer pageCurrent);
	int saveObject(SysDepartment entity);
	
	
	
	
}
