package com.cy.sys.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.common.exception.ServiceException;
import com.cy.sys.dao.SysCjDao;
import com.cy.sys.pojo.PageObject;
import com.cy.sys.pojo.SysCj;
import com.cy.sys.service.SysCjService;

@Service
public class SysCjServiceImpl implements SysCjService {
	@Autowired
	private SysCjDao sysCjDao;

	// 根据奖惩主题模糊查询全部数据
	@Override
	public PageObject<SysCj> findPageObjects(String cjTitle, Integer pageCurrent) {
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码不正确");
		int rowCount = sysCjDao.getRowCounts(cjTitle);
		if (rowCount == 0)
			throw new ServiceException("系统没有查到对应记录");
		int pageSize = 3;
		int startIndex = (pageCurrent - 1) * pageSize;
		List<SysCj> records = sysCjDao.findPageObjects(cjTitle, startIndex, pageSize);
		PageObject<SysCj> pageObject = new PageObject<>();
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageCount((rowCount - 1) / pageSize + 1);
		return pageObject;
	}

	//添加数据
	@Override
	public int saveObject(SysCj entity) {
		// 1.验证参数合法性
		if (entity == null)
			throw new ServiceException ("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getCjTitle()))
			throw new ServiceException("奖罚题目不能为空");
		if (StringUtils.isEmpty(entity.getCjType()))
			throw new ServiceException("奖罚类型不能为空");
		if (StringUtils.isEmpty(entity.getCjContent()))
			throw new ServiceException("奖罚内容不能为空");
		if (StringUtils.isEmpty(entity.getCjMoney()))
			throw new ServiceException("奖罚金额不能为空");
		if (StringUtils.isEmpty(entity.getCreateTime()))
			throw new ServiceException("奖罚时间不能为空");
		// 验证保存情况
		int insertRows = 0;
		try {
			insertRows = sysCjDao.insertObject(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("添加失败");
		}
		return insertRows;
	}

	//修改数据
	@Override
	public int updateObject(SysCj entity) {
		//1.验证参数合法性
		if (entity == null)
			throw new ServiceException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getCjTitle()))
			throw new ServiceException("奖罚题目不能为空");
		if (StringUtils.isEmpty(entity.getCjType()))
			throw new ServiceException("奖罚类型不能为空");
		if (StringUtils.isEmpty(entity.getCjContent()))
			throw new ServiceException("奖罚内容不能为空");
		if (StringUtils.isEmpty(entity.getCjMoney()))
			throw new ServiceException("奖罚金额不能为空");
		if (StringUtils.isEmpty(entity.getCreateTime()))
			throw new ServiceException("奖罚时间不能为空");
		//验证保存情况
		int insertRows = 0;
		try {
			insertRows=sysCjDao.updateObject(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("更改失败");
		}
		return insertRows;
	}

	//根据id删除数据
	@Override
	public int deleteObject(Integer id) {
		// 1.验证参数合法性
		if (id == null || id < 1)
			throw new IllegalArgumentException("不合法的参数id:" + id);
		// 根据id删除数据，返回执行结果
		int deleteRows = 0;
		try {
			deleteRows = sysCjDao.deleteObject(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("删除失败");
		}
		return deleteRows;
	}

	//根据id查询单条数据
	@Override
	public List<SysCj> findObjectById(Integer id) {
		return sysCjDao.findObjectById(id);
	}

}
