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
public class EndUserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//User ID
	private Integer id;
	//User sign-up type
	private String type;
	//Phone
	private String phone;
	//Email
	private String email;
	//Gender：M(Male；F(Female)
	private String gender;
	//First Name
	private String firstName;
	//Last Name
	private String lastName;
	//Birthday
	private String birth;
	//Notification
	private String notify;
	//Password
	private String pwd;

	/**
	 *  Set: User ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * Get: ：User ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 *  Set: User sign-up type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * Get: ：User sign-up type
	 */
	public String getType() {
		return type;
	}
	/**
	 *  Set: Phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * Get: ：Phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 *  Set: Email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Get: ：Email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 *  Set: Gender：M(Male；F(Female)
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * Get: ：Gender：M(Male；F(Female)
	 */
	public String getGender() {
		return gender;
	}
	/**
	 *  Set: First Name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Get: ：First Name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 *  Set: Last Name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * Get: ：Last Name
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 *  Set: Birthday
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}
	/**
	 * Get: ：Birthday
	 */
	public String getBirth() {
		return birth;
	}
	/**
	 *  Set: Notification
	 */
	public void setNotify(String notify) {
		this.notify = notify;
	}
	/**
	 * Get: ：Notification
	 */
	public String getNotify() {
		return notify;
	}
	/**
	 *  Set: Password
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * Get: ：Password
	 */
	public String getPwd() {
		return pwd;
	}
}
