package com.cy.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.sys.pojo.SysCj;



@Mapper
public interface SysCjDao {
	int getRowCounts(@Param("name") String name);
	List<SysCj>findPageObjects(
			@Param("name")String name,
	@Param("startIndex")Integer startIndex,
	@Param("pageSize")Integer pageSize);
	int insertObject(SysCj entity);

}
