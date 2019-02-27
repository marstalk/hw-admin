package com.classm.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author hw
 * @email hw@test.com
 * @date 2019-02-26 20:12:43
 */
public class GoodsTypeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Integer id;
	//Name
	private String name;

	/**
	 *  Set: ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * Get: ：ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 *  Set: Name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Get: ：Name
	 */
	public String getName() {
		return name;
	}
}
