package com.cryptodashboard.service;

import java.io.InputStream;

import org.springframework.stereotype.Service;

@Service
public class BinanceService {

	
	private InputStream getDataFromAPI()
	{
		/*InputStream in = HttpRequest.SendGetRequest("https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT");
		if(in!=null)
		{
			Scanner sc = new Scanner(in);
			String inline = null;
			while(sc.hasNext())
			{
			inline+=sc.nextLine();
			}
			System.out.println("\nJSON data in string format"	);
			String ins = inline.substring(4, inline.length());
			System.out.println(ins);
			sc.close();
			JSONObject jsonObject = new JSONObject(ins);
			System.out.println(jsonObject.get("price"));
			//System.out.println(in);
		}*/
		return null;
	}
	
	public InputStream getData()
	{
		return getDataFromAPI();
	}
	
}
