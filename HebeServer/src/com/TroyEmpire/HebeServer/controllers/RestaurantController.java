package com.TroyEmpire.HebeServer.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TroyEmpire.HebeServer.IServices.ICampusService;
import com.TroyEmpire.HebeServer.IServices.IRestaurantService;
import com.TroyEmpire.HebeServer.Services.CampusService;
import com.TroyEmpire.HebeServer.Services.RestaurantService;
import com.TroyEmpire.HebeServer.constants.Constant;
import com.TroyEmpire.HebeServer.entities.Restaurant;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

	private Logger log = Logger.getLogger(RestaurantController.class);

	private IRestaurantService rstService = new RestaurantService();
	private ICampusService camService = new CampusService();

	@RequestMapping(value = "/getAllRestaurant", method = RequestMethod.GET)
	public @ResponseBody
	List<Restaurant> getAllRestaurant(int campusId) {
		return rstService.getAllRestaurant(campusId);
	}

	@RequestMapping(value = "/createNewRestaurant", method = RequestMethod.GET)
	public String createNewRestaurantGet() {
		return "createRestaurant";
	}

	// show restaurants page on the web to manage
	@RequestMapping(value = "/manageRestaurants/{campusId}")
	public String managerRestaurantGet(@PathVariable int campusId, Model model) {
		model.addAttribute("restaurants", rstService.getAllRestaurant(campusId));
		return "restaurants";
	}

	@RequestMapping(value = "/createNewRestaurant", method = RequestMethod.POST)
	public String createNewRestaurantPost(HttpServletRequest request,
			Model model) {
		Restaurant res = new Restaurant();
		try {
			String logoPath = Constant.DB_PATH;
			@SuppressWarnings("unchecked")
			List<FileItem> items = new ServletFileUpload(
					new DiskFileItemFactory()).parseRequest(request);
			Map<String, String> commonField = new HashMap<String, String>();
			for (FileItem item : items) {
				if (item.isFormField()) {
					// Process regular form field (input
					// type="text|radio|checkbox|etc", select, etc).
					String fieldname = item.getFieldName();
					String fieldvalue = item.getString("UTF-8").trim();
					commonField.put(fieldname, fieldvalue);

				} else {
					// Process form file field (input type="file").
					File file = new File(logoPath + "\\" + "Temp" + "\\"
							+ commonField.get("restaurantName") + ".jpg");
					file.createNewFile();
					FileOutputStream logofile = new FileOutputStream(file);
					InputStream logo = item.getInputStream();
					IOUtils.copy(logo, logofile);
					logo.close();
					logofile.close();
				}
			}
			// getCampusId
			res.setCampusId(camService.getCampusByName(
					commonField.get("campusName")).getId());
			// save the commonfield content
			res.setManagerName(commonField.get("managerName"));
			res.setNotes(commonField.get("notes"));
			res.setAddress(commonField.get("address"));
			res.setDescription(commonField.get("description"));
			res.setPhoneNumber(commonField.get("phoneNumber"));
			res.setName(commonField.get("restaurantName"));
			// save the new restaurant
			rstService.saveNewRestaurant(res);

			// rename the file to id.jpg
			File file = new File(logoPath + "\\" + "Temp" + "\\"
					+ commonField.get("restaurantName") + ".jpg");
			File fileto = new File(logoPath + "\\" + "Campus_"
					+ res.getCampusId() + "\\" + res.getId() + ".jpg");
			IOUtils.copy(new FileInputStream(file),
					new FileOutputStream(fileto));
			file.delete();
			log.info(res.getName() + " has been added! ");

		} catch (Exception e) {
			log.error(e.toString());
			return "createNewRestaurantError";
		}
		model.addAttribute("restaurants",
				rstService.getAllRestaurant(res.getCampusId()));
		return "restaurants";

	}

	@RequestMapping(value = "/updateARestaurant", method = RequestMethod.POST)
	public void updateRestaurant(Model model) {
		// to do update rs
	}

	@RequestMapping(value = "/deleteARestaurant", method = RequestMethod.POST)
	public void deleteRestaurant(Model model) {
		// to do delete rs
	}
}
