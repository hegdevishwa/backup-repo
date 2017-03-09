package com.sapient.auction.itemservice.services.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.auction.itemservice.constants.ApplicationConstants;
import com.sapient.auction.itemservice.domain.dao.ItemDao;
import com.sapient.auction.itemservice.domain.model.Item;
import com.sapient.auction.itemservice.exception.ServiceException;
import com.sapient.auction.itemservice.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	private static final Logger LOGGER = Logger.getLogger(ItemServiceImpl.class);

	@Autowired
	private ItemDao itemDao;

	/**
	 * Creates a sale
	 * 
	 * @param Item
	 * @return response code: 0-failure, 1-success
	 * 
	 */
	@Override
	@Transactional
	public int createSaleItem(Item item) throws ServiceException {

		LOGGER.debug("Method: createSaleItem");

		setCreateExpiryDates(item);
		return itemDao.createSaleItem(item);
	}

	/**
	 * Returns active sale items
	 * 
	 * @return List of active items
	 * @throws ServiceException
	 */
	@Override
	public List<Item> getActiveSaleItems() throws ServiceException {

		List<Item> items = itemDao.getActiveSaleItems();

		if (null == items || items.isEmpty()) {
			LOGGER.info("No active sale items available.");
			throw new ServiceException("No active sale items found.");
		}
		return items;
	}

	/**
	 * Method to get item details
	 * 
	 * @param Integer
	 *            itemId
	 * 
	 * @return item details
	 */
	@Override
	public Item getItem(Integer itemId) {

		LOGGER.debug("Method: getItem");

		Item item = itemDao.getItem(itemId);
		return item;
	}

	/**
	 * 
	 * @param item
	 */
	private void setCreateExpiryDates(Item item) {
		item.setCreateDateTime(new Date());
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.DATE, ApplicationConstants.THREE);
		item.setExpiryDate(calender.getTime());
	}

	/**
	 * @return the itemDao
	 */
	public ItemDao getItemDao() {
		return itemDao;
	}

	/**
	 * @param itemDao
	 *            the itemDao to set
	 */
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

}
