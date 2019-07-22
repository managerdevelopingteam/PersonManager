package com.cy.sys.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cy.common.exception.ServiceException;
import com.cy.sys.dao.SysDepartmentDao;
import com.cy.sys.pojo.SysDepartment;
import com.cy.sys.service.SysDepartmentService;


@Service
public class SysDepartmentServiceImpl implements SysDepartmentService{
	@Autowired
	private SysDepartmentDao sysDepartmentDao;

	/**添加部门信息*/
	@Override
	public int saveDeptObject(SysDepartment entity) {
		if(entity==null)
			throw new ServiceException("保存部门信息不能为空");
		if(entity.getDtName()==null)
			throw new ServiceException("部门名称不能为空");
		int rows = sysDepartmentDao.saveDeptObject(entity);
		return rows;
	}


	
	

	
}
