package com.cryptodashboard.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.cryptodashboard.model.currencies.Cryptocurrency;
import com.cryptodashboard.model.exchanges.Exchange;
import com.cryptodashboard.utility.BinanceUtil;

@Service
public class BinanceService {

	private Exchange getDataFromAPI() throws UnsupportedEncodingException, IOException, ParseException
	{
		Exchange binance = new Exchange();
		
		ArrayList<Cryptocurrency> list = BinanceUtil.getBinanceCoins();
		binance.setBtc(list.get(0));
		binance.setEth(list.get(1));
		binance.setEtc(list.get(2));
		binance.setBch(list.get(3));
		binance.setXrp(list.get(4));
		
		return binance;
	}
	
	public Exchange getData() throws UnsupportedEncodingException, IOException, ParseException
	{
		return getDataFromAPI();
	}
	
}
