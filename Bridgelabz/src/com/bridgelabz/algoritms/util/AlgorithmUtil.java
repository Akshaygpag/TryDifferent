package com.bridgelabz.algoritms.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.bridgelabz.algorithm.interfaces.UtilInterface;

/**
 * THIS IS THE UTILITY CLASS FOR ALGORITHMS
 * 
 * @author Akshay
 * @since 18-05-2018
 * @version 1.0.0
 */

public class AlgorithmUtil {

    public static String isAnagram(String first, String second) {

	if (first.length() != second.length()) {
	    return UtilInterface.ISNOTANAGRAM;
	}
	// REPLACE THIS SORT WITH MERGE SORT LATER
	String firstArray[] = stringToStringArray(first.toLowerCase());
	String secondArray[] = stringToStringArray(second.toLowerCase());
	firstArray = bubbleSortArrays(firstArray);
	secondArray = bubbleSortArrays(secondArray);
	if (compareStringArrays(firstArray, secondArray)) {
	    return UtilInterface.ISANAGRAM;
	}
	return UtilInterface.ISNOTANAGRAM;
    }

    /**
     * 
     * @param firstArray
     * @param secondArray
     * @return boolean
     *
     */
    private static <T extends Comparable<T>> boolean compareStringArrays(T[] firstArray, T[] secondArray) {
	// THIS METHOD WILL COMPARE TO MAKE SURE THAT BOTH THE ARRAYS ARE SAME

	for (int i = 0; i < firstArray.length && i < secondArray.length; i++) {
	    if ((firstArray[i].compareTo(secondArray[i])) != 0) {
		return false;
	    }

	}

	return true;
    }

    /*
     * public static String[] bubbleSortString(String[] value) { // BUBBLE SORT for
     * (int i = 0; i < value.length - 1; i++) {// NO OF ITERATIONS REQUIRED FOR
     * SORTING
     * 
     * for (int j = 0; j < value.length - 1 - i; j++) {// COMPARE WITH THE NEXT
     * ELEMENT IF GREATER THEN SWAP ELSE // CONTINUE
     * 
     * if ((value[j].toLowerCase().compareTo(value[j + 1].toLowerCase())) > 0) {
     * swapStrings(j, j + 1, value);// CALL TO SWAP METHOD
     * 
     * }
     * 
     * }
     * 
     * } return value; }
     */

    public static <T extends Comparable<T>> T[] bubbleSortArrays(T[] value) {
	// BUBBLE SORT
	for (int i = 0; i < value.length - 1; i++) {// NO OF ITERATIONS REQUIRED FOR SORTING

	    for (int j = 0; j < value.length - 1 - i; j++) {// COMPARE WITH THE NEXT ELEMENT IF GREATER THEN SWAP ELSE
							    // CONTINUE

		if ((value[j].compareTo(value[j + 1])) > 0) {
		    swap(j, j + 1, value);// CALL TO SWAP METHOD

		}

	    }

	}
	return value;
    }

    public static <T extends Comparable<T>> void swap(Integer i, Integer j, T[] value) {
	// THIS METHOD IS USED TO SWAP THE VARIABLES
	T temp = value[i];
	value[i] = value[j];
	value[j] = temp;

    }

    public static <T extends Comparable<T>> T[] stringToStringArray(String first) {

	List<String> stringList = new ArrayList<String>();

	char[] firstCharArray = first.toCharArray();

	for (char eachChar : firstCharArray) {

	    stringList.add(String.valueOf(eachChar));

	}
	String[] stringArrayToSort = new String[first.length()];
	return (T[]) stringList.toArray(stringArrayToSort);

    }

    public static Integer[] findPrimeNumbers(Integer number) {
	List<Integer> allPrimesInRange = new ArrayList<Integer>();
	for (int i = 2; i <= number; i++) {
	    if (isPrime(i)) {

		allPrimesInRange.add(i);

	    }
	}
	return allPrimesInRange.toArray(new Integer[allPrimesInRange.size()]);
    }

    public static boolean isPrime(Integer number) {
	boolean flag = false;
	if(number==1 || number==0) {return false;}
	if(number==3 || number==2) {return true;}
	
	for (Integer i = 2; i*i<= number ; i++) {
	  
	    if( number!=i) {
		
		
		if (number % i == 0 ) {
		    return false;
		} else {
		    flag = true;
		}
		
		
	    }

	}
	if (flag) {

	    return true;

	}
	return false;

    }

    public static boolean isIntPalindrome(Integer number) {
	Integer n = number;
	Integer reverseValue = 0;
	while (n > 0) {
	    reverseValue = reverseValue * 10 + n % 10;
	    n = n / 10;
	}
	if ((number - reverseValue) == 0) {
	    return true;
	}
	return false;
    }

    /*
     * public static int binarySearchString(String[] sortedData, String key) {
     * 
     * int low = 0; int high = sortedData.length - 1; int mid = (high + low) / 2;
     * 
     * while (low <= high) {
     * 
     * if (sortedData[mid].equals(key)) {
     * 
     * return mid; } if (key.compareTo(sortedData[mid]) > 0) { // UPPER HALF OF THE
     * ARRAY low = mid + 1; mid = (high + low) / 2;
     * 
     * } else { // LOWER HALF OF THE ARRAY high = mid - 1; mid = (low + high) / 2;
     * 
     * }
     * 
     * } System.out.println(key + " not found in the array "); return -1;
     * 
     * }
     */

    public static <T extends Comparable<T>> int binarySearch(T[] sortedData, T key) {

	Integer low = 0;
	Integer high = sortedData.length - 1;
	Integer mid = (high + low) / 2;

	while (low <= high) {

	    if ((sortedData[mid].compareTo(key)) == 0) {

		return mid;
	    }
	    if (key.compareTo(sortedData[mid]) > 0) {
		// UPPER HALF OF THE ARRAY
		low = mid + 1;
		mid = (high + low) / 2;

	    } else {
		// LOWER HALF OF THE ARRAY
		high = mid - 1;
		mid = (low + high) / 2;

	    }

	}
	System.out.println(key + " not found in the array ");
	return -1;

    }

    /*
     * public static int binarySearchInt(int[] sortedData, int key) {
     * 
     * int low = 0; int high = sortedData.length - 1; int mid = (high + low) / 2;
     * 
     * while (low <= high) {
     * 
     * if (sortedData[mid] == (key)) {
     * System.out.println("Element found at position " + mid); return mid; } if (key
     * > sortedData[mid]) { // UPPER HALF OF THE ARRAY low = mid + 1; mid = (high +
     * low) / 2; } else { // LOWER HALF OF THE ARRAY high = mid - 1; mid = (low +
     * high) / 2;
     * 
     * }
     * 
     * } System.out.println(key + " not found in the array "); return -1; }
     */
    /*
     * public static int[] bubbleSortInt(int[] value) { // BUBBLE SORT for (int i =
     * 0; i < value.length - 1; i++) {// NO OF ITERATIONS REQUIRED FOR SORTING
     * 
     * for (int j = 0; j < value.length - i - 1; j++) {// COMPARE WITH THE NEXT
     * ELEMENT IF GREATER THEN SWAP ELSE // CONTINUE
     * 
     * if (value[j] > value[j + 1]) { swapInt(j + 1, j, value);// CALL TO SWAP
     * METHOD
     * 
     * }
     * 
     * }
     * 
     * } return value; }
     */

    /*
     * public static void swapInt(int i, int j, int[] value) { // SWAP THE INT
     * VALUES IN AN ARRAY int temp = value[i]; value[i] = value[j]; value[j] = temp;
     * 
     * }
     */

    public static <T extends Comparable<T>> T[] insertionSort(T[] a) {

	for (int i = 0; i < a.length - 1; i++) {

	    int j = i + 1;

	    if ((a[i].compareTo(a[j])) > 0) {

		swapTillFits(a, i, j);
	    }

	}
	return a;

    }

    private static <T extends Comparable<T>> void swapTillFits(T[] a, int i, int j) {

	while (j != 0) {
	    if ((a[i].compareTo(a[j])) > 0) {

		swap(i, j, a);
		i--;
		j--;

	    } else {
		break;
	    }

	}

    }

    /*
     * public static String[] insertionSortString(String[] a) {
     * 
     * for (int i = 0; i < a.length - 1; i++) {
     * 
     * int j = i + 1; // System.out.println("i : " + i + " j : " + j); if
     * (a[i].toLowerCase().compareTo(a[j].toLowerCase()) > 0) {
     * 
     * swapStringValuesTillFits(a, i, j); //
     * System.out.println("Value after swap i :" + i); }
     * 
     * } return a;
     * 
     * }
     */

    /**
     * @param a
     * @param i
     * @param j
     * 
     */
    /*
    */

    public static int dayOfWeek(int d, int m, int y) {
	// System.out.println(d + " " + m + " " + y);
	int y0 = y - ((14 - m) / 12);
	int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
	int m0 = m + 12 * ((14 - m) / 12) - 2;
	int d0 = (d + x + 31 * m0 / 12) % 7;
	//
	// System.out.println("The day of the week is : " + (int)d0);

	return (int) d0;

    }

    public static void temperaturConversion(char format, double temp) {

	if (format == 'F' || format == 'f') {
	    System.out.println(temp * (9 / 5) + 32 + " F");
	} else if (format == 'c' || format == 'C') {
	    System.out.println((temp - 32) * (5 / 9) + " C");
	} else {
	    System.out.println("Invalid format of temp found");
	}

    }

    public static void monthlyPayment(double p, double t, double r) {
	double n = 12 * t;
	double rate = r / (12 * 100);
	System.out.println("no of months " + n);

	System.out.println("rate charged per month " + rate);

	double denom = (1 - Math.pow((1 + rate), (n * -1)));
	System.out.println(denom);
	double res = (p * rate / denom);
	DecimalFormat decimalFormat = new DecimalFormat();

	decimalFormat.setMaximumFractionDigits(2);

	System.out.println(decimalFormat.format(res) + " " + decimalFormat.getCurrency());

    }

    public static String toBinary(int decimal) {
	// THIS METHOD WILL TAKE THE DECIMAL VALUE AND DIVIDE IT TILL 0 OR 1
	StringBuffer binaryData = new StringBuffer();
	while (decimal > 0) {

	    int remainder = decimal % 2;
	    binaryData.append(remainder);
	    decimal = decimal / 2;

	}
	while (binaryData.length() != 32) {

	    binaryData.append("0");

	}
	binaryData.setLength(32);

	return binaryData.reverse().toString();
    }

    public static double sqrt(double number, int level) {
	// THIS METHOD WILL USE NEWTON METHOD FOR GENERATING THE SQUARE ROOT FOR THE
	// NUMBER

	double t = number;
	for (int i = 0; i < level; i++) {
	    // THIS LOOP FOR THE LEVEL FOR ACCURACY THAT IS REQUIRED

	    if (Math.abs(t - number / t) > Math.pow(Math.E, -15)) {

		t = (t + (number / t)) / 2;

	    }

	}

	return t;
    }

    public static <T extends Comparable<T>> void mergeSort(T[] a) {
	// System.out.println("Starting the sorting using merge sort");
	System.out.println("Entering the mergeSort method");
	mergeDivide(a, 0, a.length - 1);

    }

    public static <T extends Comparable<T>> void mergeDivide(T[] a, int low, int high) {
	// THIS METHOD WILL TAKE THE ARRAY AND RECURSSIVE CALL THE MERGE METHOD TO SORT
	// THE DATA GIVE
	if (low < high) {

	    int mid = (high + low) / 2;

	    mergeDivide(a, low, mid);
	    mergeDivide(a, mid + 1, high);

	    mergeBack(a, low, high, mid);
	    // System.out.println("Finished merge");
	}

    }

    /**
     * 
     * @param a
     * @param low
     * @param high
     * @param temp
     * @param mid
     *
     */
    public static <T extends Comparable<T>> void mergeBack(T[] a, int low, int high, int mid) {
	// MERGE THE ARRAYS BACK TOGETHER
	int leftStart = low;
	int rightStart = mid + 1;
	int firstSize, secondSize;
	firstSize = rightStart - leftStart;
	secondSize = high - rightStart + 1;
	if (high - low == 1) {

	    if ((a[low].compareTo(a[high])) > 0) {
		swapTillFits(a, low, high);
	    }
	    return;

	}

	int i = 0, j = 0;

	while (i < a.length && j < a.length && leftStart <= mid && rightStart <= high) {
	    if ((a[leftStart].compareTo(a[rightStart]) < 0)) {

		leftStart++;
		i++;
	    } else {
		swap(leftStart, rightStart, a);
		leftStart++;
		j++;

	    }

	}
	/*
	 * while (i < temp1.getData().length) { a[i2] = (T) temp1.getData()[i]; i2++;
	 * i++;
	 * 
	 * } while (i < temp1.getData().length) { a[i2] = (T) temp2.getData()[j]; i2++;
	 * j++;
	 * 
	 * }
	 */
    }

    /**
     * @param dataUsed
     * @param key
     * @return
     * 
     */
    public static int binarySearchInInt(char[] dataUsed, String key) {
	//

	return 0;
    }

    /*
     * public static void mergeSort(int[] a) { //
     * System.out.println("Starting the sorting using merge sort");
     * 
     * mergeDivide(a, 0, a.length - 1, new int[a.length]);
     * 
     * }
     * 
     * public static void mergeDivide(int[] a, int low, int high, int[] temp) { //
     * THIS METHOD WILL TAKE THE ARRAY AND RECURSSIVE CALL THE MERGE METHOD TO SORT
     * // THE DATA GIVE
     * 
     * if (low < high) {
     * 
     * int mid = (high + low) / 2;
     * 
     * mergeDivide(a, low, mid, temp); mergeDivide(a, mid + 1, high, temp);
     * 
     * mergeBack(a, low, high, temp, mid); // System.out.println("Finished merge");
     * }
     * 
     * }
     * 
     *//**
        * 
        * @param a
        * @param low
        * @param high
        * @param temp
        * @param mid
        *
        *//*
	   * public static void mergeBack(int[] a, int low, int high, int[] temp, int mid)
	   * { // MERGE THE ARRAYS BACK TOGETHER int leftStart = low; int rightStart = mid
	   * + 1; int firstSize, secondSize; firstSize = rightStart - leftStart;
	   * secondSize = high - rightStart + 1;
	   * 
	   * int[] temp1 = new int[firstSize]; int[] temp2 = new int[secondSize];
	   * 
	   * int right = rightStart; int left = leftStart; int iLeft = 0; while (left <=
	   * mid) {
	   * 
	   * temp1[iLeft] = a[left]; left++; iLeft++; } int iRight = 0; while (right <=
	   * high) {
	   * 
	   * temp2[iRight] = a[right];
	   * 
	   * iRight++; right++; }
	   * 
	   * int i = 0, j = 0; int i2 = low;
	   * 
	   * while (i < temp1.length && j < temp2.length) {
	   * 
	   * if (temp1[i] < temp2[j]) { a[i2] = temp1[i]; i2++; i++; } else {
	   * 
	   * a[i2] = temp2[j]; i2++; j++; }
	   * 
	   * } while (i < temp1.length) { a[i2] = temp1[i]; i2++; i++;
	   * 
	   * } while (i < temp1.length) { a[i2] = temp2[j]; i2++; j++;
	   * 
	   * } }
	   */

}

class Container<T extends Comparable<T>> {
    private T[] data;

    public T[] getData() {
	return data;
    }

    public void setData(T[] data) {
	this.data = data;
    }

}
