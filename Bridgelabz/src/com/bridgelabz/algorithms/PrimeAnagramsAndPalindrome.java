package com.bridgelabz.algorithms;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.DataLine;

import com.bridgelabz.algorithm.interfaces.*;

import com.bridgelabz.algoritms.util.AlgorithmUtil;
import com.bridgelabz.functionalprogramming.util.*;

/**
 * FIND PRIME NUMBERS THAT ARE ANAGRAMS AND PALINDROMES
 * 
 * @version 1.0.0
 * @author Akshay
 * @since 18-05-2018
 */
public class PrimeAnagramsAndPalindrome {

    public static void main(String[] args) {
	// THIS METHOD WILL TAKE THE USER INPUT FOR THE RANGE OF NUMBER

	System.out.println("Enter the number between range 0-1000");
	int numberRange = Utility.getIntergerValue();
	if (numberRange > 1000 || numberRange < 0) {
	    System.out.println("range from 0 to 1000");
	    return;
	}
	Integer[] allPrimeNumbers = (Integer[]) AlgorithmUtil.findPrimeNumbers(numberRange);
	List dataPalindrome = findPalindromes(allPrimeNumbers);// USER INPUTS FOR PALINDROME
	Integer[] allPrimePalindromes = (Integer[]) dataPalindrome.toArray(new Integer[dataPalindrome.size()]);

	for (Integer integer : allPrimePalindromes) {
	    System.out.println(integer);
	}

	System.out.println("---------------------");
	List dataAnagrams = findAnagramPrimes(allPrimePalindromes);// USER INPUT FOR ANAGRAMS

	//
	// switch (1) {
	//
	// case 1:
	// case 2:
	// break;
	// default:
	// System.out.println("Invalid inputs made");// INVALID OPERATION SELECTED SO
	// EXITING
	// System.exit(1);
	//
	// }
	//

    }

    public static List findAnagramPrimes(Integer[] allPrimeNumbers) {
	// FINDS THE PRIME ANAGRAMS

	List<Integer> listData = new ArrayList<Integer>();
	for (int i = 0; i < allPrimeNumbers.length - 1; i++) {
	    if (allPrimeNumbers[i] < 10) {
		continue;
	    }
	    for (int j = i + 1; j < allPrimeNumbers.length; j++) {

		String result = AlgorithmUtil.isAnagram(String.valueOf(allPrimeNumbers[i]),
			String.valueOf(allPrimeNumbers[j]));
		if (result.equalsIgnoreCase(UtilInterface.ISANAGRAM)) {
		    // System.out.println(allPrimeNumbers[i] + " and " + allPrimeNumbers[j] + " are
		    // anagrams");
		    if (!listData.contains(allPrimeNumbers[i])) {
			listData.add(allPrimeNumbers[i]);

		    }

		    if (!listData.contains(allPrimeNumbers[i])) {

			listData.add(allPrimeNumbers[j]);
		    }

		}

	    }
	}
	return listData;
    }

    public static List findPalindromes(Integer[] allPrimeNumbers) {
	// FINDS THE PRIME PALINDROMES
	List<Integer> dataList = new ArrayList<Integer>();
	for (int i = 0; i < allPrimeNumbers.length; i++) {
	    if (allPrimeNumbers[i] < 10) {
		continue;
	    }
	    if (AlgorithmUtil.isIntPalindrome(allPrimeNumbers[i])) {
		System.out.println(allPrimeNumbers[i] + " is a palindrome ");

		dataList.add(allPrimeNumbers[i]);
	    }
	}

	return dataList;
    }

}
