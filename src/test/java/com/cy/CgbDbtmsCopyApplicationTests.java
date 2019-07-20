package com.cy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.sys.pojo.JsonResult;
import com.cy.sys.pojo.SysTrain;
import com.cy.sys.service.impl.SysTrainServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CgbDbtmsCopyApplicationTests {
	@Autowired
	private SysTrainServiceImpl TrainDao;
	@Test
	public void contextLoads() {
	}
	/**
	 * test查询所有培训数据
	 */
	@Test
	public void trainFindObjects() {
		List<SysTrain> list = TrainDao.findObjects();
		for (SysTrain train : list) {
			System.out.println(train.toString());
		}
	}
	/**
	 * test插入培训数据
	 */
	@Test
	public void addTrainObject() {
		SysTrain train = new SysTrain();
		//train.setId(2);
		train.setTnMan("赵帅");
		train.setTnJoin("张三,李四");
		train.setTnTime("2019-7-18");
		train.setTnBz("指导大家峰会前的业务分配");
		train.setTnContent("让大家知道自己做什么工作");
		train.setTnTitle("项目峰会指导");
		train.setTnAddress("实训三教室");
		JsonResult result = new JsonResult();
		result.setData(train);
		int rows = TrainDao.addTrainObject(train);
		System.out.println(rows+"行");
	}
	/**
	 * test根据id查询培训数据
	 */
	@Test
	public void findTrainObjectById() {
		Integer id = 3;
		SysTrain train = TrainDao.findTrainObjectById(id);
		System.out.println(train.toString());
	}
	/**
	 * test根据id删除培训信息
	 */
	@Test
	public void deleteTrainObjectById() {
		Integer id = 3;
		int rows = TrainDao.deleteTrainObjectById(id);
		System.out.println(rows);
	}

}
