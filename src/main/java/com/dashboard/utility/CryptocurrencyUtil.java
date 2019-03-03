package com.dashboard.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.dashboard.entity.Cryptocurrency;

public class CryptocurrencyUtil {
	
	public static Cryptocurrency getCoin(String exchange, String coinpair) throws UnsupportedEncodingException, IOException, ParseException
	{
		Cryptocurrency coin = new Cryptocurrency(coinpair, exchange);
		InputStream in = HttpRequest.SendGetRequest("https://api.cryptowat.ch/markets/"+exchange+"/"+coinpair+"/summary");
		Timestamp time = new Timestamp(System.currentTimeMillis());
		JSONObject obj = JSONUtil.ParseJSONObject(in);
		if(obj!=null)
		{			
			JSONObject result = (JSONObject) obj.get("result");
			JSONObject price = (JSONObject) result.get("price");
			JSONObject change = (JSONObject) price.get("change");
			
			coin.setPrice_high(String.valueOf(price.get("high")));
			coin.setPrice_low((double) price.get("low"));
			coin.setPrice_last((double) price.get("last"));
			coin.setVolume((double) result.get("volume"));
			coin.setPercent_change((double) change.get("percentage"));
			coin.setTimestamp(time);
			
			return coin;
		}
		return null;
	}

}
