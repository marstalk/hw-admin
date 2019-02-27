package com.classm.system.domain;

import java.io.Serializable;
import java.util.Date;

public class MenuDO implements Serializable {
	private static final long serialVersionUID = 1L;
	//
	private Long menuId;
	// 父menuID，一级menu为0
	private Long parentId;
	// menu名称
	private String name;
	// menuURL
	private String url;
	// 授权(多个用逗号分隔，如：user:list,user:create)
	private String perms;
	// 类型 0：directory 1：menu 2：button
	private Integer type;
	// menu图标
	private String icon;
	// 排序
	private Integer orderNum;
	// 创建时间
	private Date gmtCreate;
	// Update时间
	private Date gmtModified;

	/**
	 *  Set:
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * Get: ：
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 *  Set: 父menuID，一级menu为0
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * Get: ：父menuID，一级menu为0
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 *  Set: menu名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get: ：menu名称
	 */
	public String getName() {
		return name;
	}

	/**
	 *  Set: menuURL
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Get: ：menuURL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 *  Set: 授权(多个用逗号分隔，如：user:list,user:create)
	 */
	public void setPerms(String perms) {
		this.perms = perms;
	}

	/**
	 * Get: ：授权(多个用逗号分隔，如：user:list,user:create)
	 */
	public String getPerms() {
		return perms;
	}

	/**
	 *  Set: 类型 0：directory 1：menu 2：button
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * Get: ：类型 0：directory 1：menu 2：button
	 */
	public Integer getType() {
		return type;
	}

	/**
	 *  Set: menu图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * Get: ：menu图标
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 *  Set: 排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * Get: ：排序
	 */
	public Integer getOrderNum() {
		return orderNum;
	}

	/**
	 *  Set: 创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	/**
	 * Get: ：创建时间
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}

	/**
	 *  Set: Update时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	/**
	 * Get: ：Update时间
	 */
	public Date getGmtModified() {
		return gmtModified;
	}

	@Override
	public String toString() {
		return "MenuDO{" +
				"menuId=" + menuId +
				", parentId=" + parentId +
				", name='" + name + '\'' +
				", url='" + url + '\'' +
				", perms='" + perms + '\'' +
				", type=" + type +
				", icon='" + icon + '\'' +
				", orderNum=" + orderNum +
				", gmtCreate=" + gmtCreate +
				", gmtModified=" + gmtModified +
				'}';
	}
}
