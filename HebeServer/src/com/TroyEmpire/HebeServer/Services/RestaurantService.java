package com.TroyEmpire.HebeServer.Services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.TroyEmpire.HebeServer.DAO.RestaurantDAO;
import com.TroyEmpire.HebeServer.IDAO.IRestaurantDAO;
import com.TroyEmpire.HebeServer.IServices.IRestaurantService;
import com.TroyEmpire.HebeServer.entities.Restaurant;
import com.TroyEmpire.HebeServer.util.HibernateUtil;


@Service
public class RestaurantService implements IRestaurantService {

	private IRestaurantDAO personDAO = new RestaurantDAO();

	@Override
	public Restaurant findByPersonName(String name) {
		Restaurant restaurant = null;
		try {
			restaurant = personDAO.findByName(name);
		} catch (Exception e) {
		}
		return restaurant;
	}

	@Override
	public List<Restaurant> getAllRestaurant(int campus) {
		List<Restaurant> res = personDAO.findAll(Restaurant.class);
		return res;
	}

	@Override
	public void saveNewRestaurant(Restaurant restaurant) {
		try {
			personDAO.save(restaurant);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Restaurant findRestaurantById(BigDecimal id) {
		Restaurant rs = null;
		try {
			rs = personDAO.findByID(Restaurant.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public void deleteRestaurant(Restaurant restaurant) {
		try {
			personDAO.delete(restaurant);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
