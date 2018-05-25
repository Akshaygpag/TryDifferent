package com.bridgelabz.datastructures.programs;

import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.bridgelabz.algorithm.impl.OrderedListImpl;
import com.bridgelabz.algorithm.interfaces.List;
import com.bridgelabz.algorithm.interfaces.OrderedList;
import com.bridgelabz.functionalprogramming.util.Utility;

public class OrderedListMain {
    private static final String FILE_PATH = "/home/bridgeit/fileHolder/OrderList.txt";// GET FILE PATH

    public static void main(String[] args) {
	// code used for testing
	OrderedList list=new OrderedListImpl();

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
		if(file.length()!=0) {
		    
		    String[] data = sb.toString().split(",");

			for (String insertData : data) {
			    Node n = new Node();
			     n.setInfo(Integer.parseInt(insertData));
//			    n.setInfo(insertData.trim());
			    list.add(n);

			}

		    
		}
		System.out.println("Enter the number to be searched");

	Node n=Utility.getNodeValue();
		System.out.println("File size before deleting is  " + list.size());
		if (list.search(n)) {

		    System.out.println("key found ");
		    System.out.println("deleting.....");

		    list.remove(n);

		    System.out.println("deletion completed .");
		    System.out.println("File items  after  deleting is  " + list.size());

		} else {

		    list.add(n);
		    System.out.println("Element is added.");
		}

		file.delete();
		file.createNewFile();

		FileWriter fw = new FileWriter(file);
		StringBuffer listContents = new StringBuffer();
		System.out.println("--------------------");
		
		for (int i = 0; i < list.size(); i++) {
		    int last=list.size()-1;
		    String dataListSingle = list.pop(0).getInfo().toString();
		    listContents.append(dataListSingle+",");
		  System.out.println("Popping from list : "+dataListSingle);
		  
		    
		    
		    i--;

		}

		fw.write(listContents.toString().substring(0,listContents.toString().length()-1));
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

    

//while (true) { 
//
//    System.out.println();
//    System.out.println();
//    System.out.println("---------------------------------");
//    System.out.println();
//    System.out.println("1.Create an empty list");
//    System.out.println("2.Add element to list");
//    System.out.println("3.Remove element from list");
//    System.out.println("4.Search element from the list");
//    System.out.println("5.Check if the list is empty");
//    System.out.println("6.Check the number of elements present in the list");
//    System.out.println("7.Add element in the end of the list");
//    System.out.println("8.Insert element at the specified position(starts from    0)");
//    System.out.println("9.Pop element from the list");
//    System.out.println("10.Pop specified element from the list by position(starts    from 0) ");
//    System.out.println("11.Get the index of element from the list (Always will    give the first match)");
//    System.out.println("press anything ele to exit");
//    int choice = Utility.getIntergerValue();
//    Node item = null;
//    Node n = null;
//    int position = -1;
//    switch (choice) {
//    case 1:
//	list = list.list();
//	break;
//    case 2:
//	System.out.println("Enter the element");
//	item = Utility.getNodeValue();
//	list.add(item);
//	break;
//    case 3:
//	System.out.println("Enter the element");
//	item = Utility.getNodeValue();
//	list.remove(item);
//	break;
//    case 4:
//	System.out.println("Enter the element");
//	item = Utility.getNodeValue();
//	System.out.println("Element found : " + list.search(item));
//	break;
//    case 5:
//	System.out.println("List is empty : " + list.isEmpty());
//	break;
//    case 6:
//	System.out.println("Number of elements in the list : " + list.size());
//	break;
//    case 7:
//	System.out.println("Enter the element");
//	item = Utility.getNodeValue();
//	// list.append(item);
//	break;
//    // case 8:
//    // System.out.println("ente rthe element whose index is to be found..");
//    // item = Utility.getNodeValue();
//    // int myIndex = list.index(item);
//    // System.out.println("Element forund at index " + myIndex);
//
//    case 9:
//	if ((n = list.pop()) != null) {
//
//	    System.out.println("Element is : " + n.getInfo());
//
//	    break;
//	}
//	System.out.println("List is empty");
//	break;
//    case 10:
//	System.out.println("Enter the posiiton (0....n)");
//	position = Utility.getIntergerValue();
//	if ((n = list.pop(position)) != null) {
//
//	    System.out.println("Element is : " + n.getInfo());
//
//	    break;
//	}
//	break;
//    case 11:
//	System.out.println("Enter the element");
//	item = Utility.getNodeValue();
//	int index = list.index(item);
//	String result = (index != -1) ? "The element is at : " + index : "Element not   found";
//	System.out.println(result);
//	break;
//    default:
//
//	list.printElements();
//
//    }
//
//}