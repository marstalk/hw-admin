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
public class EndUserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户ID
	private Integer id;
	//用户注册类型
	private String type;
	//手机
	private String phone;
	//邮箱
	private String email;
	//性别：M男；F女
	private String gender;
	//姓氏
	private String firstName;
	//名字
	private String lastName;
	//生日
	private String birth;
	//是否接收通知
	private String notify;
	//登陆密码
	private String pwd;

	/**
	 * 设置：用户ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：用户ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：用户注册类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：用户注册类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：手机
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：性别：M男；F女
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * 获取：性别：M男；F女
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * 设置：姓氏
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * 获取：姓氏
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * 设置：名字
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * 获取：名字
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * 设置：生日
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}
	/**
	 * 获取：生日
	 */
	public String getBirth() {
		return birth;
	}
	/**
	 * 设置：是否接收通知
	 */
	public void setNotify(String notify) {
		this.notify = notify;
	}
	/**
	 * 获取：是否接收通知
	 */
	public String getNotify() {
		return notify;
	}
	/**
	 * 设置：登陆密码
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * 获取：登陆密码
	 */
	public String getPwd() {
		return pwd;
	}
}
