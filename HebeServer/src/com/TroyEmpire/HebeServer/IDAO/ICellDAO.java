package com.TroyEmpire.HebeServer.IDAO;

import java.math.BigDecimal;
import java.util.List;

import com.TroyEmpire.HebeServer.entities.Building;
import com.TroyEmpire.HebeServer.entities.Cell;

public interface ICellDAO extends IDAO<Cell, BigDecimal>{
	public List<Cell> getCellsByBuildingId(int id);
}
