package com.classm.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author hw
 * @email hw@test.com
 * @date 2019-02-23 15:32:24
 */
public class GoodsTypeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//商品类型ID
	private Integer id;
	//商品类型
	private String name;

	/**
	 * 设置：商品类型ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：商品类型ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：商品类型
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：商品类型
	 */
	public String getName() {
		return name;
	}
}
