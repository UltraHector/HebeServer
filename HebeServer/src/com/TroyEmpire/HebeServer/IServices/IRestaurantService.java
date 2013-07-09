package com.TroyEmpire.HebeServer.IServices;

import java.math.BigDecimal;
import java.util.List;

import com.TroyEmpire.HebeServer.entities.Restaurant;


public interface IRestaurantService {
    public Restaurant findByPersonName(String name);
    
    public List<Restaurant> getAllRestaurant(int campus);
 
    public void saveNewRestaurant(Restaurant restaurant);
 
    public Restaurant findRestaurantById(BigDecimal id);
 
    public void deleteRestaurant(Restaurant restaurant);

}
