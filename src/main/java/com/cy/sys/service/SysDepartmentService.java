package com.cy.sys.service;


import org.springframework.stereotype.Service;

import com.cy.sys.pojo.PageObject;
import com.cy.sys.pojo.SysDepartment;


@Service
public interface SysDepartmentService {
	/**保存部门信息*/
	int saveDeptObject(SysDepartment entity);
	
	
	
	
}
