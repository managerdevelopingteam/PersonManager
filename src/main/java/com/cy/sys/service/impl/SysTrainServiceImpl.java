package com.cy.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.exception.ServiceException;
import com.cy.sys.dao.SysTrainDao;
import com.cy.sys.pojo.PageObject;
import com.cy.sys.pojo.SysLog;
import com.cy.sys.pojo.SysTrain;
import com.cy.sys.service.SysTrainService;
@Service
public class SysTrainServiceImpl implements SysTrainService{
	@Autowired
	private SysTrainDao dao;

	/**
	 * 查询所有培训记录业务处理
	 * @return
	 */
	@Override
	public PageObject<SysTrain> findPageObjects(String tnMan, Integer pageCurrent) {
		//1.验证参数合法性
		//1.1验证pageCurrent的合法性，
		//不合法抛出IllegalArgumentException异常
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("当前页码不正确");
		//2.基于条件查询总记录数
		//2.1) 执行查询
		int rowCount=dao.getRowCount(tnMan);
		//2.2) 验证查询结果，假如结果为0不再执行如下操作
		if(rowCount==0)
			throw new ServiceException("系统没有查到对应记录");
		//3.基于条件查询当前页记录(pageSize定义为2)
		//3.1)定义pageSize
		int pageSize=3;
		//3.2)计算startIndex
		int startIndex=(pageCurrent-1)*pageSize;
		//3.3)执行当前数据的查询操作
		List<SysTrain> records=dao.findPageObjects(tnMan, startIndex, pageSize);
		//4.对分页信息以及当前页记录进行封装
		//4.1)构建PageObject对象
		PageObject<SysTrain> pageObject=new PageObject<>();
		//4.2)封装数据
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageCount((rowCount-1)/pageSize+1);
		//5.返回封装结果。
		return pageObject;
	}
	/**
	 * 添加一条培训记录
	 * @param train 封装添加的培训信息
	 * @return 改变的行数
	 */
	@Override
	public int addTrainObject(SysTrain train) {
		//判断非空
		if(train.getTnMan()==null||train.getTnMan()=="")
			throw new ServiceException("培训人不能为空");
		if(train.getTnJoin()==null||train.getTnJoin()=="")
			throw new ServiceException("参加人员不能为空");
		if(train.getTnTitle()==null||train.getTnTitle()=="")
			throw new ServiceException("培训主题不能为空");
		if(train.getTnAddress()==null||train.getTnAddress()=="")
			throw new ServiceException("培训地点不能为空");
		if(train.getCreateTime()==null||train.getCreateTime()=="")
			throw new ServiceException("培训时间不能为空");
		if(train.getTnContent()==null||train.getTnContent()=="")
			throw new ServiceException("培训宗旨不能为空");
		int rows = dao.addTrainObject(train);
		if (rows == 0)
			throw new ServiceException("插入失败!");
		return rows;
	}
	/**
	 * 根据id查询培训信息
	 * @param id
	 * @return Train
	 */
	@Override
	public SysTrain findTrainObjectById(Integer id) {
		SysTrain train = dao.findTrainObjectById(id);
		if(train==null)
			throw new ServiceException("查不到这条培训数据");
		return train;
	}
	/**
	 * 根据id删除培训信息
	 * @param id
	 * @return int 删除的行数
	 */
	@Override
	public int deleteTrainObjectById(Integer id) {
		if(id==null||id==0)
			throw new ServiceException("请选择正确的信息id");
		int rows = dao.deleteTrainObjectById(id);
		if(rows==0)
			throw new ServiceException("删除失败");
		return rows;
	}

}
