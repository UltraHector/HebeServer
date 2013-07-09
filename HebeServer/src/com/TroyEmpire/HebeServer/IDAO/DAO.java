package com.TroyEmpire.HebeServer.IDAO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.TroyEmpire.HebeServer.constants.DataAccessLayerException;
import com.TroyEmpire.HebeServer.util.HibernateUtil;

public abstract class DAO<T, ID extends Serializable> implements IDAO<T, ID> {
	private static final int BATCH_SIZE = 40;
	
	private Session session;
	private Transaction tx;
	
	private void  startOperation() {
		this.session = HibernateUtil.getSession();
		this.tx = session.beginTransaction();
	}
	
	private void handleException(HibernateException e) throws DataAccessLayerException {
		HibernateUtil.rollbackTransaction();
        throw new DataAccessLayerException(e);
    }

	public void save(T entity) {
		 try {
	            startOperation();
	            session.saveOrUpdate(entity);
	            tx.commit();
	        } catch (HibernateException e) {
	            handleException(e);
	        } finally {
	        }
	}

	public void saveAll(List<T> data) {
		try {
			startOperation();
			for (int i = 0; i < data.size(); i++) {
				Object object = data.get(i);
				session.save(object);
				if (i != 0 && i % BATCH_SIZE == 0)
					session.flush();

			}

			session.flush();
			session.clear();
			tx.commit();
		} catch (Throwable e) {
			throw new RuntimeException(e.getMessage(), e);
		} 
		finally{
		}
	}

	public void merge(T entity) {
		 try {
	            startOperation();
	    		session.merge(entity);
	            tx.commit();
	        } catch (HibernateException e) {
	            handleException(e);
	        } finally {
	        }
	}

	public void delete(T entity) {
		try {
            startOperation();
    		session.delete(entity);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
        }
	}

	public List<T> findMany(Query query) {
		List<T> t = null;
		try {
    		t = (List<T>) query.list();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
        }
		return t;
	}

	public T findOne(Query query) {
		T t = null;
		try {
    		t = (T) query.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
        }
		return t;
	}

	public T findByID(Class<T> clazz, BigDecimal id) {
		T t = null;
		try {
            startOperation();
    		t = (T) session.get(clazz, id);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
        }
		return t;
	}
	
	
	public List<T> findAll(Class<T> clazz) {
        List<T> objects = null;
        try {
            startOperation();
            Query query = session.createQuery("from " + clazz.getName());
            objects = query.list();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
        }
        return objects;
    }


}
