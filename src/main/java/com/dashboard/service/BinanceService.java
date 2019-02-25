package com.dashboard.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.entity.Cryptocurrency;
import com.dashboard.entity.Exchange;
import com.dashboard.repository.CryptocurrencyRepo;
import com.dashboard.repository.ExchangeRepo;
import com.dashboard.utility.BinanceUtil;

@Service
@Transactional
public class BinanceService {
	
	@Autowired
	ExchangeRepo exchangeRepo;
	
	@Autowired
	CryptocurrencyRepo cryptoRepo;
	
	private Exchange getDataFromAPI() throws UnsupportedEncodingException, IOException, ParseException
	{
		Exchange binance = new Exchange("binance");
		
		ArrayList<Cryptocurrency> list = BinanceUtil.getBinanceCoins(binance);
		
		binance.setCrypto(list);
		
		return binance;
	}

	public Exchange getData() throws UnsupportedEncodingException, IOException, ParseException {
		// TODO Auto-generated method stub
		return getDataFromAPI();
	}

	public void saveDataToDB(Exchange exchange) {
		// TODO Auto-generated method stub
		exchangeRepo.save(exchange);
		cryptoRepo.save(exchange.getCrypto());
	}

}
