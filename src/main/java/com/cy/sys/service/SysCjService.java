package com.cy.sys.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.cy.sys.pojo.PageObject;
import com.cy.sys.pojo.SysCj;


@Service
public interface SysCjService {
	//根据奖惩主题模糊查询全部数据
	PageObject<SysCj> findPageObjects(
			@Param("cjTitle")String cjTitle,
			@Param("pageCurrent")Integer pageCurrent);
	//添加数据
	int saveObject(SysCj entity);
	//修改数据
	int updateObject(SysCj entity);
	//根据id删除数据
	int deleteObject(Integer id);
	//根据id查询单条数据
	List<SysCj> findObjectById(Integer id);
	
}
