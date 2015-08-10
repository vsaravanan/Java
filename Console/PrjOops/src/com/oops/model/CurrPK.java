package com.oops.model;


public  class CurrPK {



	public final static <T> T checkNull(T object, String message)  {
	    if(object == null) {
	      throw new NullPointerException(message);
	    }
	    if(object.toString().length() != 3)
	    {
	    	throw new RuntimeException("Currency should be 3 chars");
	    }
	    return object;
	 }	
	
	
	public CurrPK(String frCur, String toCur) {
		super();

		this.frCur = checkNull(frCur, "From Currency can't be null");
		this.toCur = checkNull(toCur, "To Currency can't be null");

	}
	
	
	private String frCur;
	private String toCur;
	
	public String getFrCur() {
		return frCur;
	}
	public void setFrCur(String frCur) {
		this.frCur = frCur;
	}
	public String getToCur() {
		return toCur;
	}
	public void setToCur(String toCur) {
		this.toCur = toCur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (frCur + toCur).hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (! (obj instanceof CurrPK)) 
			return false;		
		CurrPK other = (CurrPK) obj;
		if (!frCur.equals(other.getFrCur()))
			return false;
		if (!toCur.equals(other.getToCur()))
			return false;
		return true;
	}
	
	
}
