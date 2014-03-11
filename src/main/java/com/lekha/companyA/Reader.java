/**
 * 
 */
package com.lekha.companyA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.lekha.companyA.bean.DomainBean;

/**
 * @author Lekha
 * 
 */
public class Reader {

	public Reader() {

	}

	public List<DomainBean> readDomainFile(int domainType) {
		List<DomainBean> domainList = new ArrayList<DomainBean>();
		DomainBean domainBean;
		FileReader fReader = null;
		BufferedReader bufferReader = null;
		try {
			if (domainType == 1) {
				fReader = new FileReader("resources/inputReader.txt");
			} else if (domainType == 2) {
				fReader = new FileReader("resources/inputReader2.txt");
			} else {
				return null;
			}
			bufferReader = new BufferedReader(fReader);

			// Variable to hold the one line data
			String line;

			// Read file line by line and place the values via DomainBean object
			// to a list

			while ((line = bufferReader.readLine()) != null) {
				domainBean = new DomainBean();
				int index = line.indexOf(",");
				if (index > 0) {
					String domain = line.substring(0, index);
					domainBean.setDomainName(domain);
					String price = line.substring(index + 1, line.length());
					domainBean.setDomainPrice(Double.parseDouble(price));
					domainList.add(domainBean);
				}
			}

			// Iterator iterator = (Iterator) domainList.listIterator();
			// while (iterator.hasNext()) {
			// System.out.println(iterator.next().toString());
			// System.out.println();
			// }

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return domainList;

	}

	/**
	 * 
	 * @param toRemove
	 * @return
	 */
	public String removeDomain(String toRemove) {
		FileReader fReader = null;
		BufferedReader bufferReader = null;
		FileWriter fWriter = null;
		BufferedWriter bufferedWriter = null;
		File orgFile = new File("resources/inputReader2.txt");
		File tempFile = new File("resources/temp.txt");
		try {
			fReader = new FileReader(orgFile);
			fWriter = new FileWriter(tempFile);

			bufferReader = new BufferedReader(fReader);
			bufferedWriter = new BufferedWriter(fWriter);
			String currentLine;
			// Read from the original file and write to the temp file
			// unless content matches data to be removed
			while ((currentLine = bufferReader.readLine()) != null) {
				String trimmedLine = currentLine.substring(0,
						currentLine.indexOf(",")).trim();

				if (trimmedLine.equals(toRemove))
					continue;
				bufferedWriter.write(trimmedLine);
				bufferedWriter.flush();

			}
			// Close the instances
			bufferedWriter.close();
			fWriter.close();
			bufferReader.close();
			fReader.close();
			bufferedWriter = null;
			bufferReader = null;
			fReader = null;
			fWriter = null;

//			// Delete the original file
//			if (!orgFile.delete()) {
//				System.out.println("Could not delete file");
//				return "fail";
//			}
//
//			// Rename the new file to the filename the original file had.
//			if (!tempFile.renameTo(orgFile)) {
//				System.out.println("Could not rename file");
//				return "fail";
//			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}
}
