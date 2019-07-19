package com.cy.sys.pojo;


import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SysCj implements Serializable{
	
	private static final long serialVersionUID = 4974235283704833044L;
	private int id;
	private String name;
	private String cjTitle;
	private Integer cjType=1;
	private String cjContent;
	private String cjMoney;
	private String createTime;
}
