package com.cy.sys.pojo;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
/**
 * 	用户表封装类
 * @author ZhaoShuaiNuLi
 *
 */
@Data
@ToString
public class SysUser implements Serializable{
	private static final long serialVersionUID = -1338376800342763728L;
	private int id;
	private String username;
	private String password;
	private String salt;
}
