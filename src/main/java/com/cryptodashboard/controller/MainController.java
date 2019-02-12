package com.cryptodashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import com.cryptodashboard.service.BinanceService;

@Controller
public class MainController {
	
	@Autowired
	private BinanceService binanceService;
	
	@RequestMapping("/index")
	public String home()
	{
		binanceService.getData();
		return "test";
	}

}
