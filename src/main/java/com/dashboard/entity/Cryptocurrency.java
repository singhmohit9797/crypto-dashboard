package com.dashboard.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cryptocurrency {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String currency_name;

	private String exchange_name;
	
	private double price_last;
	
	private String price_high;
	
	private double price_low;
	
	private double percent_change;
	
	private double volume;
	
	private Timestamp timestamp;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCurrency_name() {
		return currency_name;
	}

	public void setCurrency_name(String currency_name) {
		this.currency_name = currency_name;
	}

	public String getExchange_name() {
		return exchange_name;
	}

	public void setExchange_name(String exchange_name) {
		this.exchange_name = exchange_name;
	}

	public double getPrice_last() {
		return price_last;
	}

	public void setPrice_last(double price_last) {
		this.price_last = price_last;
	}

	public String getPrice_high() {
		return price_high;
	}

	public void setPrice_high(String price_high) {
		this.price_high = price_high;
	}

	public double getPrice_low() {
		return price_low;
	}

	public void setPrice_low(double price_low) {
		this.price_low = price_low;
	}

	public double getPercent_change() {
		return percent_change;
	}

	public void setPercent_change(double percent_change) {
		this.percent_change = percent_change;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Cryptocurrency(String currency_name, String exchange_name) {
		super();
		this.currency_name = currency_name;
		this.exchange_name = exchange_name;
	}

	@Override
	public String toString() {
		return "Cryptocurrency [id=" + id + ", currency_name=" + currency_name + ", exchange_name=" + exchange_name
				+ ", price_last=" + price_last + ", price_high=" + price_high + ", price_low=" + price_low
				+ ", percent_change=" + percent_change + ", volume=" + volume + ", timestamp=" + timestamp + "]";
	}
	
		
}
