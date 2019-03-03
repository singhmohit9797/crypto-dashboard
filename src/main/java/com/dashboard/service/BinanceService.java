package com.dashboard.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.entity.Cryptocurrency;
import com.dashboard.repository.CryptocurrencyRepo;
import com.dashboard.utility.CryptocurrencyUtil;

@Service
@Transactional
public class BinanceService {
	
	@Autowired
	private CryptocurrencyRepo cryptoRepo;

	public ArrayList<Cryptocurrency> updateCryptoData() throws UnsupportedEncodingException, IOException, ParseException
	{
		ArrayList<Cryptocurrency> list = new ArrayList<>();
		
		Cryptocurrency btc = CryptocurrencyUtil.getCoin("binance", "btcusdt");
		Cryptocurrency eth = CryptocurrencyUtil.getCoin("binance", "ethusdt");
		Cryptocurrency ltc = CryptocurrencyUtil.getCoin("binance", "ltcusdt");
		
		list.add(btc);
		list.add(eth);
		list.add(ltc);
		
		cryptoRepo.save(btc);
		cryptoRepo.save(eth);
		cryptoRepo.save(ltc);
		
		return list;
	}
	
}
