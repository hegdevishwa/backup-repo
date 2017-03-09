/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.userservice.domain.model;

import java.util.Date;

/**
 * @author avish9
 * Resource representing a bid within the system.
 */
public class Bid {

	/** The bidid of bid. */
	private int bidId;
	
	/** itemid of given item. */
	private int itemId;
	
	/** user id of users who is placing the bid. */
	private int userId;
	
	/** bid price of given item. */
	private double bidPrice;
	
	/** creation date and time of bid. */
	private Date createdDate;

	/**
	 * @return bid id.
	 */
	public int getBidId() {
		return bidId;
	}

	/**
	 * set the bid id.
	 * @param bidId.
	 */
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	/**
	 * @return item id.
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * set the item id.
	 * @param itemId.
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return user id.
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * set the user id.
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return bid price of given item.
	 */
	public double getBidPrice() {
		return bidPrice;
	}

	/**
	 * set the bid price.
	 * @param bidPrice
	 */
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}

	/**
	 * @return creation date and time of bid
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * set the creation date
	 * @param createDate
	 */
	public void setCreatedDate(Date createDate) {
		this.createdDate = createDate;
	}

	 /** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bidId;
		return result;
	}

	 /** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bid other = (Bid) obj;
		if (bidId != other.bidId)
			return false;
		return true;
	}

	 /** {@inheritDoc} */
	@Override
	public String toString() {
		return "Bid [bidId=" + bidId + ", itemId=" + itemId + ", userId=" + userId + ", bidPrice=" + bidPrice
				+ ", createdDate=" + createdDate + "]";
	}

}
