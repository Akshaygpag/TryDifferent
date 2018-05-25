/**
 * @author Akshay
 * @version 1.0.0
 * @since 24-May-2018
 */

package com.bridgelabz.datastructures.programs;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.bridgelabz.algorithm.impl.OrderedListImpl;
import com.bridgelabz.algorithm.interfaces.OrderedList;
import com.bridgelabz.functionalprogramming.util.Utility;

public class HashingClassFindNumber {
    private static final String FILE_PATH = "/home/bridgeit/fileHolder/HashingList.txt";// GET FILE PATH

    /**
     * @param args
     * 
     */
    public static void main(String[] args) {
	// THIS METHOD WILL READ NUMBERS FROM FILES AND TAKE USER VALUE

	OrderedList[] chain = new OrderedListImpl[11];

	for (int s = 0; s < chain.length; s++) {

	    chain[s] = new OrderedListImpl();

	}

	File file = new File(FILE_PATH);
	FileReader read = null;
	if (!file.exists()) {
	    System.out.println("File resource could not be found Error :404");
	    return;

	}
	try {
	    read = new FileReader(file);
	    int c = -1;

	    StringBuffer sb = new StringBuffer();
	    try {
		while ((c = read.read()) != -1) {

		    sb.append((char) c);

		}

		System.out.println("File contents starts.......");
		System.out.println(sb.toString());
		System.out.println("File contents ends......");
		if (file.length() != 0) {

		    String[] data = sb.toString().split(",");

		    for (String insertData : data) {
			Node n = new Node();
			n.setInfo(Integer.parseInt(insertData.trim()));
			// n.setInfo(insertData.trim());

			Integer remainder = (Integer) n.getInfo() % 11;
			chain[remainder].add(n);

		    }

		}
		System.out.println("Enter the number to be searched");

		Node n = Utility.getNodeValue();
		Integer remainder = (Integer) n.getInfo() % 11;

		if (chain[remainder].search(n)) {

		    System.out.println("key found ");
		    System.out.println("deleting.....");

		    chain[remainder].remove(n);

		    System.out.println("deletion completed .");
		    // System.out.println("File items after deleting is " + list.size());

		} else {

		    chain[remainder].add(n);
		    System.out.println("Element is added.");
		}

		file.delete();
		file.createNewFile();

		FileWriter fw = new FileWriter(file);
		StringBuffer listContents = new StringBuffer();
		System.out.println("--------------------");

		for (int i = 0; i < chain.length; i++) {

		    /*
		     * for(int j=0;j<chain[i].) {} int last = list.size() - 1; String dataListSingle
		     * = list.pop(0).getInfo().toString(); listContents.append(dataListSingle +
		     * ","); System.out.println("Popping from list : " + dataListSingle);
		     * 
		     * i--;
		     */

		    for (int j = 0; j < chain[i].size(); j++) {
	
			String dataListSingle = chain[i].pop(0).getInfo().toString();
			listContents.append(dataListSingle + ",");
			System.out.println("Popping from list : " + dataListSingle);

			j--;

		    }

		}

		fw.write(listContents.toString().substring(0, listContents.toString().length() - 1));
		fw.flush();

		System.out.println("Writing to file completed");

	    }

	    catch (Exception e) {
		System.out.println("cannot do the file read and write operations " + e.getMessage());

		e.printStackTrace();
	    }
	} catch (Exception e) {

	    System.out.println("cannot do the file read and write operations " + e.getMessage());
	    e.printStackTrace();
	}

    }

}
