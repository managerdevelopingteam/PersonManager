package com.cy.sys.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.exception.ServiceException;
import com.cy.sys.dao.SysEmployeeDao;
import com.cy.sys.pojo.SysEmployee;
import com.cy.sys.service.SysEmployeeService;


@Service
public class SysEmployeeServiceImp implements SysEmployeeService {

	@Autowired
	SysEmployeeDao sysEmployeeDao;


	/**
	 * 添加员工信息
	 * @param entity
	 * @return
	 */	
	@Override
	public int saveObject(SysEmployee entity) {
		if(entity==null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(entity.getEmName()==null)
			throw new IllegalArgumentException("员工姓名不能为空");
		int rows;
		try {
			rows=sysEmployeeDao.insertEmployee(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("save erro");			
		}
		return rows;
	}

	/*** 通过id查询单条信息 */
	@Override
	public List<SysEmployee> findObjectById(int id) {
		if(id==0 || id<0)
			throw new IllegalArgumentException("请输入正确的查询信息");			
		List<SysEmployee> rows;
		try {
			rows=sysEmployeeDao.findObjectById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("save erro");			
		}			
		return rows;		
	}
	/**更新员工信息*/
	@Override
	public int updateObject(SysEmployee entity,Integer id) {
		if(entity==null)
			throw new IllegalArgumentException("更新对象不能为空");
		if(id==null)
			throw new IllegalArgumentException("id值不能为空");
		if(entity.getEmName()==null)
			throw new IllegalArgumentException("员工姓名不能为空");	
		int rows=sysEmployeeDao.updateObject(entity);			
		return rows;
	}

	/**根据id删除员工信息*/
	@Override    //根据ID删除
	public int deleteObjectById(Integer id) {
		if(id==0 || id<0)
			throw new IllegalArgumentException("请输入正确的id信息");
		int rows = sysEmployeeDao.deleteObjectById(id);
		return rows;
	}



}
