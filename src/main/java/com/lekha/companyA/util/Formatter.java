package com.lekha.companyA.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.lekha.companyA.Reader;
import com.lekha.companyA.bean.DomainBean;

public class Formatter {
	/**
	 * 
	 * @return
	 */
	public String displayOptions() {

		int domainType = 0;
		boolean flag = false;
		List<DomainBean> domainNamePriceList = new ArrayList<DomainBean>();
		String message = null;

		System.out
				.println("*******************Welcome to Company A*******************");
		System.out
				.println("We help you get registered with a domain name of your choice"
						+ "Please choose the domain type you need to get registered with");
		System.out.println("1.Domain Na1me in Multiple Zones\n"
				+ "2. Premium Domain Names");

		try {
			flag = false;
			BufferedReader bufferRead = new BufferedReader(
					new InputStreamReader(System.in));
			domainType = Integer.parseInt(bufferRead.readLine());
			Reader reader = new Reader();
			domainNamePriceList = reader.readDomainFile(domainType);

			if (!domainNamePriceList.isEmpty()
					&& domainNamePriceList.size() > 0) {
				System.out.println("Domain Details\t\t\t | Cost/year\t\t\t");
				System.out
						.println("--------------------------------------------");
				for (int i = 0; i < domainNamePriceList.size(); i++) {
					String domainName = domainNamePriceList.get(i)
							.getDomainName();
					double price = domainNamePriceList.get(i).getDomainPrice();

					System.out.println(domainName + "\t\t\t" + "| " + price
							+ "\t\t\t");
				}
			} else {
				System.out.println("Sorry! Unable to get the list of domains.");
				flag = true;
			}
			if (!flag) {
				message = registerWebsites(domainType, domainNamePriceList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	}

	/**
	 * 
	 * @param domainType
	 * @param domainNamePriceList
	 */
	public String registerWebsites(int domainType,
			List<DomainBean> domainNamePriceList) {
		double total = 0;
		String[] domainNameArray = null;
		String[] year = null;
		Calculator calc = null;
		try {
			System.out.println("How many websites would you like to register?");
			BufferedReader bufferReadNo = new BufferedReader(
					new InputStreamReader(System.in));
			int noOfWebsites = Integer.parseInt(bufferReadNo.readLine());
			domainNameArray = new String[10];
			year = new String[10];
			for (int i = 0; i < noOfWebsites; i++) {
				System.out.println("Please enter  domain name " + (i + 1));
				BufferedReader bufferRead1 = new BufferedReader(
						new InputStreamReader(System.in));
				domainNameArray[i] = bufferRead1.readLine().trim();
				System.out.println("Please enter number of years for domain:");
				BufferedReader bufferRead2 = new BufferedReader(
						new InputStreamReader(System.in));

				year[i] = bufferRead2.readLine();

				calc = new Calculator();
				total = total
						+ calc.calculatePrice(domainNameArray[i], year[i],
								domainNamePriceList, domainType);
			}
			if (total == 0)
				return "fail";
			System.out.println("Total cost:" + total);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
}
