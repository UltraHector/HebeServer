package com.TroyEmpire.HebeServer.DAO;

import java.math.BigDecimal;
import org.hibernate.Query;

import com.TroyEmpire.HebeServer.IDAO.DAO;
import com.TroyEmpire.HebeServer.IDAO.IBuildingDAO;
import com.TroyEmpire.HebeServer.entities.Building;
import com.TroyEmpire.HebeServer.entities.Cell;
import com.TroyEmpire.HebeServer.util.HibernateUtil;

public class BuildingDAO extends DAO<Building, BigDecimal> implements IBuildingDAO {

	@Override
	public Building getBuildingByname(String name) {
		HibernateUtil.getSession().beginTransaction();
		Building buil = null;
        String sql = "SELECT b FROM Building b WHERE b.name = :name";
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("name", name);
        buil = findOne(query);
        HibernateUtil.getSession().getTransaction().commit();
        return buil;
	}
	
	@Override
	public Building getBuildingByCellName(String name) {
		HibernateUtil.getSession().beginTransaction();
		Building buil = null;
        String sql = "SELECT b FROM Cell c, Building b WHERE c.name = :name and c.buildingId = b.id";
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("name", name);
        buil = findOne(query);
        HibernateUtil.getSession().getTransaction().commit();
        return buil;
	}

}
