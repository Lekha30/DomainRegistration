/**
 * 
 */
package com.lekha.companyA.util;

import java.util.ArrayList;
import java.util.List;

import com.lekha.companyA.Reader;
import com.lekha.companyA.bean.DomainBean;

/**
 * @author Lekha
 * 
 */
public class Calculator {
	/**
	 * 
	 * @param domainName
	 * @param year
	 * @param domainNamePriceMap
	 */
	public double calculatePrice(String domainName, String year,
			List<DomainBean> domainList, int domainType) {
		boolean indicator = false;
		double total = 0;
		Reader reader = null;
		double cost = 0.0;
		List<String> domainNameList = new ArrayList<String>();
		String part;
		// If user selects the premium domains, do the following
		if (domainType == 1) {
			if (domainName.endsWith(".com.au")) {
				int index = domainName.indexOf(".com.au");
				part = domainName.substring(index, domainName.length());

			} else {
				int index = domainName.lastIndexOf(".");
				part = domainName.substring(index, domainName.length());
			}
		} else {
			part = domainName;
		}
		for (DomainBean bean : domainList) {

			domainNameList.add(bean.getDomainName());
		}
		if (domainNameList.toString().trim().contains(part)) {
			for (DomainBean bean : domainList) {
				// Compare if the entered domain name and those in the map are
				// the same. if they are the same, calculate the cost for
				// registering the domain

				if (part.equals(bean.getDomainName().trim())) {

					indicator = true;
					cost = bean.getDomainPrice() * Integer.parseInt(year);
//					if (domainType == 2) {
//						reader = new Reader();
//						String message = reader.removeDomain(part);
//						if (message.equals("fail"))
//							indicator = false;
//					}
				}
			}
		}

		if (!indicator) {
			if (domainType == 1)

				System.out
						.println("Please enter a valid domain from the list above.");
			else
				System.out
						.println("Unable to register the domain due to technical errors!");
			total = 0;
		} else {
			System.out.println("Domain Name\t" + domainName + " registered for "
					+ year + " year(s) and the cost is:" + "");
			System.out.println(cost);
			total = total + cost;
		}
		return total;
	}

}
