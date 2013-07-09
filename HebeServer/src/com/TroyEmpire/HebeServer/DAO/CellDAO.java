package com.TroyEmpire.HebeServer.DAO;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.TroyEmpire.HebeServer.IDAO.DAO;
import com.TroyEmpire.HebeServer.IDAO.ICellDAO;
import com.TroyEmpire.HebeServer.entities.BugReply;
import com.TroyEmpire.HebeServer.entities.Building;
import com.TroyEmpire.HebeServer.entities.Cell;
import com.TroyEmpire.HebeServer.util.HibernateUtil;

public class CellDAO extends DAO<Cell, BigDecimal> implements ICellDAO {
	
	@Override
	public List<Cell> getCellsByBuildingId(int id){
		HibernateUtil.getSession().getTransaction().begin();
		List<Cell> cellList = null;
		String sql = "select c from Cell c where c.buildingId = :buildingId";
		Query query = HibernateUtil.getSession().createQuery(sql)
				.setParameter("buildingId", id);
		cellList = findMany(query);
		HibernateUtil.getSession().getTransaction().commit();

		return cellList;
	}
}
