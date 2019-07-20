package com.cy.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cy.sys.pojo.Node;
import com.cy.sys.pojo.SysPay;



@Mapper
public interface SysPayDao {

	//查询全部数据
	List<SysPay> findObjects();
	//按照年月查询
	List<SysPay> findObjectsByMonth(String month);
	//根据id删除记录
	int deleteObjectById(Integer id);
	//根据名称模糊查询
	List<SysPay> findObjectsByName(String name);
	//查询编号，姓名
	List<Node> findObjectsByEmployee();
}
