package com.TroyEmpire.HebeServer.IDAO;

import java.math.BigDecimal;
import java.util.List;

import com.TroyEmpire.HebeServer.constants.NewsType;
import com.TroyEmpire.HebeServer.entities.News;

public interface INewsDAO extends IDAO<News, BigDecimal>{
	public News findLatestNews(NewsType type);
	
	/**
	 * @param type
	 * @param id
	 * @return a limited number of news which are a specific type and newer than a given id
	 */
	public List<News> findNewsAboveAnId(NewsType type, int id);

	/**
	 * @return a limited number of news which are newer than a given id
	 */
	List<News> findNewsAboveAnId(int id);
}
