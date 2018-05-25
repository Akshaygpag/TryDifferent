/**
 * @author Akshay
 * @version 1.0.0
 * @since 25-May-2018
 */

package com.bridgelabz.datastructures.programs;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.algorithms.PrimeAnagramsAndPalindrome;
import com.bridgelabz.algoritms.util.AlgorithmUtil;

public class PrimeNumber2DAnagram {

    /**
     * @param args
     * 
     */
    public static void main(String[] args) {

	System.out.println("Range of numbers from 0 to 1000");

	List<Integer> allPrimeNumbers = new ArrayList<Integer>();

	for (int i = 0; i <= 1000; i++) {

	    if (AlgorithmUtil.isPrime(i)) {

		allPrimeNumbers.add(new Integer(i));

	    }

	}
	
	
	Integer[] primeInts = allPrimeNumbers.toArray(new Integer[allPrimeNumbers.size()]);
	
	
	List<Integer> allAnagrams = PrimeAnagramsAndPalindrome.findAnagramPrimes(primeInts);
	String[][] dimension2DArray = new String[2][1001 - allPrimeNumbers.size()];

	for (int i = 0; i < dimension2DArray.length - 1; i++) {

	   

		for (int j2 = 0; j2 < 1001 - allPrimeNumbers.size(); j2++) {
		    
		    if(j2==0 || j2==1) {    dimension2DArray[i][j2] = "";continue;}
		    if (!allAnagrams.contains(new Integer(j2))) {

			    dimension2DArray[i][j2] = String.valueOf(j2);

		
		    
		}else {
		    
		    dimension2DArray[i][j2] = "";
		    
		}

	    }

	}

	String[] primeStrings = new String[allAnagrams.size()];

	for (int i = 0; i < primeStrings.length; i++) {

	    primeStrings[i] = allAnagrams.get(i).toString();

	}


dimension2DArray[1] = primeStrings;


	for (int i = 0; i < dimension2DArray.length; i++) {
	    for (int j = 0; j < dimension2DArray[i].length; j++) {

		System.out.print(dimension2DArray[i][j]+"  ");
	    }

	    System.out.println();
	}
    }

}
