package com.joe.jade4j.pojo;

public class Book {

	private String name;

	private double price;

	private boolean available;

	public Book(String name, double price, boolean available) {
		this.name = name;
		this.price = price;
		this.available = available;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
