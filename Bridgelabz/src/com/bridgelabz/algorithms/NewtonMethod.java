package com.bridgelabz.algorithms;

import com.bridgelabz.algoritms.util.AlgorithmUtil;
import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * FIND SQUARE ROOT OF A NUMBER BY USING NEWTON METHOD
 * @version 1.0.0
 * @author Akshay
 * @since 18-05-2018
 */
public class NewtonMethod {

	public static void main(String[] args) {
	    //NEWTON METHOD CALLED IN THROUGH THIS MAIN METHOD
		double number = 25;
		System.out.println("Enter the level of accuracy u require ....");
		int level = Utility.getIntergerValue();
		double resultRoot = AlgorithmUtil.sqrt(number, level);
		System.out.println("The square root of " + number + " is : " + resultRoot);// PRINTS THE SQUARE ROOT OF THE NUMBER

	}

}
