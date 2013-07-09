package com.TroyEmpire.HebeServer.IDAO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;

public interface IDAO <T, ID extends Serializable>{
    public void save(T entity);
    
    public void merge(T entity);
 
    public void delete(T entity);
 
    public List<T> findMany(Query query);
 
    public T findOne(Query query);
 
    public T findByID(Class<T> clazz, BigDecimal id);
    
    public void saveAll(List<T> data);
    
    public List<T> findAll(Class<T> clazz);
}
