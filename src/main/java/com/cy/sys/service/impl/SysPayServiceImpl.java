package com.cy.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.exception.ServiceException;
import com.cy.sys.dao.SysPayDao;
import com.cy.sys.pojo.Node;
import com.cy.sys.pojo.SysPay;
import com.cy.sys.service.SysPayService;

@Service
public class SysPayServiceImpl implements SysPayService{

	@Autowired SysPayDao PayDao;
	//查询全部数据
	@Override
	public List<SysPay> findObjects() {
		//获取所有数据
		List<SysPay> findObjects = PayDao.findObjects();
		//验证数据
		if(findObjects==null||findObjects.size()==0)
			throw new ServiceException("null");
		return findObjects;
	}
	//根据年月查询数据
	@Override
	public List<SysPay> findObjectsByMonth(String month) {
		//验证参数合法性
		if(month==null||month.equals(""))
			throw new ServiceException("请输入要查询的年月，例如:2000-01");
		//查询
		List<SysPay> findObjectsByMonth = PayDao.findObjectsByMonth(month);
		//验证数据
				if(findObjectsByMonth==null||findObjectsByMonth.size()==0)
					throw new ServiceException("未查到任何数据");
				return findObjectsByMonth;
	}
	//根据id删除记录
	@Override
	public int deleteObjectById(Integer id) {
		//验证参数合法性
		if(id==null||id<1)
			throw new IllegalArgumentException("不合法的参数id:"+id);
		//执行删除操作
		int deleteRows=0;
		try {
			deleteRows = PayDao.deleteObjectById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("删除失败");
		}
		return deleteRows;
	}
	//根据名称模糊查询
	@Override
	public List<SysPay> findObjectsByName(String name) {
		//验证查询条件
		if(name==null||name=="")
			throw new ServiceException("请输入名称后再进行查询");
		//执行查询结果
		List<SysPay> findObjectsByName = PayDao.findObjectsByName(name);
		//验证查询结果
		if(findObjectsByName==null||findObjectsByName.size()==0)
			throw new ServiceException("未查到任何数据");
		return findObjectsByName;
	}
	//查询编号，姓名
	@Override
	public List<Node> findObjectsByEmployee() {
		//执行查询
		List<Node> findObjectsByEmployee = PayDao.findObjectsByEmployee();
		//验证查询结果
		if(findObjectsByEmployee==null||findObjectsByEmployee.size()==0)
		throw new ServiceException("未查到任何数据");
		return findObjectsByEmployee;
	}

}
