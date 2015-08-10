package com.oops.test;


import com.oops.bll.CurrConv;
import com.oops.data.CurrData;


public class CurrTest {

	public static void main(String[] args) {

		CurrData cd = CurrData.getInstance();

		//cd.add("USD","SGD","1.3770","1.3920");
		
		cd.add("USD","SGD","1.3770","1.3920");

		CurrConv.sell("USD","SGD","1000.0");
		CurrConv.buy("USD","SGD","137.7");
		
		cd.add("USD","SGD","1.4","1.5");

		

		CurrConv.sell("USD","SGD","100");
		CurrConv.buy("USD","SGD","137.7");
		
	}
	

}
