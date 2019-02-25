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
public class DBService {
	
	@Autowired
	private CryptocurrencyRepo cryptoRepo;
	
	@Autowired
	private ExchangeRepo exchangeRepo;

	public void updateCryptoData(Exchange exchange) throws UnsupportedEncodingException, IOException, ParseException
	{
		
		ArrayList<Cryptocurrency> list = BinanceUtil.getBinanceCoins(exchange);
		
		exchange.setCrypto(list);
		
		exchangeRepo.save(exchange);
		
		cryptoRepo.save(exchange.getCrypto());
	}
	
	public void populateExchanges()
	{
		Exchange binance = new Exchange("binance");
		exchangeRepo.save(binance);
	}
	
}
