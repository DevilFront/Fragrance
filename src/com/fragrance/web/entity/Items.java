package com.fragrance.web.entity;

public class Items {
	private int itemnums;
	private String img;
	private String name;
	private String brand;
	private int size;
	private int price;
	private String scent;
	private String gender;
	private int maleLike;
	private int femaleLike;
	private String type;
	private String content;
	private String tag;
	
	public Items() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Items(int itemnums, String img, String name, String brand, int size, int price, String scent, String gender,
			int maleLike, int femaleLike, String type, String content, String tag) {
		super();
		this.itemnums = itemnums;
		this.img = img;
		this.name = name;
		this.brand = brand;
		this.size = size;
		this.price = price;
		this.scent = scent;
		this.gender = gender;
		this.maleLike = maleLike;
		this.femaleLike = femaleLike;
		this.type = type;
		this.content = content;
		this.tag = tag;
	}


	public int getItemnums() {
		return itemnums;
	}
	public void setItemnums(int itemnums) {
		this.itemnums = itemnums;
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
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getScent() {
		return scent;
	}
	public void setScent(String scent) {
		this.scent = scent;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getMaleLike() {
		return maleLike;
	}
	public void setMaleLike(int maleLike) {
		this.maleLike = maleLike;
	}
	public int getFemaleLike() {
		return femaleLike;
	}
	public void setFemaleLike(int femaleLike) {
		this.femaleLike = femaleLike;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
	
}
