package com.register.demo;

public class User {
	private String user;
	private String password;
	private String age;
	private String gender;
	private String phone;
	private String email;
	
	public User() {
		this.user = "Bad Query";
		this.password = "-1";
		this.age = "-1";
		this.gender = "---";
		this.phone = "-1";
		this.email = "Bad Query";
	}
	
	public User(String user, String password, String age, String gender, String phone, String email) {
		this.user = user;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [user=" + user + ", password=" + password + ", age=" + age
				+ ", gender=" + gender + ", phone=" + phone + ", email="
				+ email + ", toString()=" + super.toString() + "]";
		
	}
}

