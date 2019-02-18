package com.cryptodashboard.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.cryptodashboard.model.currencies.CryptocurrencyCoinMarketCap;
import com.cryptodashboard.utility.CoinMarketCapUtil;
import com.cryptodashboard.utility.HttpRequest;
import com.cryptodashboard.utility.JSONUtil;

@Service
public class CoinMarketCapService {
	
	private ArrayList<CryptocurrencyCoinMarketCap> getDataFromAPI() throws UnsupportedEncodingException, IOException, ParseException
	{
		ArrayList<CryptocurrencyCoinMarketCap> list = null;
		InputStream in = HttpRequest.SendGetRequest("https://api.coinmarketcap.com/v1/ticker/?limit=100");
		if(in != null)
		{
			JSONArray jsonList = JSONUtil.ParseJSONListObject(in);
			if(in != null)
			{
				list = CoinMarketCapUtil.GetAllCoins(jsonList);
			}
		}
		return list;
	}

	public ArrayList<CryptocurrencyCoinMarketCap> getData() throws UnsupportedEncodingException, IOException, ParseException
	{
		return getDataFromAPI();
	}
	
}
