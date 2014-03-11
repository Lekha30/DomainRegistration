package com.lekha.companyA;

import com.lekha.companyA.util.Formatter;

/**
 * this class is used to get user list of domains and print a price list
 * according to their selected domains!
 * 
 */
public class App {
	public static void main(String[] args) {

		String message = null;
		Formatter formatter = new Formatter();
		message = formatter.displayOptions();
		if (message.equals("success")) {
			formatter.displayOptions();
		}

	}

}
