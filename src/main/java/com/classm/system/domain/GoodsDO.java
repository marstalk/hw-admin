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
public class GoodsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Integer id;
	//商品ID
	private String goodsId;
	//商品名称
	private String name;
	//商品类型
	private String typeName;
	//商品类型ID
	private Integer type;
	//单日租金
	private Float rentalcost;
	//商品押金
	private Float deposit;
	//描述
	private String desc;
	//交易地址
	private String addr;
	//商品所有者ID
	private Integer owner;

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
	 * 设置：商品名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：商品名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：商品类型
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 获取：商品类型
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 设置：商品类型ID
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：商品类型ID
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：单日租金
	 */
	public void setRentalcost(Float rentalcost) {
		this.rentalcost = rentalcost;
	}
	/**
	 * 获取：单日租金
	 */
	public Float getRentalcost() {
		return rentalcost;
	}
	/**
	 * 设置：商品押金
	 */
	public void setDeposit(Float deposit) {
		this.deposit = deposit;
	}
	/**
	 * 获取：商品押金
	 */
	public Float getDeposit() {
		return deposit;
	}
	/**
	 * 设置：描述
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 获取：描述
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * 设置：交易地址
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	/**
	 * 获取：交易地址
	 */
	public String getAddr() {
		return addr;
	}
	/**
	 * 设置：商品所有者ID
	 */
	public void setOwner(Integer owner) {
		this.owner = owner;
	}
	/**
	 * 获取：商品所有者ID
	 */
	public Integer getOwner() {
		return owner;
	}
}
