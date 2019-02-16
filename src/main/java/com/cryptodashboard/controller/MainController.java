package com.cryptodashboard.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cryptodashboard.model.currencies.Cryptocurrency;
import com.cryptodashboard.service.CoinMarketCapService;

@Controller
public class MainController {
	
	/*@Autowired
	private BinanceService binanceService;*/
	
	@Autowired
	private CoinMarketCapService coinMarketCapService;
	
	@RequestMapping("/index")
	public String home() throws UnsupportedEncodingException, IOException, ParseException
	{
		//binanceService.getData();
		ArrayList<Cryptocurrency> coinData = coinMarketCapService.getData();
		for(int i=0; i<coinData.size(); i++)
		{
			System.out.println(coinData.get(i).getId());
			System.out.println(coinData.get(i).getName());
			System.out.println(coinData.get(i).getPrice_usd());
			System.out.println();			
		}
		return "test";
	}

}
