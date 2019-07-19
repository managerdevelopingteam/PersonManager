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
public class SysDepartment implements Serializable{
	private static final long serialVersionUID = -6045921934068894668L;
	private Integer id;
	private String name;
	private String dtName;
	private String createTime;
	private String dtBz;
}
