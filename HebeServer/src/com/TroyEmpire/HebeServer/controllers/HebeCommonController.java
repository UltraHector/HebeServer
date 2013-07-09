package com.TroyEmpire.HebeServer.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HebeCommonController {
	@RequestMapping(value="/whetherConnectionBlock")
	public String whetherConnectionBlock(HttpServletResponse response){
		response.addHeader("Status", "Clear");
		return "welcome";
	}
}
