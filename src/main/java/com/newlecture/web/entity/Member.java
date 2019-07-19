package com.newlecture.web.entity;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private int gender;
	private int age;
	private String birthday;
	private String phone;
	private String bossId;
	private String type;
	
	
	public Member() {
		
	}
	
	public Member(String id,String pwd, String name,int gender,int age,
			String birthday,String phone,String bossId,String type) {
		this.id=id;
		this.pwd=pwd;
		this.name=name;
		this.gender=gender;
		this.age=age;
		this.birthday=birthday;
		this.phone = phone;
		this.bossId = bossId;
		this.type = type;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the gender
	 */
	public int getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the bossId
	 */
	public String getBossId() {
		return bossId;
	}
	/**
	 * @param bossId the bossId to set
	 */
	public void setBossId(String bossId) {
		this.bossId = bossId;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
}
