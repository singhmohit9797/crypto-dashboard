package com.dashboard.utility;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;



public class HttpRequest {

	    public static InputStream SendGetRequest(String url)  {
	        HttpURLConnection connection = InitiateConnection(url, "GET");

	        if(connection == null)
	            return null;

	        try {
	            connection.connect();
	            return connection.getInputStream();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return null;
	    }

	    private static HttpURLConnection InitiateConnection(String url, String requestMethod) {
	        try {
	            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	            connection.setConnectTimeout(5000);
	            connection.setRequestMethod(requestMethod);

	            if(requestMethod.equals("POST"))
	            {
	                connection.setRequestProperty("Content-Type", "application/json");
	                connection.setDoOutput(true);
	            }
	            return connection;

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return null;
	    }
	
}
