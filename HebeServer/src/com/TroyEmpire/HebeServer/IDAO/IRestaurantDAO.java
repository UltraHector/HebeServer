package com.TroyEmpire.HebeServer.IDAO;

import java.math.BigDecimal;
import java.util.List;

import com.TroyEmpire.HebeServer.entities.Restaurant;



/**
 * @author Hector
 */
public interface IRestaurantDAO extends IDAO<Restaurant, BigDecimal>{
	public  Restaurant findByName(String name);
	public List<Restaurant> findRestsaurantByCampusId(int campusId);
}
