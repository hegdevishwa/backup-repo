package com.sapient.auction.itemservice.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int itemId;

	@NotEmpty(message = "Please enter name")
	@Column(name = "name")
	private String name;

	@NotEmpty(message = "Please choose category")
	private String category;

	private String description;

	@Column(name = "base_bid_price")
	private double baseBidPrice;

	@Column(name = "userid")
	private int userId;

	@Column(name = "created_date_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDateTime;

	@Column(name = "expiry_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;

/*	@Column(name = "image")
	private byte[] imageByteArray;
*/
	private String imageUrl;

	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the baseBidPrice
	 */
	public double getBaseBidPrice() {
		return baseBidPrice;
	}

	/**
	 * @param baseBidPrice
	 *            the baseBidPrice to set
	 */
	public void setBaseBidPrice(double baseBidPrice) {
		this.baseBidPrice = baseBidPrice;
	}

	/**
	 * @return the createDateTime
	 */
	public Date getCreateDateTime() {
		return createDateTime;
	}

	/**
	 * @param createDateTime
	 *            the createDateTime to set
	 */
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate
	 *            the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the imageByteArray
	 *//*
	public byte[] getImageByteArray() {
		return imageByteArray;
	}

	*//**
	 * @param imageByteArray
	 *            the imageByteArray to set
	 *//*
	public void setImageByteArray(byte[] imageByteArray) {
		this.imageByteArray = imageByteArray;
	}
*/
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", category=" + category + ", description=" + description
				+ ", baseBidPrice=" + baseBidPrice + ", createDate=" + createDateTime + ", userId=" + userId
				+ ", updateDate=" + "]";
	}

}
