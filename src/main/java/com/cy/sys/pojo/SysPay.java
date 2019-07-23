package com.cy.sys.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SysPay implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3901704342693025035L;
	private Integer id;
	private String payEmNumber;//员工编号
	private String payEmName;//员工姓名
	private String payMonth;//当前月份
	private String payBaseMoney;//基本工资
	private String payOverTime;//加班时长
	private String payAge;//工龄
	private String payCheck;//考勤费
	private String payAbsent;//矿工费
	private String paySafety;//保险费
	private String getMoney;//实发工资
}
