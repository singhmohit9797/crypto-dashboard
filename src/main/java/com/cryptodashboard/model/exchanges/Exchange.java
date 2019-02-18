package com.cryptodashboard.model.exchanges;

import com.cryptodashboard.model.currencies.Cryptocurrency;

public class Exchange {

	private Cryptocurrency btc;
	
	private Cryptocurrency eth;
	
	private Cryptocurrency etc;
	
	private Cryptocurrency bch;
	
	private Cryptocurrency xrp;

	public Cryptocurrency getBtc() {
		return btc;
	}

	public void setBtc(Cryptocurrency btc) {
		this.btc = btc;
	}

	public Cryptocurrency getEth() {
		return eth;
	}

	public void setEth(Cryptocurrency eth) {
		this.eth = eth;
	}

	public Cryptocurrency getEtc() {
		return etc;
	}

	public void setEtc(Cryptocurrency etc) {
		this.etc = etc;
	}

	public Cryptocurrency getBch() {
		return bch;
	}

	public void setBch(Cryptocurrency bch) {
		this.bch = bch;
	}

	public Cryptocurrency getXrp() {
		return xrp;
	}

	public void setXrp(Cryptocurrency xrp) {
		this.xrp = xrp;
	}	
}
