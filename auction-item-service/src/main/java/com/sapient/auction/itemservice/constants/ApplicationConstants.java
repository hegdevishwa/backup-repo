package com.sapient.auction.itemservice.constants;

public class ApplicationConstants {

	/********** Start View constants ************/
	public static final String LOGIN_VIEW = "login";
	public static final String REGISTER_VIEW = "register";
	public static final String HOME_VIEW = "home";
	public static final String ITEMDETAILS_VIEW = "itemDetails";
	public static final String SALEITEM_VIEW = "saleItems";
	public static final String CREATESALEITEM_VIEW = "createSaleItem";
	public static final String ERROR_VIEW = "error";
	public static final String BAD_VIEW_403 = "403";

	/********** End View constants ************/
	/********** Start Request Mappings constants ************/
	public static final String HOME_REQUEST = "/home";
	public static final String ITEMS_REQUEST = "/items";
	public static final String CREATE_ITEM_REQUEST = "/createSaleItem";
	public static final String GET_ITEM_REQUEST = "/items/{itemId}";
	public static final String CREATE_BID_REQUEST = "/items/createbidForItem";
	public static final String BAD_REQUEST = "/403";
	public static final String REGISTER_REQUEST = "/register";
	public static final String AUCTIONREGISTER_REQUEST = "/auctionRegistration";

	/********** End Request Mappings constants ************/
	/********** Start Global constants ************/
	public static final String REDIRECT = "redirect:";
	public static final String SLASH = "/";
	public static final String SERVICE_STATUS_UP = "Item service is up and running!!";
	public static final String VALID_REQUEST_MESSAGE = "valid";
	/********** End Global constants ************/

	public static final int THREE = 3;

	/************** Error messages ********************/
	public static final String ITEM_NOT_CREATED = "Item not created. Error creating the sale item in database.";

	private ApplicationConstants() {
	}

}
