package com.cy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.sys.pojo.JsonResult;
import com.cy.sys.pojo.Node;
import com.cy.sys.pojo.SysCj;
import com.cy.sys.pojo.SysDepartment;
import com.cy.sys.pojo.SysEmployee;
import com.cy.sys.pojo.SysInviteJob;
import com.cy.sys.pojo.SysPay;
import com.cy.sys.pojo.SysTrain;
import com.cy.sys.service.SysCjService;
import com.cy.sys.service.SysDepartmentService;
import com.cy.sys.service.SysEmployeeService;
import com.cy.sys.service.SysInviteJobService;
import com.cy.sys.service.SysPayService;
import com.cy.sys.service.impl.SysTrainServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CgbDbtmsCopyApplicationTests {
	@Autowired
	private SysTrainServiceImpl TrainDao;
	@Autowired
	private SysCjService cj;
	@Autowired
	private SysPayService pay;

	@Autowired 
	private SysInviteJobService sysInviteJobService;

	@Autowired
	private SysEmployeeService sysEmployeeService;
	
	@Autowired
	SysDepartmentService sysDepartmentService;


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
			// train.setId(2);
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
			System.out.println(rows + "行");
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
	
		@Test
		public void findObjects() {
			List<SysCj> findObjects = cj.findObjects();
			for (SysCj sysCj : findObjects) {
				System.out.println(sysCj.toString());
			}
		}
	
		@Test
		public void insertCjObject() {
			SysCj entity = new SysCj();
			entity.setCjTitle("早退");
			entity.setCjType("1");
			entity.setCjMoney("-200");
			entity.setCreateTime("2079-7-18");
			entity.setCjContent("罚他");
			int rows = cj.saveObject(entity);
			System.out.println(rows);
		}
	
		@Test
		public void fingObjectByCjTitle() {
			List<SysCj> findObjectByCjTitle = cj.findObject("羽毛球");
			for (SysCj sysCj : findObjectByCjTitle) {
				System.out.println(sysCj.toString());
			}
		}
	
		@Test
		public void deleteCjById() {
			int rows = cj.deleteObjectById(100);
			System.out.println(rows);
		}
	
		@Test
		public void findPayObjects() {
			List<SysPay> findObjects = pay.findObjects();
			JsonResult jsonResult = new JsonResult(findObjects);
			System.out.println(jsonResult.toString());
		}
	
		@Test
		public void findPayObjectsByMonth() {
			List<SysPay> findObjectsByMonth = pay.findObjectsByMonth("2016-01");
			JsonResult jsonResult = new JsonResult(findObjectsByMonth);
			System.out.println(jsonResult.toString());
		}
	
		@Test
		public void deletePayObjectById() {
			int deleteObjectById = pay.deleteObjectById(5);
			System.out.println(deleteObjectById);
		}
	
		@Test
		public void findPayObjectByName() {
			List<SysPay> findObjectsByName = pay.findObjectsByName("*");
			JsonResult jsonResult = new JsonResult(findObjectsByName);
			System.out.println(jsonResult.toString());
		}
	
		@Test
		public void findObjectsByEmployee() {
			List<Node> findObjectsByEmployee = pay.findObjectsByEmployee();
			for (Node node : findObjectsByEmployee) {
				System.out.println(node.toString());
			}
		}
	
	
//	/**
//	 * 添加应聘信息
//	 * 
//	 * @return
//	 */
//
//	@Test public void test() { 
//		SysInviteJob entity=new SysInviteJob();
//		entity.setName("李某N"); 
//		entity.setSex("女");
//		entity.setAge(18);
//		entity.setBorn("1999-5-3");
//		entity.setJob("Java运维");
//		entity.setSpecialty("软件工程"); 
//		int rows =sysInviteJobService.saveInviteJobMes(entity);
//		System.out.println("影响行数"+rows);
//	}
//	
//
//		/**
//		 * 添加员工信息
//		 * 
//		 * @return
//		 */
//		@Test 
//		public void test2() { 
//			SysEmployee entity=new SysEmployee();
//			entity.setEmSerialNumber(30); 
//			entity.setEmName("刘某N");
//			entity.setEmSex("女");		
//			int rows =sysEmployeeService.saveObject(entity); 
//			System.out.println("影响行数"+rows);
//	
//		}
//		
//		/**
//		 * 根据id查询员工信息
//		 */
//		
//		@Test
//		public void doFindObjectById(){
//			int id=3;
//			List<SysEmployee> result=sysEmployeeService.findObjectById(id);		
//			System.out.println(new JsonResult( result).toString()); 
//			
//		}
//		
//		/**
//		 * 根据id提交员工信息
//		 */
//		@Test
//		public void doUpdateObject(){
//			int id=3;//传入一个id值，假设修改时带过来的id为3
//			SysEmployee entity=new SysEmployee();
//	        entity.setId(id);
//			entity.setEmSerialNumber(30); 
//			entity.setEmName("刘某某2");
//			entity.setEmSex("女");
//			entity.setEmAge(18);
//			entity.setEmIDCard("66666666******");
//			entity.setEmBorn("2019-7-22");
//			entity.setEmNation("汉");
//			entity.setEmMarriage("未婚");
//			entity.setEmVisage("无");
//			entity.setEmAncestralHome("河北省");
//			entity.setEmTel("136666****");
//			entity.setEmAddress("市街道");
//			entity.setEmAfterSchool("工业大学");
//			entity.setEmSpeciality("软件工程");
//			entity.setEmCulture("学士");
//			entity.setEmStartime("2019-7-22");
//			entity.setEmDepartmentId("9");
//			entity.setEmTypeWork("软件工程师");
//			entity.setEmCreatime("2019-7-22");
//			entity.setEmBz("表现良好");		
//			System.out.println("entity的内容"+entity.toString());
//			System.out.println("id值为"+id);
//			int rows =sysEmployeeService.updateObject(entity, id);
//			System.out.println("影响行数"+rows);		
//		}
//		/**
//		 * 根据id提交员工信息
//		 */
//		@Test
//		public void doDeleteObject(){
//			Integer id=14;
//			int rows = sysEmployeeService.deleteObjectById(id);
//			System.out.println("删除行数为"+rows);
//		}
//		/**添加部门信息*/
//		@Test
//		public void doFindPageObjects() {
//			SysDepartment entity=new SysDepartment();
//			entity.setCreateTime("2019-7-22");
//			entity.setId(17);
//			entity.setDtName("李二牛");
//			entity.setDtBz("无");
//			int rows=sysDepartmentService.saveDeptObject(entity);
//			System.out.println("添加影响行数"+rows);
//			
//		}

	}
