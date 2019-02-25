package com.dashboard.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtil {
	
	public static JSONArray ParseJSONListObject(InputStream inputStream) throws UnsupportedEncodingException, IOException, ParseException
	{
		JSONArray result;
		result = new JSONArray();
		JSONParser parser = new JSONParser();
		result = (JSONArray) parser.parse(new InputStreamReader(inputStream, "UTF-8"));
		return result;
	}
	
	public static JSONObject ParseJSONObject(InputStream inputStream) throws UnsupportedEncodingException, IOException, ParseException
	{
		JSONObject obj = new JSONObject();
		JSONParser parser = new JSONParser();
		obj = (JSONObject) parser.parse(new InputStreamReader(inputStream, "UTF-8"));
		return obj;
	}
	
}
