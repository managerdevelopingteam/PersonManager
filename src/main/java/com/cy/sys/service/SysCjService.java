package com.cy.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cy.sys.pojo.PageObject;
import com.cy.sys.pojo.SysCj;

@Service
public interface SysCjService {

	PageObject<SysCj> findPageObjects(String cjTitle, Integer pageCurrent);

	//int saveObject(SysCj entity);

	// 查询表中所有数据
	List<SysCj> findObjects();

	// 向表中添加新数据
	int saveObject(SysCj entity);

	// 根据奖惩主题模糊查询
	List<SysCj> findObject(String cjTitle);

	// 根据id删除记录
	int deleteObjectById(Integer id);

	// 更改表中数据
	int updateObject(SysCj entity);
}
