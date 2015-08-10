package com.oops.test;

import org.testng.annotations.Test;

import com.oops.data.CurrData;

public class CurrDataTest {

	@Test(expectedExceptions = NullPointerException.class)
	public void TestNullCheck() 
	{
		CurrData cd = CurrData.getInstance();
		cd.add(null,"SGD",null,null);
	}

	@Test(expectedExceptions = RuntimeException.class)
	public void TestBlankCheck() 
	{
		CurrData cd = CurrData.getInstance();
		cd.add("USD","",null,null);
	}	
		
}
