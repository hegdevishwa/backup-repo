package com.sapient.auction.itemservice.resources;

import java.net.URI;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sapient.auction.itemservice.constants.ApplicationConstants;
import com.sapient.auction.itemservice.domain.model.Item;
import com.sapient.auction.itemservice.exception.ServiceException;
import com.sapient.auction.itemservice.resources.util.ItemControllerUtil;
import com.sapient.auction.itemservice.services.ItemService;

@RestController
public class ItemController {

	private static final Logger LOGGER = Logger.getLogger(ItemController.class);
	/*
	 * @Autowired private DiscoveryClient discoveryClient;
	 */

	@Autowired
	private ItemService itemService;

	/*
	 * @RequestMapping("/service-instances/{applicationName}") public
	 * List<InstanceInfo> serviceInstancesByApplicationName(@PathVariable String
	 * applicationName) { return
	 * this.discoveryClient.getInstancesById(applicationName); }
	 */
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<String> pingService() {

		return ResponseEntity.ok().body(ApplicationConstants.SERVICE_STATUS_UP);
	}

	@RequestMapping(path = "/items", method = RequestMethod.POST)
	public ResponseEntity<?> createSaleItem(@RequestBody Item item) throws ServiceException {

		LOGGER.debug("Method: createSaleItem");

		String validationResponse = ItemControllerUtil.validateRequestMessage(item);

		if (ApplicationConstants.VALID_REQUEST_MESSAGE.equalsIgnoreCase(validationResponse)) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationResponse);
		}

		int result = itemService.createSaleItem(item);

		if (result >= 1) {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(item.getItemId())
					.toUri();
			return ResponseEntity.status(HttpStatus.CREATED).location(uri).build();

		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApplicationConstants.ITEM_NOT_CREATED);
		}
	}

	@RequestMapping(path = "/items", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> getActiveSaleItems() throws ServiceException {

		List<Item> items = itemService.getActiveSaleItems();
		if (null == items || items.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(items);
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(items);
		}
	}

	@RequestMapping(path = "/items/{itemId}", method = RequestMethod.GET)
	public ResponseEntity<Item> getItem(@PathVariable(value = "itemId") int itemId) throws ServiceException {

		Item item = itemService.getItem(itemId);

		if (null == item) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(item);
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(item);
		}
	}

	@ExceptionHandler({ ServiceException.class, Exception.class })
	public ResponseEntity<String> handleExceptions(Exception e, Model model) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
	}

}
