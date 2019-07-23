package com.cy.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.sys.pojo.SysTrain;

@Mapper
public interface SysTrainDao {
	/**
	 * 查询所有培训记录
	 * @return 将查询的结果封装到list<SysTrain>中
	 */
	List<SysTrain> findPageObjects( @Param("tnMan")String  tnMan,@Param("startIndex")Integer startIndex,@Param("pageSize")Integer pageSize);
	
	int getRowCount(@Param("tnMan") String tnMan);
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
	 * @return int 删除的行数
	 */
	public int deleteTrainObjectById(Integer id);
}
