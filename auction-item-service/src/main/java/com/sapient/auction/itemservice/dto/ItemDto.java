package com.sapient.auction.itemservice.dto;

import java.util.Date;

public class ItemDto {

	private int itemId;
	private String name;
	private String category;
	private String description;
	private double baseBidPrice;
	private int userId;
	private Date createDateTime;
	private Date expiryDate;
	private byte[] imageByteArray;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getBaseBidPrice() {
		return baseBidPrice;
	}

	public void setBaseBidPrice(double baseBidPrice) {
		this.baseBidPrice = baseBidPrice;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public byte[] getImageByteArray() {
		return imageByteArray;
	}

	public void setImageByteArray(byte[] imageByteArray) {
		this.imageByteArray = imageByteArray;
	}

}
