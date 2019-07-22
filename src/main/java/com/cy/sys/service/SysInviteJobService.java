package com.cy.sys.service;

import com.cy.sys.pojo.SysInviteJob;

public interface SysInviteJobService {
	
	/**
	 * 保存插入的应聘者信息
	 * @param entity
	 * @return
	 */
	int saveInviteJobMes(SysInviteJob entity);
}
