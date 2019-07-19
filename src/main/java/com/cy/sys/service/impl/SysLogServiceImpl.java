package com.cy.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.exception.ServiceException;
import com.cy.sys.dao.SysLogDao;
import com.cy.sys.pojo.PageObject;
import com.cy.sys.pojo.SysLog;
import com.cy.sys.service.SysLogService;
@Service
public class SysLogServiceImpl implements SysLogService{
	@Autowired
	private SysLogDao sysLogDao;
	
	@Override
	public PageObject<SysLog> findPageObjects(String name, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("当前页码不正确");
		int rowCount=sysLogDao.getRowCounts(name);
		if(rowCount==0)
			throw new ServiceException("系统没有查到对应记录");
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysLog> records=sysLogDao.findPageObjects(name, startIndex, pageSize);
//		PageObject<SysLog> pageObject = new PageObject<>();
//		pageObject.setPageCurrent(pageCurrent);
//		pageObject.setPageSize(pageSize);
//		pageObject.setRowCount(rowCount);
//		pageObject.setRecords(records);
//		pageObject.setPageCount((rowCount-1)/pageSize+1);
		
		
		return new PageObject<>(pageCurrent, pageSize, rowCount, records);
	}

}
