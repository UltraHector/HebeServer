package com.TroyEmpire.HebeServer.IDAO;

import java.math.BigDecimal;

import com.TroyEmpire.HebeServer.entities.Building;

public interface IBuildingDAO extends IDAO<Building, BigDecimal>{
	public Building getBuildingByname(String name);
	public Building getBuildingByCellName(String name);
}
