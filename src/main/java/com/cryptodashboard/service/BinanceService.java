package com.cryptodashboard.service;

import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.cryptodashboard.utility.HttpRequest;

@Service
public class BinanceService {

	
	private InputStream getDataFromAPI()
	{
		InputStream in = HttpRequest.SendGetRequest("https://api.binance.com/api/v3/ticker/price");
		if(in!=null)
		{
			
			System.out.println(in);
		}
		return null;
	}
	
	public InputStream getData()
	{
		return getDataFromAPI();
	}
	
}
