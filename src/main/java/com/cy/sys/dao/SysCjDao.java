package com.cy.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.sys.pojo.SysCj;

@Mapper
public interface SysCjDao {
	/*
	 * int getRowCounts(@Param("name") String name); List<SysCj>findPageObjects(
	 * 
	 * @Param("name")String name,
	 * 
	 * @Param("startIndex")Integer startIndex,
	 * 
	 * @Param("pageSize")Integer pageSize); int insertObject(SysCj entity);
	 */
	int getRowCounts(@Param("cjTitle") String cjTitle);

	// 查询表中所有数据
	List<SysCj> findPageObjects(@Param("cjTitle") String cjTitle, @Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize);

	// 向表中添加新数据
	int addCjObject(SysCj entity);

	// 根据奖惩主题模糊查询
	List<SysCj> findObject(String cjTitle);

	

	// 根据id删除记录
	int deleteObjectById(Integer id);

	// 通过id修改信息
	int updateByCjTitle(SysCj id);
}
