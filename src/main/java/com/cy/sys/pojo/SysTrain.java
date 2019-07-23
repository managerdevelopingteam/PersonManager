package com.cy.sys.pojo;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SysTrain implements Serializable{
	private static final long serialVersionUID = -4720907958038965430L;
	private Integer id;
	private String tnMan;
	private String tnTitle;
	private String tnContent;
	private String createTime;
	private String tnAddress;
	private String tnJoin;
	private String tnBz;
}
