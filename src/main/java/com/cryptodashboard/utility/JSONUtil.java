package com.cryptodashboard.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.cryptodashboard.model.currencies.Cryptocurrency;

public class JSONUtil {
	
	public static JSONArray ParseJSONListObject(InputStream inputStream) throws UnsupportedEncodingException, IOException, ParseException
	{
		JSONArray result;
		result = new JSONArray();
		JSONParser parser = new JSONParser();
		result = (JSONArray) parser.parse( new InputStreamReader(inputStream, "UTF-8"));
		return result;
	}
	
	
	public static Cryptocurrency GetCryptocurrencyObject(JSONObject obj)
	{
		Cryptocurrency coin = null;
		if(obj != null)
		{
			coin = new Cryptocurrency();
			coin.setId((String) obj.get("id"));
			coin.setName((String)obj.get("name"));
			coin.setRank((String) obj.get("rank"));
			coin.setPrice_usd((String)obj.get("price_usd"));
			coin.setPrice_btc((String) obj.get("price_btc"));
			coin.setVolume_usd_24h((String)obj.get("24h_volume_usd"));
			coin.setMarket_cap_usd((String)obj.get("market_cap_usd"));
			coin.setAvailable_supply((String)obj.get("available_supply"));
			coin.setTotal_supply((String)obj.get("total_supply"));
			coin.setMax_supply((String)obj.get("max_supply"));
			coin.setPercent_change_1h((String)obj.get("percent_change_1h"));
			coin.setPercent_change_24h((String)obj.get("percent_change_24h"));
			coin.setPercent_change_7d((String)obj.get("percent_change_7d"));
			coin.setLast_updated((String) obj.get("last_updated"));
		}
		return coin;
	}

	public static ArrayList<Cryptocurrency> GetAllCoins(JSONArray array)
	{
		ArrayList<Cryptocurrency> list = null;
		if(array != null)
		{
			list = new ArrayList<>();
			for(int i=0; i<array.size(); i++)
			{
				JSONObject obj = (JSONObject) array.get(i);
				Cryptocurrency coin = GetCryptocurrencyObject(obj);
				
				if(coin != null)
					list.add(coin);
			}
		}
		return list;
	}
	
}
