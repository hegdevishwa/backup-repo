package com.sapient.auction.itemservice.resources.util;

import com.sapient.auction.itemservice.domain.model.Item;

public class ItemControllerUtil {

	public static String validateRequestMessage(Item item) {

		if (item.getName() == null) {
			return "Name cannot be null.";
		} else if (item.getBaseBidPrice() == 0.0) {
			return "Base bid price must be grater than 0.";
		} else if (item.getCategory() == null) {
			return "Category cannot be null.";
		} else {
			return "valid";
		}
	}

}
