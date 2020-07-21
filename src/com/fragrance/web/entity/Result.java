package com.fragrance.web.entity;

public class Result{
	private int itemNums;
	private String img;
	private String name;
	private String brand;
	private String gender;
	private String age;
	private String season;
	private String scent;
	
	public Result() {

	}

	public Result(int itemNums, String img, String name, String brand, String gender, String age, String season,
			String scent) {
		super();
		this.itemNums = itemNums;
		this.img = img;
		this.name = name;
		this.brand = brand;
		this.gender = gender;
		this.age = age;
		this.season = season;
		this.scent = scent;
	}

	public int getItemNums() {
		return itemNums;
	}

	public void setItemNums(int itemNums) {
		this.itemNums = itemNums;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getScent() {
		return scent;
	}

	public void setScent(String scent) {
		this.scent = scent;
	}

	@Override
	public String toString() {
		return "Result [itemNums=" + itemNums + ", img=" + img + ", name=" + name + ", brand=" + brand + ", gender="
				+ gender + ", age=" + age + ", season=" + season + ", scent=" + scent + "]";
	}
	
	}
