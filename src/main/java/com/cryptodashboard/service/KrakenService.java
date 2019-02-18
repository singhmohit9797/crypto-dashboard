package com.cryptodashboard.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.cryptodashboard.model.currencies.Bitcoin;
import com.cryptodashboard.model.exchanges.Kraken;
import com.cryptodashboard.utility.HttpRequest;
import com.cryptodashboard.utility.JSONUtil;

@Service
public class KrakenService {
	
	private Kraken getDataFromAPI() throws UnsupportedEncodingException, IOException, ParseException
	{
		Kraken kraken = new Kraken();
		//ArrayList<Kraken> krakenCoins = null;
		
		Bitcoin btc = getKrakenBTC();
		kraken.setBtc(btc);
		return kraken;
	}
	
	public Kraken getData() throws UnsupportedEncodingException, IOException, ParseException
	{
		return getDataFromAPI();
	}
	
	private Bitcoin getKrakenBTC() throws UnsupportedEncodingException, IOException, ParseException
	{
		Bitcoin btc = null;
		InputStream in = HttpRequest.SendGetRequest("https://api.kraken.com/0/public/Ticker?pair=xbtusd");
		JSONObject obj = JSONUtil.ParseJSONObject(in);
		if(in != null)
		{
			if(obj != null)
			{
				JSONArray arr = ((JSONArray) ((JSONObject) ((JSONObject) obj.get("result")).get("XXBTZUSD")).get("a"));	
				btc = new Bitcoin();
				btc.setPrice((String) arr.get(0));
				System.out.println(btc.getPrice());
			}
		}
		return btc;
	}

}
