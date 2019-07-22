package com.cy.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.common.exception.ServiceException;
import com.cy.sys.dao.SysDepartmentDao;
import com.cy.sys.pojo.PageObject;
import com.cy.sys.pojo.SysDepartment;
import com.cy.sys.service.SysDepartmentService;


@Service
public class SysDepartmentServiceImpl implements SysDepartmentService{
	@Autowired
	private SysDepartmentDao sysDepartmentDao;
	
	@Override
	public PageObject<SysDepartment> findPageObjects(String name, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("当前页码不正确");
		int rowCount=sysDepartmentDao.getRowCounts(name);
		if(rowCount==0)
			throw new ServiceException("系统没有查到对应记录");
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysDepartment> records=sysDepartmentDao.findPageObjects(name, startIndex, pageSize);
//		PageObject<SysLog> pageObject = new PageObject<>();
//		pageObject.setPageCurrent(pageCurrent);
//		pageObject.setPageSize(pageSize);
//		pageObject.setRowCount(rowCount);
//		pageObject.setRecords(records);
//		pageObject.setPageCount((rowCount-1)/pageSize+1);
		return new PageObject<>(pageCurrent, pageSize, rowCount, records);
	}
	@Override
	public int saveObject(SysDepartment entity) {
		//1.合法验证
		if(entity==null)
		throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
		throw new ServiceException("部门不能为空");
		//2.保存数据
		int rows=sysDepartmentDao.insertObject(entity);
		//if(rows==1)
		//throw new ServiceException("save error");
		//3.返回数据
		return rows;
	}
	
}
