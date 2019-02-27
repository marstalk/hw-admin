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
public class GoodsPicDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Integer id;
	//Goods ID
	private String goodsId;
	//Pic Related Url
	private String picUrl;

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
	/**
	 *  Set: Pic Related Url
	 */
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	/**
	 * Get: ：Pic Related Url
	 */
	public String getPicUrl() {
		return picUrl;
	}
}
