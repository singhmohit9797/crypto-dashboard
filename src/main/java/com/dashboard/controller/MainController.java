package com.dashboard.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dashboard.entity.Cryptocurrency;
import com.dashboard.service.BinanceService;



@Controller
public class MainController {
	
	@Autowired
	private BinanceService binanceService;
	
	ArrayList<Cryptocurrency> binanceCoins;
	
	@Scheduled(fixedRate = 10000)
	public void updateDB() throws UnsupportedEncodingException, IOException, ParseException
	{
		binanceCoins = binanceService.updateCryptoData();
	}
	
	@RequestMapping("/index")
	public String home(Model model) throws UnsupportedEncodingException, IOException, ParseException
	{
	
		model.addAttribute("binance", binanceCoins);
		
		return "index1";
	}

}
