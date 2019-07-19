package com.cy.sys.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class PageObject<T> implements Serializable{
	private static final long serialVersionUID = -6587244973070497364L;
	private Integer pageCurrent;
	private Integer pageSize;
	private Integer rowCount;
	private Integer pageCount;
	private List<T> records;
	public PageObject(Integer pageCurrent, Integer pageSize, Integer rowCount, List<T> records) {
		super();
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.records = records;
		this.pageCount=(this.rowCount-1)/this.pageSize+1;
	}
	
	
}
