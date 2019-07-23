package com.cy.sys.dao;



import org.apache.ibatis.annotations.Mapper;
import com.cy.sys.pojo.SysDepartment;



@Mapper
public interface SysDepartmentDao {
	/**保存部门信息*/
	int saveDeptObject(SysDepartment entity);
	
	
	

}
