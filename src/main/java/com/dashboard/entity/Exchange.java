package com.dashboard.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Exchange {
	
	@OneToMany(mappedBy="exchange", targetEntity = Cryptocurrency.class,
			    fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Cryptocurrency> crypto;
	
	@Column
	private String exchange_name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	public Exchange() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exchange(String exchange_name) {
		super();
		this.exchange_name = exchange_name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Cryptocurrency> getCrypto() {
		return crypto;
	}

	public void setCrypto(List<Cryptocurrency> crypto) {
		this.crypto = crypto;
	}

	public String getExchange_name() {
		return exchange_name;
	}

	public void setExchange_name(String exchange_name) {
		this.exchange_name = exchange_name;
	}

	@Override
	public String toString() {
		return "Exchange [crypto=" + crypto + ", exchange_name=" + exchange_name + "]";
	}

	
}
