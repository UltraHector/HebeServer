package com.TroyEmpire.HebeServer.Services;

import java.math.BigDecimal;
import java.util.List;

import com.TroyEmpire.HebeServer.DAO.BugDAO;
import com.TroyEmpire.HebeServer.DAO.BugReplyDAO;
import com.TroyEmpire.HebeServer.DAO.BuildingDAO;
import com.TroyEmpire.HebeServer.DAO.CellDAO;
import com.TroyEmpire.HebeServer.DAO.PublicIdeaDAO;
import com.TroyEmpire.HebeServer.DAO.PublicIdeaReplyDAO;
import com.TroyEmpire.HebeServer.DAO.YellowPageDAO;
import com.TroyEmpire.HebeServer.IDAO.IBugDAO;
import com.TroyEmpire.HebeServer.IDAO.IBugReplyDAO;
import com.TroyEmpire.HebeServer.IDAO.IBuildingDAO;
import com.TroyEmpire.HebeServer.IDAO.ICellDAO;
import com.TroyEmpire.HebeServer.IDAO.IPublicIdeaDAO;
import com.TroyEmpire.HebeServer.IDAO.IPublicIdeaRelyDAO;
import com.TroyEmpire.HebeServer.IDAO.IYellowPageDAO;
import com.TroyEmpire.HebeServer.IServices.IProjectManageService;
import com.TroyEmpire.HebeServer.entities.Bug;
import com.TroyEmpire.HebeServer.entities.BugReply;
import com.TroyEmpire.HebeServer.entities.Building;
import com.TroyEmpire.HebeServer.entities.Cell;
import com.TroyEmpire.HebeServer.entities.PublicIdea;
import com.TroyEmpire.HebeServer.entities.PublicIdeaReply;
import com.TroyEmpire.HebeServer.entities.YellowPage;

public class ProjectManageService implements IProjectManageService {
	
	private IBugDAO bugDao = new BugDAO();
	private IBugReplyDAO bugReplyDao = new BugReplyDAO();
	private IPublicIdeaDAO publicIdeaDao = new PublicIdeaDAO();
	private IPublicIdeaRelyDAO publicIdeaReplyDao = new PublicIdeaReplyDAO();
	private IBuildingDAO buildingDao = new BuildingDAO();
	private IYellowPageDAO yellowPageDao = new YellowPageDAO();
	
	private ICellDAO cellDao = new CellDAO();

	@Override
	public void saveBug(Bug bug) {
		bugDao.save(bug);
	}

	@Override
	public void saveBugReply(BugReply bugReply) {
		bugReplyDao.save(bugReply);
	}

	@Override
	public void savePublicIdea(PublicIdea publicIdea) {
		publicIdeaDao.save(publicIdea);
	}

	@Override
	public void savePublicIdeaReply(PublicIdeaReply publicIdeaReply) {
		publicIdeaReplyDao.save(publicIdeaReply);
	}

	@Override
	public Bug getBugById(int id) {
		return bugDao.findByID(Bug.class, BigDecimal.valueOf(id));
	}

	@Override
	public List<Bug> getAllBugs() {
		return bugDao.findAll(Bug.class);
	}

	@Override
	public List<BugReply> getBugReplyByBugId(int id) {
		return bugReplyDao.getBugReplyByBugId(id);
	}

	@Override
	public PublicIdea getPublicIdeaById(int id) {
		return publicIdeaDao.findByID(PublicIdea.class, BigDecimal.valueOf(id));
	}

	@Override
	public List<PublicIdea> getAllPublicIdea() {
		return publicIdeaDao.findAll(PublicIdea.class);
	}

	@Override
	public List<PublicIdeaReply> getPublicIdeaReplyByIdeaId(int id) {
		return publicIdeaReplyDao.getPublicIdeaReplyByIdeaId(id);
	}

	@Override
	public List<Cell> getAllCellByBuildingId(int id) {
		return cellDao.getCellsByBuildingId(id);
	}

	@Override
	public Cell getCellById(int id) {
		return cellDao.findByID(Cell.class, BigDecimal.valueOf(id));
	}

	@Override
	public void saveCell(Cell cell) {
		cellDao.save(cell);
	}

	@Override
	public List<Building> getAllBuildings() {
		return buildingDao.findAll(Building.class);
	}

	@Override
	public Building getBuildingById(int id) {
		return buildingDao.findByID(Building.class, BigDecimal.valueOf(id));
	}

	@Override
	public void saveYellowPage(YellowPage entity) {
		yellowPageDao.save(entity);
	}

	@Override
	public List<YellowPage> getAllYellowPages() {
		return yellowPageDao.findAll(YellowPage.class);
	}

}
