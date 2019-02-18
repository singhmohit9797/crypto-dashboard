package com.cryptodashboard.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.cryptodashboard.model.currencies.Cryptocurrency;
import com.cryptodashboard.model.exchanges.Exchange;
import com.cryptodashboard.utility.KrakenUtil;

@Service
public class KrakenService {
	
	private Exchange getDataFromAPI() throws UnsupportedEncodingException, IOException, ParseException
	{
		Exchange kraken = new Exchange();
		
		ArrayList<Cryptocurrency> list = KrakenUtil.getKrakenCoins();
		
		kraken.setBch(list.get(0));
		kraken.setEtc(list.get(1));
		kraken.setEth(list.get(2));
		kraken.setBtc(list.get(3));
		kraken.setXrp(list.get(4));
		
		return kraken;
	}
	
	public Exchange getData() throws UnsupportedEncodingException, IOException, ParseException
	{
		return getDataFromAPI();
	}

}
