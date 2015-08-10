package com.oops.validate;

public class Validators {

	public final static boolean validateCurrRate(String currName, String currValue) {
		try {
			Double t = Double.valueOf(currValue);
			return true;
		}

		catch (Exception e) {
			System.out.println(currName + " contains invalid currency data " + currValue);
			return false;
		}

	}
	
	public final static <T> boolean validateString(String currName, T object) {
		if (object == null || object.toString().length() == 0) {
			System.out.println(currName + " is null or empty. invalid data ");
			return false;
		}
		return true;
	}	
	

	public final static <T> boolean validateCurrency(String currName, T object) {
		if (! validateString(currName, object)) return false;
		if (! object.toString().matches("[a-zA-Z]{3}"))
		{
			System.out.println(currName + " is a currency. It should be 3 chars. Your input value : " + object.toString());
			return false;
		}
		return true;
	}
	

}
