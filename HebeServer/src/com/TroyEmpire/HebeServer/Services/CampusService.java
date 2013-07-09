package com.TroyEmpire.HebeServer.Services;

import org.springframework.stereotype.Service;

import com.TroyEmpire.HebeServer.DAO.CampusDAO;
import com.TroyEmpire.HebeServer.IDAO.ICampusDAO;
import com.TroyEmpire.HebeServer.IServices.ICampusService;
import com.TroyEmpire.HebeServer.entities.Campus;



@Service
public class CampusService implements ICampusService{

	private ICampusDAO campusDap = new CampusDAO();
	@Override
	public void saveNewCampus(Campus campus) {
		campusDap.save(campus);	
	}
	
	@Override
	public Campus getCampusByName(String name) {
		return campusDap.getCampusByName(name);
	}

}
