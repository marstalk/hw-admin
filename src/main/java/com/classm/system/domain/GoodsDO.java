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
public class GoodsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Integer id;
	//Goods ID
	private String goodsId;
	//Goods Name
	private String name;
	//Type Name
	private String typeName;
	//Type ID
	private Integer type;
	//Rental Daily
	private Float rentalcost;
	//Deposit
	private Float deposit;
	//Description
	private String desc;
	//Exchange Addr
	private String addr;
	//Owner ID
	private Integer owner;

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
	 *  Set: Goods Name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Get: ：Goods Name
	 */
	public String getName() {
		return name;
	}
	/**
	 *  Set: Type Name
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * Get: ：Type Name
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 *  Set: Type ID
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * Get: ：Type ID
	 */
	public Integer getType() {
		return type;
	}
	/**
	 *  Set: Rental Daily
	 */
	public void setRentalcost(Float rentalcost) {
		this.rentalcost = rentalcost;
	}
	/**
	 * Get: ：Rental Daily
	 */
	public Float getRentalcost() {
		return rentalcost;
	}
	/**
	 *  Set: Deposit
	 */
	public void setDeposit(Float deposit) {
		this.deposit = deposit;
	}
	/**
	 * Get: ：Deposit
	 */
	public Float getDeposit() {
		return deposit;
	}
	/**
	 *  Set: Description
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * Get: ：Description
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 *  Set: Exchange Addr
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	/**
	 * Get: ：Exchange Addr
	 */
	public String getAddr() {
		return addr;
	}
	/**
	 *  Set: Owner ID
	 */
	public void setOwner(Integer owner) {
		this.owner = owner;
	}
	/**
	 * Get: ：Owner ID
	 */
	public Integer getOwner() {
		return owner;
	}
}
