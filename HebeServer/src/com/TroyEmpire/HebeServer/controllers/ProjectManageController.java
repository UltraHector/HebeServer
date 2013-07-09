package com.TroyEmpire.HebeServer.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import com.TroyEmpire.HebeServer.IServices.IProjectManageService;
import com.TroyEmpire.HebeServer.Services.ProjectManageService;
import com.TroyEmpire.HebeServer.entities.Bug;
import com.TroyEmpire.HebeServer.entities.BugReply;
import com.TroyEmpire.HebeServer.entities.Building;
import com.TroyEmpire.HebeServer.entities.Cell;
import com.TroyEmpire.HebeServer.entities.PublicIdea;
import com.TroyEmpire.HebeServer.entities.PublicIdeaReply;
import com.TroyEmpire.HebeServer.entities.YellowPage;

@Controller
public class ProjectManageController {

	private IProjectManageService projectManageservice = new ProjectManageService();

	@RequestMapping(value = "/mainIntroduction", method = RequestMethod.GET)
	public String mainIntroduction() {
		return "mainIntroduction";
	}

	@RequestMapping(value = "/bugReport", method = RequestMethod.GET)
	public ModelAndView bugReport(Model model) {
		List<BugReply> bugReply = new ArrayList<BugReply>();
		List<Bug> bugList = new ArrayList<Bug>();
		bugList = projectManageservice.getAllBugs();
		Map<Bug, List<BugReply>> bugAndReply = new HashMap<Bug, List<BugReply>>();
		for (Bug bug : bugList) {
			bugReply = projectManageservice.getBugReplyByBugId(bug.getId());
			bugAndReply.put(bug, bugReply);
		}
		model.addAttribute("bugAndReply", bugAndReply);
		return new ModelAndView(model);
	}

	@RequestMapping(value = "/bugReport", method = RequestMethod.POST)
	public String bugReport(HttpServletRequest request, Model model) {
		Bug bug = new Bug();
		bug.setTitle(request.getParameter("bugTitle"));
		bug.setDescription(request.getParameter("bugDescription"));
		bug.setReporterName(request.getParameter("bugReporterName"));
		bug.setReportDate(Calendar.getInstance().getTime());
		projectManageservice.saveBug(bug);
		return "redirect:/bugReport";
	}

	@RequestMapping(value = "/bugReply", method = RequestMethod.POST)
	public String bugReply(HttpServletRequest request, Model model) {
		BugReply bugreply = new BugReply();
		bugreply.setContent(request.getParameter("bugReplyContent"));
		bugreply.setBugId(Integer.valueOf(request.getParameter("bugId")));
		bugreply.setReplyDate(Calendar.getInstance().getTime());
		projectManageservice.saveBugReply(bugreply);
		return "redirect:/bugReport";
	}

	@RequestMapping(value = "/uploadCell", method = RequestMethod.POST)
	public String uploadCell(HttpServletRequest request, Model model) {
		Cell cell = new Cell();
		cell.setBuildingId(Integer.valueOf(request
				.getParameter("cellBuildingId")));
		cell.setDescription(request.getParameter("cellDescription"));
		cell.setName(request.getParameter("cellName"));
		projectManageservice.saveCell(cell);
		return "redirect:/maintenance";
	}
	
	@RequestMapping(value = "/uploadPublicIdea", method = RequestMethod.POST)
	public String uploadPublicIdea(HttpServletRequest request, Model model){
		PublicIdea publicIdea = new PublicIdea();
		publicIdea.setDescription(request.getParameter("publicIdeaDescription"));
		publicIdea.setTitle(request.getParameter("publicIdeaTitle"));
		publicIdea.setPublishDate(Calendar.getInstance().getTime());
		projectManageservice.savePublicIdea(publicIdea);
		return "redirect:/maintenance";
	}
	
	@RequestMapping(value = "/uploadPublicIdeaReply", method = RequestMethod.POST)
	public String uploadPublicIdeaReply(HttpServletRequest request, Model model){
		PublicIdeaReply reply = new PublicIdeaReply();
		reply.setContent(request.getParameter("publicIdeaReplyContent"));
		reply.setPublicIdeaId(Integer.valueOf(request.getParameter("publicIdeaId")));
		reply.setReplyDate(Calendar.getInstance().getTime());
		projectManageservice.savePublicIdeaReply(reply);
		return "redirect:/maintenance";
	}

	@RequestMapping(value = "/uploadYellowPage", method = RequestMethod.POST)
	public String uploadYellowPage(HttpServletRequest request, Model model) {
		YellowPage yellowPage = new YellowPage();
		yellowPage.setName(request.getParameter("yellowPageName"));
		yellowPage.setNumber(request.getParameter("yellowPageNumber"));
		projectManageservice.saveYellowPage(yellowPage);

		return "redirect:/maintenance";
	}

	@RequestMapping(value = "/maintenance", method = RequestMethod.GET)
	public ModelAndView maintenance(Model model) {
		// add the public ideas
		Map<PublicIdea, List<PublicIdeaReply>> publicIdeaList = new HashMap<PublicIdea, List<PublicIdeaReply>>();
		List<PublicIdea> publicIdeas = projectManageservice.getAllPublicIdea();
		for (PublicIdea idea : publicIdeas) {
			List<PublicIdeaReply> ideaReply = projectManageservice
					.getPublicIdeaReplyByIdeaId(idea.getId());
			publicIdeaList.put(idea, ideaReply);
		}
		model.addAttribute("publicIdeaList", publicIdeaList);

		// add the buildings
		Map<Building, List<Cell>> buildingList = new HashMap<Building, List<Cell>>();
		List<Building> buildings = projectManageservice.getAllBuildings();
		for (Building building : buildings) {
			List<Cell> cellList = projectManageservice
					.getAllCellByBuildingId(building.getId());
			buildingList.put(building, cellList);
		}
		model.addAttribute("buildingList", buildingList);

		// add the yellow pages
		List<YellowPage> yellowPages = projectManageservice.getAllYellowPages();
		model.addAttribute("yellowPages", yellowPages);

		return new ModelAndView("maintenance");
	}

	@RequestMapping(value = "/manual", method = RequestMethod.GET)
	public String manual() {
		return "manual";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String download() {
		return "download";
	}

	@RequestMapping(value = "/joinUs", method = RequestMethod.GET)
	public String joinUs() {
		return "joinUs";
	}

	@RequestMapping(value = "/developTeam", method = RequestMethod.GET)
	public String developTeam() {
		return "developTeam";
	}

	@RequestMapping(value = "/futureVersion", method = RequestMethod.GET)
	public String futureVersion() {
		return "futureVersion";
	}

	@RequestMapping(value = "/serveJnu", method = RequestMethod.GET)
	public String serveJnu() {
		return "serveJnu";
	}

}
