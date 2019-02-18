package com.cryptodashboard.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cryptodashboard.model.currencies.CryptocurrencyCoinMarketCap;
import com.cryptodashboard.model.exchanges.Exchange;
import com.cryptodashboard.service.CoinMarketCapService;
import com.cryptodashboard.service.KrakenService;

@Controller
public class MainController {
	
	/*@Autowired
	private BinanceService binanceService;*/
	
	@Autowired
	private CoinMarketCapService coinMarketCapService;
	
	@Autowired
	private KrakenService krakenService;
	
	@RequestMapping("/index")
	public String home(Model model) throws UnsupportedEncodingException, IOException, ParseException
	{
		//binanceService.getData();
		ArrayList<CryptocurrencyCoinMarketCap> coinData = coinMarketCapService.getData();
		Exchange kraken = krakenService.getData();
		model.addAttribute("kraken", kraken);
		model.addAttribute("coins", coinData);
		/*for(int i=0; i<coinData.size(); i++)
		{
			System.out.println(coinData.get(i).getId());
			System.out.println(coinData.get(i).getName());
			System.out.println(coinData.get(i).getPrice_usd());
			System.out.println();			
		}*/
		return "index1";
	}

}
