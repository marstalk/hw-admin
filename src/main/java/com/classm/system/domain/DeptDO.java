package com.classm.system.domain;

import java.io.Serializable;



/**
 * Department管理
 * 
 * @author
 * @email
 * @date 2017-09-27 14:28:36
 */
public class DeptDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long deptId;
	//上级DepartmentID，一级Department为0
	private Long parentId;
	//Department名称
	private String name;
	//排序
	private Integer orderNum;
	//是否Delete  -1：已Delete  0：Normal
	private Integer delFlag;

	/**
	 *  Set:
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	/**
	 * Get: ：
	 */
	public Long getDeptId() {
		return deptId;
	}
	/**
	 *  Set: 上级DepartmentID，一级Department为0
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * Get: ：上级DepartmentID，一级Department为0
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 *  Set: Department名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Get: ：Department名称
	 */
	public String getName() {
		return name;
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
	 *  Set: 是否Delete  -1：已Delete  0：Normal
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * Get: ：是否Delete  -1：已Delete  0：Normal
	 */
	public Integer getDelFlag() {
		return delFlag;
	}

	@Override
	public String toString() {
		return "DeptDO{" +
				"deptId=" + deptId +
				", parentId=" + parentId +
				", name='" + name + '\'' +
				", orderNum=" + orderNum +
				", delFlag=" + delFlag +
				'}';
	}
}
