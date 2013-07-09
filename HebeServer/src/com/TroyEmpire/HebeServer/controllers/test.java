package com.TroyEmpire.HebeServer.controllers;

import com.TroyEmpire.HebeServer.IServices.IRestaurantService;
import com.TroyEmpire.HebeServer.Services.RestaurantService;
import com.TroyEmpire.HebeServer.entities.Restaurant;

public class test {

	/**
	 * @param args
	 */
	private static IRestaurantService rstService = new RestaurantService();
	public static void main(String[] args) {
		Restaurant res = new Restaurant();
		res.setManagerName("shids");
		res.setPhoneNumber("shif");
		res.setName("sitfdf");
		rstService.saveNewRestaurant(res);

	}

}
