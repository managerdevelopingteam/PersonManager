package com.cy.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cy.sys.pojo.SysInviteJob;


@Mapper
public interface SysInviteJobDao {
	/**
	 * 添加应聘人信息
	 * @param entity
	 * @return
	 */
	int insertApplicantMes(SysInviteJob entity);
}
