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
	// 修改时间
	private Date gmtModified;

	/**
	 * 设置：
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * 获取：
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * 设置：父menuID，一级menu为0
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取：父menuID，一级menu为0
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 设置：menu名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：menu名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：menuURL
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获取：menuURL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置：授权(多个用逗号分隔，如：user:list,user:create)
	 */
	public void setPerms(String perms) {
		this.perms = perms;
	}

	/**
	 * 获取：授权(多个用逗号分隔，如：user:list,user:create)
	 */
	public String getPerms() {
		return perms;
	}

	/**
	 * 设置：类型 0：directory 1：menu 2：button
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 获取：类型 0：directory 1：menu 2：button
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 设置：menu图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * 获取：menu图标
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * 设置：排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * 获取：排序
	 */
	public Integer getOrderNum() {
		return orderNum;
	}

	/**
	 * 设置：创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	/**
	 * 获取：创建时间
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}

	/**
	 * 设置：修改时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	/**
	 * 获取：修改时间
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
