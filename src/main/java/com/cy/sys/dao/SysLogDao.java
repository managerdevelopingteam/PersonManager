package com.cy.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.sys.pojo.SysLog;
@Mapper
public interface SysLogDao {
	int getRowCounts(@Param("name") String name);
	List<SysLog>findPageObjects(
			@Param("name")String name,
	@Param("startIndex")Integer startIndex,
	@Param("pageSize")Integer pageSize);
}
