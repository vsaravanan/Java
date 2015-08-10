package com.oops.bll;

import java.math.BigDecimal;


import com.oops.data.CurrData;
import com.oops.model.Curr;
import com.oops.model.CurrPK;
import com.oops.validate.Validators;




public class CurrConv extends Curr {
	
	private BigDecimal frUnits;
	private BigDecimal toUnits;

	public CurrConv(String frCur, String toCur) {
		super(frCur, toCur);
	}	


	private static CurrConv Refresh(String frCur, String toCur) {
		
		// setting CurrPK

		CurrConv cc = new CurrConv(frCur, toCur);
		CurrData cd = CurrData.getInstance();
		
		// setting Curr
		Curr cr = cd.getCurr((CurrPK) cc); 
		cc.setBuyRt(cr.getBuyRt());
		cc.setSellRt(cr.getSellRt());
		
		// return CurrConv
		return cc;
		
	}
	
	public static CurrConv sell(String frCur, String toCur, String frUnits) {


		
		if (! Validators.validateCurrency("frCur", frCur))
			return null;
		if (! Validators.validateCurrency("toCur", toCur))
			return null;
		if (! Validators.validateCurrRate("frUnits", frUnits))
			return null;
		
		frCur = frCur.toUpperCase();
		toCur = toCur.toUpperCase();
		
		CurrConv cc = Refresh(frCur, toCur);

		
		
		
		cc.frUnits = new BigDecimal(frUnits);

		cc.toUnits = cc.frUnits.multiply(cc.getBuyRt());
		cc.toUnits = cc.toUnits.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		System.out.println("Receive " + 
				cc.getFrUnits() + " " + cc.getFrCur() + ", " +
				"my buy Rate: " + cc.getBuyRt() + ", " +
				"SELL: " +  cc.getToUnits() + " " + cc.getToCur()  + " give customer"
				);	
		return cc;

	}

	public static CurrConv buy(String frCur, String toCur, String frUnits) {
		CurrConv cc = Refresh(frCur, toCur);
		cc.frUnits = new BigDecimal(frUnits);

		cc.toUnits = cc.frUnits.divide(cc.getSellRt(),BigDecimal.ROUND_HALF_UP);
		cc.toUnits = cc.toUnits.setScale(2, BigDecimal.ROUND_HALF_UP);
		

		System.out.println(
		"Receive: " +  cc.getFrUnits() + " " + cc.getToCur() + ", " +
		"my sell Rate: " + cc.getSellRt() + ", " +
		"Customer is BUYING: give customer "+  cc.getToUnits() + " " +  cc.getFrCur() 	
		);	


		return cc;

	}
	
	public BigDecimal getFrUnits() {
		return frUnits;
	}

	public void setFrUnits(BigDecimal frUnits) {
		this.frUnits = frUnits;
	}

	public BigDecimal getToUnits() {
		return toUnits;
	}

	public void setToUnits(BigDecimal toUnits) {
		this.toUnits = toUnits;
	}
}
