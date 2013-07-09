package com.TroyEmpire.HebeServer.DAO;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.TroyEmpire.HebeServer.IDAO.DAO;
import com.TroyEmpire.HebeServer.IDAO.ICampusDAO;
import com.TroyEmpire.HebeServer.constants.DataAccessLayerException;
import com.TroyEmpire.HebeServer.entities.Campus;
import com.TroyEmpire.HebeServer.util.HibernateUtil;

public class CampusDAO extends DAO<Campus, BigDecimal> implements ICampusDAO {

	@Override
	public Campus getCampusByName(String campusName) {
		Campus cam = null;
		String sql = "SELECT c FROM Campus c WHERE c.name = :name";
		Query query = HibernateUtil.getSession().createQuery(sql)
				.setParameter("name", campusName);
		cam = findOne(query);
		return cam;
	}

}
