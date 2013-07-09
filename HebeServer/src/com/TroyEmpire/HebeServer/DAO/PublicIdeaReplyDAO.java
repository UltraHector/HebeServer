package com.TroyEmpire.HebeServer.DAO;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import com.TroyEmpire.HebeServer.IDAO.DAO;
import com.TroyEmpire.HebeServer.IDAO.IPublicIdeaRelyDAO;
import com.TroyEmpire.HebeServer.entities.PublicIdeaReply;
import com.TroyEmpire.HebeServer.util.HibernateUtil;

public class PublicIdeaReplyDAO extends DAO<PublicIdeaReply, BigDecimal>
		implements IPublicIdeaRelyDAO {

	@Override
	public List<PublicIdeaReply> getPublicIdeaReplyByIdeaId(int id) {
		HibernateUtil.getSession().beginTransaction();
		List<PublicIdeaReply> publicIdeaReplyList = null;
		String sql = "select pir from PublicIdeaReply pir where pir.publicIdeaId = :publicIdeaId";
		Query query = HibernateUtil.getSession().createQuery(sql)
				.setParameter("publicIdeaId", id);
		publicIdeaReplyList = findMany(query);
		HibernateUtil.getSession().getTransaction().commit();
		return publicIdeaReplyList;
	}
}
