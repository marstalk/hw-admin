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
public class OrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Integer id;
	//订单ID
	private String orderId;
	//用户ID
	private Integer userId;
	//商品ID
	private String goodsId;
	//租赁开始日期
	private Date rentStartDay;
	//租赁结束日期
	private Date rentEndDay;
	//商品日租金
	private Float dailyFee;
	//服务费
	private Float serviceFee;
	//总费用
	private Float totalFee;
	//支付类型
	private Integer payType;
	//支付状态0: unpay; 1:paying; 99: paied
	private Integer payStatus;
	//审核状态：0:unaudit; 99: audited
	private Integer auditStatus;

	/**
	 * 设置：自增ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：自增ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：订单ID
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单ID
	 */
	public String getOrderId() {
		return orderId;
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
	 * 设置：租赁开始日期
	 */
	public void setRentStartDay(Date rentStartDay) {
		this.rentStartDay = rentStartDay;
	}
	/**
	 * 获取：租赁开始日期
	 */
	public Date getRentStartDay() {
		return rentStartDay;
	}
	/**
	 * 设置：租赁结束日期
	 */
	public void setRentEndDay(Date rentEndDay) {
		this.rentEndDay = rentEndDay;
	}
	/**
	 * 获取：租赁结束日期
	 */
	public Date getRentEndDay() {
		return rentEndDay;
	}
	/**
	 * 设置：商品日租金
	 */
	public void setDailyFee(Float dailyFee) {
		this.dailyFee = dailyFee;
	}
	/**
	 * 获取：商品日租金
	 */
	public Float getDailyFee() {
		return dailyFee;
	}
	/**
	 * 设置：服务费
	 */
	public void setServiceFee(Float serviceFee) {
		this.serviceFee = serviceFee;
	}
	/**
	 * 获取：服务费
	 */
	public Float getServiceFee() {
		return serviceFee;
	}
	/**
	 * 设置：总费用
	 */
	public void setTotalFee(Float totalFee) {
		this.totalFee = totalFee;
	}
	/**
	 * 获取：总费用
	 */
	public Float getTotalFee() {
		return totalFee;
	}
	/**
	 * 设置：支付类型
	 */
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	/**
	 * 获取：支付类型
	 */
	public Integer getPayType() {
		return payType;
	}
	/**
	 * 设置：支付状态0: unpay; 1:paying; 99: paied
	 */
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	/**
	 * 获取：支付状态0: unpay; 1:paying; 99: paied
	 */
	public Integer getPayStatus() {
		return payStatus;
	}
	/**
	 * 设置：审核状态：0:unaudit; 99: audited
	 */
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	/**
	 * 获取：审核状态：0:unaudit; 99: audited
	 */
	public Integer getAuditStatus() {
		return auditStatus;
	}
}
