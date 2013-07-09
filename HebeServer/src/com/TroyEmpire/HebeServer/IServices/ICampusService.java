package com.TroyEmpire.HebeServer.IServices;

import com.TroyEmpire.HebeServer.entities.Campus;

public interface ICampusService {
	public void saveNewCampus(Campus campus);
	
	public Campus getCampusByName(String name);

}
