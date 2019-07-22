package com.cy.sys.dao;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cy.sys.pojo.SysEmployee;


@Mapper
public interface SysEmployeeDao {
	/**
	 * 添加员工信息
	 * @param entity
	 * @return
	 */	
	int insertEmployee(SysEmployee entity);
	
	/*** 通过id查询单条信息 */
	List<SysEmployee> findObjectById(int id);
	
	/*** 更新员工信息 */
	int updateObject(SysEmployee entity);
	
	/**根据id删除员工信息*/
	int deleteObjectById(Integer id);

	
}
