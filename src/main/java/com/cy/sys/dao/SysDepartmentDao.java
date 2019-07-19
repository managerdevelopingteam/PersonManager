package com.cy.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.sys.pojo.SysDepartment;



@Mapper
public interface SysDepartmentDao {
	int getRowCounts(@Param("name") String name);
	List<SysDepartment>findPageObjects(
			@Param("name")String name,
	@Param("startIndex")Integer startIndex,
	@Param("pageSize")Integer pageSize);
	int insertObject(SysDepartment entity);

}
