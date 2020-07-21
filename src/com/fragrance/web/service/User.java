package com.fragrance.web.service;

public class User {
	private int userNum;
	private String mail;
	private String pw;
	private String nickName;
	private String name;
	private int age;
	private String gender;
	private String role;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User(int userNum, String mail, String pw, String nickName, String name, int age, String gender,
			String role) {
		this.userNum = userNum;
		this.mail = mail;
		this.pw = pw;
		this.nickName = nickName;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userNum=" + userNum + ", mail=" + mail + ", pw=" + pw + ", nickName=" + nickName + ", name="
				+ name + ", age=" + age + ", gender=" + gender + ", role=" + role + "]";
	}
	
	
}
