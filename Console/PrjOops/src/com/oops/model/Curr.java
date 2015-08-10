package com.oops.model;

import java.math.BigDecimal;

public class Curr extends CurrPK {

	private BigDecimal BuyRt;
	private BigDecimal SellRt;
	

	
	
	public Curr(String frCur, String toCur) {
		super(frCur, toCur);
	}
	
	

	public Curr(String frCur, String toCur, BigDecimal BuyRt, BigDecimal SellRt) {
		this(frCur, toCur);
		this.BuyRt = BuyRt;
		this.SellRt = SellRt;
		System.out.println("Added from Curr: " + this.getFrCur() + ", " +
							"to Curr: " + this.getToCur() + ", " +
							"Buy Rate: " + BuyRt + ", " +
							"Sell Rate: " + SellRt 
							);		
		
	}



	public BigDecimal getBuyRt() {
		return BuyRt;
	}


	public void setBuyRt(BigDecimal BuyRt) {
		this.BuyRt = BuyRt;
	}


	public BigDecimal getSellRt() {
		return SellRt;
	}


	public void setSellRt(BigDecimal SellRt) {
		this.SellRt = SellRt;
	}


	
}
