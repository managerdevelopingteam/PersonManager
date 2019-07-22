package com.cy.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.common.exception.ServiceException;
import com.cy.sys.dao.SysInviteJobDao;
import com.cy.sys.pojo.SysInviteJob;
import com.cy.sys.service.SysInviteJobService;



@Service
public class SysInviteJobServiceImp implements SysInviteJobService {
	@Autowired
	SysInviteJobDao sysInviteJobDao;
	/**
	 * 对应聘人信息进行保存
	 * @throws IllegalAccessException 
	 */
	@Override
	public int saveInviteJobMes(SysInviteJob entity){
		if(entity==null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("应聘人员姓名不能为空");
		//将对象写入到数据库
		int rows=0;
		try {
			rows=sysInviteJobDao.insertApplicantMes(entity);			
		}catch(Throwable e){
			e.printStackTrace();
			throw new ServiceException("save error");
		}				
		return rows;
	}





}
