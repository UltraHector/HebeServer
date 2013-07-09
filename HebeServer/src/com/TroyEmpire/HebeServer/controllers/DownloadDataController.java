package com.TroyEmpire.HebeServer.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.TroyEmpire.HebeServer.constants.Constant;

@Controller
@RequestMapping("/downloadData")
public class DownloadDataController {

	@RequestMapping(value = "/restaurants/{campusId}", method = RequestMethod.GET)
	public void downloadRestaurantsData(@PathVariable int campusId,
			HttpServletResponse response) {
		
		// get the requested zip file path
		String zipFilePath = Constant.DB_PATH + "\\Campus_" + campusId;
		// set the content type
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition",
				"attachment;filename=Campus_" + campusId + "_Restaurants.zip");	
		try{
			ServletOutputStream out = response.getOutputStream();
			File dataZipFile = new File(zipFilePath + "\\Campus_" + campusId + "_Restaurant.zip");
			InputStream in = new FileInputStream(dataZipFile);
			IOUtils.copy(in, out);
			in.close();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/map/{campusId}", method = RequestMethod.GET)
	public void downloadMapData(@PathVariable int campusId,
			HttpServletResponse response) {
		
		// get the requested zip file path
		String zipFilePath = Constant.DB_PATH + "\\Campus_" + campusId;
		// set the content type
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition",
				"attachment;filename=Campus_" + campusId + "_Map.zip");	
		try{
			ServletOutputStream out = response.getOutputStream();
			File dataZipFile = new File(zipFilePath + "\\Campus_" + campusId + "_Map.zip");
			InputStream in = new FileInputStream(dataZipFile);
			IOUtils.copy(in, out);
			in.close();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/hebeVersion1", method = RequestMethod.GET)
	public void downloadHebeClient(HttpServletResponse response){
		// get the requested zip file path
				String zipFilePath = Constant.DB_PATH + "\\Campus_" + 1;
				// set the content type
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition",
						"attachment;filename=Hebe_Beta.apk");
				try{
					ServletOutputStream out = response.getOutputStream();
					File dataZipFile = new File(zipFilePath + "\\Hebe.apk");
					InputStream in = new FileInputStream(dataZipFile);
					IOUtils.copy(in, out);
					in.close();
					out.close();
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	
}
