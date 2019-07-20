package com.cy.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.common.exception.ServiceException;
import com.cy.sys.dao.SysCjDao;
import com.cy.sys.pojo.PageObject;
import com.cy.sys.pojo.SysCj;
import com.cy.sys.service.SysCjService;


@Service
public class SysCjServiceImpl implements SysCjService{
	@Autowired
	private SysCjDao sysCjDao;
	
	/*
	 * @Override public PageObject<SysCj> findPageObjects(String name, Integer
	 * pageCurrent) { if(pageCurrent==null||pageCurrent<1) throw new
	 * IllegalArgumentException("当前页码不正确"); int
	 * rowCount=sysCjDao.getRowCounts(name); if(rowCount==0) throw new
	 * ServiceException("系统没有查到对应记录"); int pageSize=3; int
	 * startIndex=(pageCurrent-1)*pageSize; List<SysCj>
	 * records=sysCjDao.findPageObjects(name, startIndex, pageSize); //
	 * PageObject<SysLog> pageObject = new PageObject<>(); //
	 * pageObject.setPageCurrent(pageCurrent); // pageObject.setPageSize(pageSize);
	 * // pageObject.setRowCount(rowCount); // pageObject.setRecords(records); //
	 * pageObject.setPageCount((rowCount-1)/pageSize+1); return new
	 * PageObject<>(pageCurrent, pageSize, rowCount, records); }
	 * 
	 * @Override public int saveObject(SysCj entity) { //1.合法验证 if(entity==null)
	 * throw new ServiceException("保存对象不能为空");
	 * if(StringUtils.isEmpty(entity.getName())) throw new
	 * ServiceException("部门不能为空"); //2.保存数据 int rows=sysCjDao.insertObject(entity);
	 * //if(rows==1) //throw new ServiceException("save error"); //3.返回数据 return
	 * rows; }
	 */
	
	//查询表中所有数据
		@Override
		public List<SysCj> findObjects() {
			List<SysCj> findObjects = sysCjDao.findObjects();
			if(findObjects==null||findObjects.size()==0)
				throw new ServiceException("表中可能没有数据");
			return findObjects;
		}

		//向表中添加新数据
		@Override
		public int saveObject(SysCj entity) {
			//1.验证参数合法性
			if(entity==null)
				throw new IllegalArgumentException("保存对象不能为空");
			if(StringUtils.isEmpty(entity.getCjTitle()))
				throw new IllegalAccessError("奖罚题目不能为空");
			if(StringUtils.isEmpty(entity.getCjType()))
				throw new IllegalAccessError("奖罚类型不能为空");
			if(StringUtils.isEmpty(entity.getCjContent()))
				throw new IllegalAccessError("奖罚原因不能为空");
			if(StringUtils.isEmpty(entity.getCjMoney()))
				throw new IllegalAccessError("奖罚金额不能为空");
			if(StringUtils.isEmpty(entity.getCreateTime()))
				throw new IllegalAccessError("奖罚时间不能为空");
			//验证保存情况
			int insertRows = 0;
			try {
				insertRows=sysCjDao.addCjObject(entity);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServiceException("添加失败");
			}
			return insertRows;
		}
		//根据奖惩主题模糊查询
		@Override
		public List<SysCj> findObjectByCjTitle(String cjTitle) {
			//1.验证参数合法性
			if(cjTitle==null||cjTitle=="")
			throw new ServiceException("请输入查询内容");
			//执行查询操作
			List<SysCj> findObjectByCjTitle=null;
			try {
				
				findObjectByCjTitle = sysCjDao.findObjectByCjTitle(cjTitle);
			} catch (Exception e) {
				throw new ServiceException("查询失败");
			}
			//验证查询结果
			return findObjectByCjTitle;
		}
		//根据id删除记录
		@Override
		public int deleteObjectById(Integer id) {
			//1.验证参数合法性
			if(id==null||id<1)
			throw new IllegalArgumentException("不合法的参数id:"+id);
			//根据id删除数据，返回执行结果
			int deleteRows=0;
			try{
				deleteRows=sysCjDao.deleteObjectById(id);
			}catch (Exception e) {
				e.printStackTrace();
				throw new ServiceException("删除失败");
			}
			return deleteRows;
		}
		//更改表中数据
		@Override
		public int updateObject(SysCj entity) {
			//1.验证参数合法性
					if(entity==null)
						throw new IllegalArgumentException("保存对象不能为空");
					if(StringUtils.isEmpty(entity.getCjTitle()))
						throw new IllegalAccessError("奖罚题目不能为空");
					if(StringUtils.isEmpty(entity.getCjType()))
						throw new IllegalAccessError("奖罚类型不能为空");
					if(StringUtils.isEmpty(entity.getCjContent()))
						throw new IllegalAccessError("奖罚原因不能为空");
					if(StringUtils.isEmpty(entity.getCjMoney()))
						throw new IllegalAccessError("奖罚金额不能为空");
					if(StringUtils.isEmpty(entity.getCreateTime()))
						throw new IllegalAccessError("奖罚时间不能为空");
					//验证保存情况
					int insertRows = 0;
					try {
						insertRows=sysCjDao.addCjObject(entity);
					} catch (Exception e) {
						e.printStackTrace();
						throw new ServiceException("更改失败");
					}
					return insertRows;
				}
}
