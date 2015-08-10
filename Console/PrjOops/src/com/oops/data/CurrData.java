package com.oops.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;

import com.oops.model.Curr;
import com.oops.model.CurrPK;
import com.oops.validate.Validators;

public class CurrData extends HashMap<CurrPK, Curr>implements Serializable {
	private static final long serialVersionUID = 1L;

	private CurrData() {
	}

	private static class CurrDataHolder {
		public static final CurrData INSTANCE = new CurrData();
	}

	public static CurrData getInstance() {
		return CurrDataHolder.INSTANCE;
	}

	protected Object readResolve() {
		return getInstance();
	}

	public void add(String frCur, String toCur, String BuyRt, String SellRt) {


		
		if (! Validators.validateCurrency("frCur", frCur))
			return;
		if (! Validators.validateCurrency("toCur", toCur))
			return;
		if (! Validators.validateCurrRate("BuyRt", BuyRt))
			return;
		if (! Validators.validateCurrRate("SellRt", SellRt))
			return;

		frCur = frCur.toUpperCase();
		toCur = toCur.toUpperCase();


		try 
		{
			
			
			Curr cr = new Curr(frCur, toCur, 
					new BigDecimal(BuyRt), new BigDecimal(SellRt));
			this.put((CurrPK) cr, cr);
			
		}
		catch (Exception e)
		{
			System.out.println("Unable to add currency record due to invalid input data");
		}


	}

	public Curr getCurr(CurrPK cp) {
		return this.get(cp);
	}

}
