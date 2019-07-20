package com.cy.sys.service;

import java.util.List;

import com.cy.sys.pojo.SysTrain;

public interface SysTrainService {
	/**
	 * 查询所有培训记录
	 * @return 返回list<Train>封装查询到的数据
	 */
	public List<SysTrain> findObjects();
	/**
	 * 添加一条培训记录
	 * @param train 封装添加的培训信息
	 * @return 改变的行数
	 */
	public int addTrainObject(SysTrain train);
	/**
	 * 根据id查询培训信息
	 * @param id
	 * @return Train
	 */
	public SysTrain findTrainObjectById(Integer id);
	/**
	 * 根据id删除培训信息
	 * @param id
	 * @return int 行数
	 */
	public int deleteTrainObjectById(Integer id);
}
