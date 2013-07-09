package com.TroyEmpire.HebeServer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/welcome")
public class Welcome {
	@RequestMapping(method = RequestMethod.GET)
	public String welcome(){
		return "welcome";
	}
}
