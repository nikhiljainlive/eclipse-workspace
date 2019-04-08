package com.bridgeit.oops;

public class TCompanies {
	String name;
	public int sharePrice;
	public int shareStock;

	public String toString() {
		return "company [name=" + name + ", sharePrice=" + sharePrice + ", shareStock=" + shareStock + "]";
	}

	public TCompanies() {

	}

	public void setName(String name) {
		this.name = name;

	}

	public void setSharePrice(int sharePrice) {
		this.sharePrice = sharePrice;

	}

	public void setShareStock(int shareStock) {
		this.shareStock = shareStock;

	}

	public String getName() {

		return name;
	}

	public int getSharePrice() {

		return sharePrice;
	}

	public int getShareStock() {

		return shareStock;
	}
}
