package com.cy.sys.service;


import org.springframework.stereotype.Service;

import com.cy.sys.pojo.PageObject;
import com.cy.sys.pojo.SysCj;


@Service
public interface SysCjService {
	PageObject<SysCj> findPageObjects(
			String name,Integer pageCurrent);
	int saveObject(SysCj entity);
	
	
	
	
}
