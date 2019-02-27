package com.classm.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author hw
 * @email hw@test.com
 * @date 2019-02-26 20:12:42
 */
public class CommentDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Integer id;
	//User ID
	private Integer userId;
	//User Name
	private String userName;
	//Goods ID
	private String goodsId;
	//Comment
	private String comment;
	//Comment Date
	private Date cDate;

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
	 *  Set: User Name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * Get: ：User Name
	 */
	public String getUserName() {
		return userName;
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
	 *  Set: Comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * Get: ：Comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 *  Set: Comment Date
	 */
	public void setCDate(Date cDate) {
		this.cDate = cDate;
	}
	/**
	 * Get: ：Comment Date
	 */
	public Date getCDate() {
		return cDate;
	}
}
