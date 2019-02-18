package com.cryptodashboard.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.cryptodashboard.model.currencies.Cryptocurrency;

public class KrakenUtil {
	
	public static ArrayList<Cryptocurrency> getKrakenCoins() throws UnsupportedEncodingException, IOException, ParseException
	{
		ArrayList<Cryptocurrency> coins = new ArrayList<>();;
		InputStream in = HttpRequest.SendGetRequest("https://api.kraken.com/0/public/Ticker?pair=xbtusd,ethusd,etcusd,bchusd,xrpusd");
		JSONObject obj = JSONUtil.ParseJSONObject(in);
		if(in != null)
		{
			if(obj != null)
			{
				JSONObject object = (JSONObject) obj.get("result");
				
				JSONArray jbch = (JSONArray) ((JSONObject) object.get("BCHUSD")).get("a");
				Cryptocurrency bch = new Cryptocurrency();
				bch.setPrice((String) jbch.get(0));
				System.out.println((String) jbch.get(0));
				
				JSONArray jetc = (JSONArray) ((JSONObject) object.get("XETCZUSD")).get("a");
				Cryptocurrency etc = new Cryptocurrency();
				etc.setPrice((String) jetc.get(0));
				System.out.println((String) jetc.get(0));
				
				JSONArray jeth = (JSONArray) ((JSONObject) object.get("XETHZUSD")).get("a");
				Cryptocurrency eth = new Cryptocurrency();
				eth.setPrice((String) jeth.get(0));
				System.out.println((String) jeth.get(0));
				
				JSONArray jxbt = (JSONArray) ((JSONObject) object.get("XXBTZUSD")).get("a");
				Cryptocurrency xbt = new Cryptocurrency();
				xbt.setPrice((String) jxbt.get(0));
				System.out.println((String) jxbt.get(0));
				
				JSONArray jxrp = (JSONArray) ((JSONObject) object.get("XXRPZUSD")).get("a");
				Cryptocurrency xrp = new Cryptocurrency();
				xrp.setPrice((String) jxrp.get(0));
				System.out.println((String) jxrp.get(0));
				
				coins.add(bch);
				coins.add(etc);
				coins.add(eth);
				coins.add(xbt);
				coins.add(xrp);
				
				return coins;
			}
		}
		return null;
		
	}
	
}
