package com.cy.sys.service;

import java.util.List;

import com.cy.sys.pojo.Node;
import com.cy.sys.pojo.SysPay;

public interface SysPayService {

	//查询全部数据
	List<SysPay> findObjects();
	//根据年月查询表中所有数据
	List<SysPay> findObjectsByMonth(String month);
	//根据id删除记录
	int deleteObjectById(Integer id);
	//根据名称模糊查询
	List<SysPay> findObjectsByName(String name);
	//查询编号，姓名
	List<Node> findObjectsByEmployee();
}
