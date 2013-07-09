package com.TroyEmpire.HebeServer.DAO;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.TroyEmpire.HebeServer.IDAO.DAO;
import com.TroyEmpire.HebeServer.IDAO.INewsDAO;
import com.TroyEmpire.HebeServer.constants.Constant;
import com.TroyEmpire.HebeServer.constants.NewsType;
import com.TroyEmpire.HebeServer.entities.News;
import com.TroyEmpire.HebeServer.util.HibernateUtil;

public class NewsDAO extends DAO<News, BigDecimal> implements INewsDAO {

	@Override
	public News findLatestNews(NewsType type) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String sql = "select n from News n where n.newsType = :type order by n.id DESC";
		Query query = session.createQuery(sql).setParameter("type", type);
		try {
			query.setMaxResults(1);
			News news = (News) query.uniqueResult();
			return news;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
		}
		return null;
	}

	@Override
	public List<News> findNewsAboveAnId(NewsType type, int id) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String sql = "select n from News n where n.newsType = :type and id > :id " +
					 "order by n.id DESC";
		Query query = session.createQuery(sql).setParameter("type", type).setParameter("id", id);
		try {
			query.setMaxResults(Constant.NUMBER_UPDATE_NEWS_TO_CLIENT);
			List<News> newsList =  query.list();
			return newsList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
		}
		return null;
	}
	
	@Override
	public List<News> findNewsAboveAnId(int id) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String sql = "select n from News n where id > :id " +
					 "order by n.id DESC";
		Query query = session.createQuery(sql).setParameter("id", id);
		try {
			query.setMaxResults(Constant.NUMBER_UPDATE_NEWS_TO_CLIENT);
			List<News> newsList =  query.list();
			return newsList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
		}
		return null;
	}

}
