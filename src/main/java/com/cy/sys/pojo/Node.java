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
public class Node implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5880650788507854977L;
	private Integer id;
	private String emSerialNumber;//编号
	private String emName;//姓名
	private String emNumberName;//编号+姓名
}
