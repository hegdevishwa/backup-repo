package com.sapient.auction.itemservice.services;

import java.util.List;

import com.sapient.auction.itemservice.domain.model.Item;
import com.sapient.auction.itemservice.exception.ServiceException;

public interface ItemService {

	public int createSaleItem(Item item) throws ServiceException;

	public Item getItem(Integer itemId) throws ServiceException;

	public List<Item> getActiveSaleItems() throws ServiceException;

}
