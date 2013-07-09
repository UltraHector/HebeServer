package com.TroyEmpire.HebeServer.DAO;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;

import com.TroyEmpire.HebeServer.IDAO.DAO;
import com.TroyEmpire.HebeServer.IDAO.IRestaurantDAO;
import com.TroyEmpire.HebeServer.entities.Restaurant;
import com.TroyEmpire.HebeServer.util.HibernateUtil;

public class RestaurantDAO extends DAO<Restaurant, BigDecimal> implements IRestaurantDAO{
	
	@Override
	public Restaurant findByName(String name) {
			Restaurant res = null;
	        String sql = "SELECT r FROM Restaurant r WHERE r.name = :name";
	        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("name", name);
	        res = findOne(query);
	        return res;
	    }

	@Override
	public List<Restaurant> findRestsaurantByCampusId(int campusId) {
		String sql = "SELECT r FROM Restaurant r WHERE r.campusId = :campusId";
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("campusId", campusId);
        return findMany(query);
	}
}
