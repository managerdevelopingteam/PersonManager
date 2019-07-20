package com.cy.sys.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
public class JsonResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9204782714303432254L;
	private int state=1;
	private String message="ok";
	private Object data;
	public JsonResult() {}
	public JsonResult(String message) {
		this.message=message;
	}
	public JsonResult(Object data) {
		this.data=data;
	}
	public JsonResult(Throwable e) {
		this.message=e.getMessage();
		this.state=0;
	}
}
