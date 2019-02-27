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
public class LikeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Integer id;
	//User ID
	private Integer userId;
	//Goods ID
	private String goodsId;

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
	 *  Set: User ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * Get: ：User ID
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 *  Set: Goods ID
	 */
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * Get: ：Goods ID
	 */
	public String getGoodsId() {
		return goodsId;
	}
}
