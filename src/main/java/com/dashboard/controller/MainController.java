package com.dashboard.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dashboard.entity.Exchange;
import com.dashboard.service.DBService;



@Controller
public class MainController {
	
	@Autowired
	private DBService dbService;
	
	/*public void populateExchanges()
	{
		dbService.populateExchanges();
	}*/
	
	private Exchange binance = new Exchange("binance");
	
	@Scheduled(fixedRate = 10000)
	public void updateDB() throws UnsupportedEncodingException, IOException, ParseException
	{
		dbService.updateCryptoData(binance);
	}
	
	@RequestMapping("/index")
	public String home(Model model) throws UnsupportedEncodingException, IOException, ParseException
	{
	
		model.addAttribute("binance", binance);
		
		return "index1";
	}

}
