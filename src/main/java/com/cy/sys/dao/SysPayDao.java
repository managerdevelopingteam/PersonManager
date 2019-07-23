package com.cy.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.sys.pojo.Node;
import com.cy.sys.pojo.PageObject;
import com.cy.sys.pojo.SysPay;



@Mapper
public interface SysPayDao {

	List<SysPay> findObjects();
	//查询记录总数
	int getRowCounts(@Param("payEmName") String payEmName);
	//查询全部数据
	List<SysPay> findPageObjects(@Param("payEmName") String payEmName, 
			@Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize);
	//按照年月查询
	List<SysPay> findObjectsByMonth(String month);
	//根据id删除记录
	int deleteObjectById(Integer id);
	//根据名称模糊查询
	List<SysPay> findObjectsByName(String name);
	//查询编号，姓名
	List<Node> findObjectsByEmployee();
	//添加数据
	int	addObject(SysPay entity);
}
