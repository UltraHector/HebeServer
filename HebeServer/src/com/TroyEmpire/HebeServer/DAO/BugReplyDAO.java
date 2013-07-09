package com.TroyEmpire.HebeServer.DAO;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.TroyEmpire.HebeServer.IDAO.DAO;
import com.TroyEmpire.HebeServer.IDAO.IBugReplyDAO;
import com.TroyEmpire.HebeServer.constants.DataAccessLayerException;
import com.TroyEmpire.HebeServer.entities.BugReply;
import com.TroyEmpire.HebeServer.util.HibernateUtil;

public class BugReplyDAO extends DAO<BugReply, BigDecimal> implements
		IBugReplyDAO {

	@Override
	public List<BugReply> getBugReplyByBugId(int id) {
		HibernateUtil.getSession().getTransaction().begin();
		List<BugReply> bugReplyList = null;
		String sql = "select br from BugReply br where br.bugId = :bugId";
		Query query = HibernateUtil.getSession().createQuery(sql)
				.setParameter("bugId", id);
		bugReplyList = findMany(query);
		HibernateUtil.getSession().getTransaction().commit();

		return bugReplyList;
	}
}
