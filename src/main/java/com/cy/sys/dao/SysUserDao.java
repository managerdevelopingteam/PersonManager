package com.cy.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cy.sys.pojo.SysUser;

@Mapper
public interface SysUserDao {
	/**
	 * 	根据用户名查询
	 * @param username
	 * @return
	 */
	SysUser findUserByUserName(String username);
}
