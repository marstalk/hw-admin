package com.classm.common.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 字典表
 * 
 * @author
 * @email
 * @date 2017-09-29 18:28:07
 */
public class DictDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
	private Long id;
	//标签名
	private String name;
	//数据值
	private String value;
	//类型
	private String type;
	//描述
	private String description;
	//排序（升序）
	private BigDecimal sort;
	//父级编号
	private Long parentId;
	//创建者
	private Integer createBy;
	//创建时间
	private Date createDate;
	//更新者
	private Long updateBy;
	//更新时间
	private Date updateDate;
	//remark Info
	private String remarks;
	//Delete标记
	private String delFlag;

	/**
	 *  Set: 编号
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Get: ：编号
	 */
	public Long getId() {
		return id;
	}
	/**
	 *  Set: 标签名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Get: ：标签名
	 */
	public String getName() {
		return name;
	}
	/**
	 *  Set: 数据值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * Get: ：数据值
	 */
	public String getValue() {
		return value;
	}
	/**
	 *  Set: 类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * Get: ：类型
	 */
	public String getType() {
		return type;
	}
	/**
	 *  Set: 描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Get: ：描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 *  Set: 排序（升序）
	 */
	public void setSort(BigDecimal sort) {
		this.sort = sort;
	}
	/**
	 * Get: ：排序（升序）
	 */
	public BigDecimal getSort() {
		return sort;
	}
	/**
	 *  Set: 父级编号
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * Get: ：父级编号
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 *  Set: 创建者
	 */
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	/**
	 * Get: ：创建者
	 */
	public Integer getCreateBy() {
		return createBy;
	}
	/**
	 *  Set: 创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * Get: ：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 *  Set: 更新者
	 */
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * Get: ：更新者
	 */
	public Long getUpdateBy() {
		return updateBy;
	}
	/**
	 *  Set: 更新时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * Get: ：更新时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 *  Set: remark Info
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * Get: ：remark Info
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 *  Set: Delete标记
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * Get: ：Delete标记
	 */
	public String getDelFlag() {
		return delFlag;
	}

	@Override
	public String toString() {
		return "DictDO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", value='" + value + '\'' +
				", type='" + type + '\'' +
				", description='" + description + '\'' +
				", sort=" + sort +
				", parentId=" + parentId +
				", createBy=" + createBy +
				", createDate=" + createDate +
				", updateBy=" + updateBy +
				", updateDate=" + updateDate +
				", remarks='" + remarks + '\'' +
				", delFlag='" + delFlag + '\'' +
				'}';
	}
}
