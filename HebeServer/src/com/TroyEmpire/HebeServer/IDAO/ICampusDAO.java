package com.TroyEmpire.HebeServer.IDAO;

import java.math.BigDecimal;

import com.TroyEmpire.HebeServer.entities.Campus;

public interface ICampusDAO extends IDAO<Campus, BigDecimal>{
	public Campus getCampusByName(String campusName);
}
