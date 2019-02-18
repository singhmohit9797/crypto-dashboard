package com.cryptodashboard.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.cryptodashboard.model.currencies.Cryptocurrency;

public class BinanceUtil {
	
	public static ArrayList<Cryptocurrency> getBinanceCoins() throws UnsupportedEncodingException, IOException, ParseException
	{
		ArrayList<Cryptocurrency> coins = new ArrayList<>();;
		InputStream in = HttpRequest.SendGetRequest("https://api.binance.com/api/v3/ticker/price");
		JSONArray array = JSONUtil.ParseJSONListObject(in);
		if(in != null)
		{
			if(array != null)
			{
				Cryptocurrency btc = new Cryptocurrency();
				Cryptocurrency eth = new Cryptocurrency();
				Cryptocurrency etc = new Cryptocurrency();
				Cryptocurrency bch = new Cryptocurrency();
				Cryptocurrency xrp = new Cryptocurrency();
				for(int i=0; i<array.size(); i++)
				{
					JSONObject obj = (JSONObject) array.get(i);
					if((obj.get("symbol").equals("BTCUSDT")))
					{						
						btc.setPrice((String) obj.get("price"));						
					}
					else if(obj.get("symbol").equals("ETHUSDT"))
					{						
						eth.setPrice((String) obj.get("price"));						
					}
					else if(obj.get("symbol").equals("ETCUSDT"))
					{						
						etc.setPrice((String) obj.get("price"));						
					}
					else if(obj.get("symbol").equals("BCHABCUSDT"))
					{			
						bch.setPrice((String) obj.get("price"));						
					}
					else if(obj.get("symbol").equals("XRPUSDT"))
					{						
						xrp.setPrice((String) obj.get("price"));						
					}
					
					coins.add(btc);
					coins.add(eth);
					coins.add(etc);
					coins.add(bch);
					coins.add(xrp);
				}
				return coins;
			}
		}
		return null;
	}

}
