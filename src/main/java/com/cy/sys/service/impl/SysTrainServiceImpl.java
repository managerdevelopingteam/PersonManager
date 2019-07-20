package com.cy.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.exception.ServiceException;
import com.cy.sys.dao.SysTrainDao;
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
	public List<SysTrain> findObjects() {
		List<SysTrain> list = dao.findObjects();
		//判断查询的培训信息是否为空,或者为0
		if(list.size()==0||list.isEmpty())
			throw new ServiceException("暂时还没有培训记录");
		return list;
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
		if(train.getTnTime()==null||train.getTnTime()=="")
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
