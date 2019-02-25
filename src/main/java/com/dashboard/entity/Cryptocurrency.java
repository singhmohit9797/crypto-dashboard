package com.dashboard.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cryptocurrency {
	
	private String currency_name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String price;
	
	private Timestamp timestamp;	
	
	@ManyToOne
	@JoinColumn
	private Exchange exchange;

	public Cryptocurrency() {
		super();
	}

	public Cryptocurrency(String currency_name, Exchange exchange) {
		super();
		this.currency_name = currency_name;
		this.exchange = exchange;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getCurrency_name() {
		return currency_name;
	}

	public void setCurrency_name(String currency_name) {
		this.currency_name = currency_name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Exchange getExchange() {
		return exchange;
	}

	public void setExchange(Exchange exchange) {
		this.exchange = exchange;
	}

	@Override
	public String toString() {
		return "Cryptocurrency [currency_name=" + currency_name + ", price=" + price + ", exchange="
				+ exchange + "]";
	}

	
}
