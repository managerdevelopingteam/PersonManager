package com.cy.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.exception.ServiceException;
import com.cy.sys.dao.SysPayDao;
import com.cy.sys.pojo.Node;
import com.cy.sys.pojo.PageObject;

import com.cy.sys.pojo.SysPay;
import com.cy.sys.service.SysPayService;

import io.micrometer.core.instrument.util.StringUtils;

@Service
public class SysPayServiceImpl implements SysPayService {

	@Autowired
	SysPayDao PayDao;

	// 根据年月查询数据
	@Override
	public List<SysPay> findObjectsByMonth(String month) {
		// 验证参数合法性
		if (month == null || month.equals(""))
			throw new ServiceException("请输入要查询的年月，例如:2000-01");
		// 查询
		List<SysPay> findObjectsByMonth = PayDao.findObjectsByMonth(month);
		// 验证数据
		if (findObjectsByMonth == null || findObjectsByMonth.size() == 0)
			throw new ServiceException("未查到任何数据");
		return findObjectsByMonth;
	}

	// 根据id删除记录
	@Override
	public int deleteObjectById(Integer id) {
		// 验证参数合法性
		if (id == null || id < 1)
			throw new IllegalArgumentException("不合法的参数id:" + id);
		// 执行删除操作
		int deleteRows = 0;
		try {
			deleteRows = PayDao.deleteObjectById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("删除失败");
		}
		return deleteRows;
	}

	// 根据名称模糊查询
	@Override
	public List<SysPay> findObjectsByName(String name) {
		// 验证查询条件
		if (name == null || name == "")
			throw new ServiceException("请输入名称后再进行查询");
		// 执行查询结果
		List<SysPay> findObjectsByName = PayDao.findObjectsByName(name);
		// 验证查询结果
		if (findObjectsByName == null || findObjectsByName.size() == 0)
			throw new ServiceException("未查到任何数据");
		return findObjectsByName;
	}

	// 查询编号，姓名
	@Override
	public List<Node> findObjectsByEmployee() {
		// 执行查询
		List<Node> findObjectsByEmployee = PayDao.findObjectsByEmployee();
		// 验证查询结果
		if (findObjectsByEmployee == null || findObjectsByEmployee.size() == 0)
			throw new ServiceException("未查到任何数据");
		return findObjectsByEmployee;
	}

	// 查询全部数据
	@Override
	public PageObject<SysPay> findPageObjects(String payEmName, Integer pageCurrent) {
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码不正确");
		int rowCount = PayDao.getRowCounts(payEmName);
		if (rowCount == 0)
			throw new ServiceException("系统没有查到对应记录");
		int pageSize = 3;
		int startIndex = (pageCurrent - 1) * pageSize;
		List<SysPay> records = PayDao.findPageObjects(payEmName, startIndex, pageSize); //

		PageObject<SysPay> pageObject = new PageObject<>(); //
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records); //
		pageObject.setPageCount((rowCount - 1) / pageSize + 1);
		return pageObject;

	}

	@Override
	public List<SysPay> findObjects() {
		List<SysPay> findObjects = PayDao.findObjects();
		return findObjects;
	}

	// 添加数据
	@Override
	public int saveObject(SysPay entity) {
		// 1.验证参数合法性
		if (entity == null)
			throw new IllegalArgumentException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getPayEmNumber()))
			throw new IllegalArgumentException("员工编号不能为空");
		if (StringUtils.isEmpty(entity.getPayMonth()))
			throw new IllegalArgumentException("发放时间不能为空");
		if (StringUtils.isEmpty(entity.getPayBaseMoney()))
			throw new IllegalArgumentException("基本工资不能为空");
		if (StringUtils.isEmpty(entity.getPayOverTime()))
			throw new IllegalArgumentException("加班费用不能为空");
		if (StringUtils.isEmpty(entity.getPayAge()))
			throw new IllegalArgumentException("工龄费用不能为空");
		if (StringUtils.isEmpty(entity.getPayCheck()))
			throw new IllegalArgumentException("全勤奖不能为空");
		if (StringUtils.isEmpty(entity.getPayAbsent()))
			throw new IllegalArgumentException("矿工费不能为空");
		if (StringUtils.isEmpty(entity.getPaySafety()))
			throw new IllegalArgumentException("保险费不能为空");
		if (StringUtils.isEmpty(entity.getGetMoney()))
			throw new IllegalArgumentException("实发工资不能为空");
		//执行添加 
		int addObject = 0;
		try {
			addObject=PayDao.addObject(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("添加失败");
		}
		return addObject;
	}

}
