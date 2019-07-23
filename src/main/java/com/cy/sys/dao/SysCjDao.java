package com.cy.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.sys.pojo.SysCj;



@Mapper
public interface SysCjDao {
	int getRowCounts(@Param("cjTitle")String cjTitle);
	//根据奖惩主题模糊查询全部数据
	List<SysCj>findPageObjects(
			@Param("cjTitle")String cjTitle,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	//添加数据
	int insertObject(SysCj entity);
	//根据id删除数据
	@Delete("delete from sys_cj where id=#{id}")
	int deleteObject(Integer id);
	//修改数据
	int updateObject(SysCj entity);
	@Select("select * from sys_cj where id=#{id}")
	//根据id查询单条数据
	List<SysCj> findObjectById(Integer id);
}