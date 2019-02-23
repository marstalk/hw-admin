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
public class CommentDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//用户ID
	private Integer userId;
	//用户名字
	private String userName;
	//商品ID
	private String goodsId;
	//评论详情
	private String comment;
	//评论日期
	private Date cDate;

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：用户名字
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：用户名字
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：商品ID
	 */
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 获取：商品ID
	 */
	public String getGoodsId() {
		return goodsId;
	}
	/**
	 * 设置：评论详情
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * 获取：评论详情
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * 设置：评论日期
	 */
	public void setCDate(Date cDate) {
		this.cDate = cDate;
	}
	/**
	 * 获取：评论日期
	 */
	public Date getCDate() {
		return cDate;
	}
}
