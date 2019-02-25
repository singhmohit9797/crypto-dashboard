package com.dashboard.utility;


import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.dashboard.entity.Cryptocurrency;
import com.dashboard.entity.Exchange;

public class BinanceUtil {
	
	public static ArrayList<Cryptocurrency> getBinanceCoins(Exchange exchange) throws UnsupportedEncodingException, IOException, ParseException
	{
		ArrayList<Cryptocurrency> coins = new ArrayList<>();;
		InputStream in = HttpRequest.SendGetRequest("https://api.binance.com/api/v3/ticker/price");
		JSONArray array = JSONUtil.ParseJSONListObject(in);
		if(in != null)
		{
			if(array != null)
			{
				Timestamp time = new Timestamp(System.currentTimeMillis());
				Cryptocurrency btc = new Cryptocurrency("bitcoin", exchange);
				Cryptocurrency eth = new Cryptocurrency("ethereum", exchange);
				Cryptocurrency etc = new Cryptocurrency("ethereum classic", exchange);
				Cryptocurrency bch = new Cryptocurrency("bitcoin cash", exchange);
				Cryptocurrency xrp = new Cryptocurrency("ripple", exchange);
				for(int i=0; i<array.size(); i++)
				{
					JSONObject obj = (JSONObject) array.get(i);
					if((obj.get("symbol").equals("BTCUSDT")))
					{						
						btc.setPrice((String) obj.get("price"));
						btc.setTimestamp(time);
					}
					else if(obj.get("symbol").equals("ETHUSDT"))
					{						
						eth.setPrice((String) obj.get("price"));
						eth.setTimestamp(time);
					}
					else if(obj.get("symbol").equals("ETCUSDT"))
					{						
						etc.setPrice((String) obj.get("price"));	
						etc.setTimestamp(time);
					}
					else if(obj.get("symbol").equals("BCHABCUSDT"))
					{			
						bch.setPrice((String) obj.get("price"));
						bch.setTimestamp(time);
					}
					else if(obj.get("symbol").equals("XRPUSDT"))
					{						
						xrp.setPrice((String) obj.get("price"));
						xrp.setTimestamp(time);
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
