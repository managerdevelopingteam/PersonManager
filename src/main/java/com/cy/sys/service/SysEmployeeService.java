package com.cy.sys.service;

import java.util.List;

import com.cy.sys.pojo.SysEmployee;

public interface SysEmployeeService {
	
	/**添加员工信息*/
	int saveObject(SysEmployee entity);
	
	/*** 通过id查询单条信息 */
	List<SysEmployee> findObjectById(int id);
	
	/*** 更新员工信息 */
	int updateObject(SysEmployee entity,Integer id);
	
	/**根据id删除员工信息*/
	int deleteObjectById(Integer id);
	
	
}
