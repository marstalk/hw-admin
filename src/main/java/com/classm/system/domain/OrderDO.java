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
public class OrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Integer id;
	//Order ID
	private String orderId;
	//User ID
	private Integer userId;
	//Goods ID
	private String goodsId;
	//Rental Start Date
	private Date rentStartDay;
	//Rental End Date
	private Date rentEndDay;
	//Daily Fee
	private Float dailyFee;
	//Plaform Service
	private Float serviceFee;
	//Total Fee
	private Float totalFee;
	//Pay Type
	private String payType;
	//Pay Status0: unpay; 1:paying; 99: paied
	private Integer payStatus;
	//Audit Status：0:unaudit; 99: audited
	private Integer auditStatus;

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
	 *  Set: Order ID
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * Get: ：Order ID
	 */
	public String getOrderId() {
		return orderId;
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
	/**
	 *  Set: Rental Start Date
	 */
	public void setRentStartDay(Date rentStartDay) {
		this.rentStartDay = rentStartDay;
	}
	/**
	 * Get: ：Rental Start Date
	 */
	public Date getRentStartDay() {
		return rentStartDay;
	}
	/**
	 *  Set: Rental End Date
	 */
	public void setRentEndDay(Date rentEndDay) {
		this.rentEndDay = rentEndDay;
	}
	/**
	 * Get: ：Rental End Date
	 */
	public Date getRentEndDay() {
		return rentEndDay;
	}
	/**
	 *  Set: Daily Fee
	 */
	public void setDailyFee(Float dailyFee) {
		this.dailyFee = dailyFee;
	}
	/**
	 * Get: ：Daily Fee
	 */
	public Float getDailyFee() {
		return dailyFee;
	}
	/**
	 *  Set: Plaform Service
	 */
	public void setServiceFee(Float serviceFee) {
		this.serviceFee = serviceFee;
	}
	/**
	 * Get: ：Plaform Service
	 */
	public Float getServiceFee() {
		return serviceFee;
	}
	/**
	 *  Set: Total Fee
	 */
	public void setTotalFee(Float totalFee) {
		this.totalFee = totalFee;
	}
	/**
	 * Get: ：Total Fee
	 */
	public Float getTotalFee() {
		return totalFee;
	}
	/**
	 *  Set: Pay Type
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**
	 * Get: ：Pay Type
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 *  Set: Pay Status0: unpay; 1:paying; 99: paied
	 */
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	/**
	 * Get: ：Pay Status0: unpay; 1:paying; 99: paied
	 */
	public Integer getPayStatus() {
		return payStatus;
	}
	/**
	 *  Set: Audit Status：0:unaudit; 99: audited
	 */
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	/**
	 * Get: ：Audit Status：0:unaudit; 99: audited
	 */
	public Integer getAuditStatus() {
		return auditStatus;
	}
}
