/**
 * @author Akshay
 * @version 1.0.0
 * @since 25-May-2018
 */

package com.bridgelabz.datastructures.programs;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import com.bridgelabz.algoritms.util.AlgorithmUtil;

enum DAYS {
    S, M, T, W, Th, F, Sa
}

public class Calendar {

    static Map<Integer, Integer> days;
    static {
	days = new HashMap<Integer, Integer>();

	days.put(0, 31);
	days.put(1, 28);

	days.put(2, 31);

	days.put(3, 30);

	days.put(4, 31);

	days.put(5, 30);

	days.put(6, 31);

	days.put(7, 31);

	days.put(8, 30);

	days.put(9, 31);

	days.put(10, 30);
	days.put(11, 31);

    }

    public static void main(String[] args) {

	int[][] calendar = new int[7][7];

	java.util.Calendar calendarG = new GregorianCalendar(Integer.parseInt(args[0]), Integer.parseInt(args[1]) - 1,
		1);

	int position = AlgorithmUtil.dayOfWeek(calendarG.get(java.util.Calendar.DATE),
		calendarG.get(java.util.Calendar.MONTH) + 1, calendarG.get(java.util.Calendar.YEAR));
	String startingDay = getDays()[position].name();
	int counterDates = 0;

	if (calendarG.get(java.util.Calendar.MONTH) == 1) {

	    // CHECK FOR LEAP YEAR
	    boolean isLeapYear = leapChecker(Long.parseLong(args[0]));
	    if (isLeapYear) {

		days.put(1, 29);
	    }
	}

	int end = days.get(calendarG.get(java.util.Calendar.MONTH));
	for (int i = 0; i < calendar.length; i++) {

	    for (int j = 0; j < calendar[i].length; j++) {

		if (i == 0) {
		    calendar[i][j] = getDays()[j].name().charAt(0);
		    if (j == calendar[i].length - 1) {

			String formatDate = String.format("%-2s", String.valueOf((char) calendar[i][j]));
			System.out.print(formatDate + "  ");
			// System.out.print( + " ");
			System.out.println();
			break;

		    }
		    calendar[i][j] = getDays()[j].name().charAt(0);
		    String formatDate = String.format("%-2s", String.valueOf((char) calendar[i][j]));
		    System.out.print(formatDate + "  ");
		    // System.out.print((char) calendar[i][j] + " ");

		} else {
		    if (i == 1) {
			// System.out.println("Position is "+position);
			if (j < position) {
			    // System.out.print(" ");
			    String formatDate = String.format("%-2s", " ");
			    System.out.print(formatDate + "  ");
			} else {
			    calendar[i][j] = counterDates += 1;
			    String formatDate = String.format("%-2d", calendar[i][j]);
			    System.out.print(formatDate + "  ");

			}

		    }

		    else {

			if (end > counterDates) {

			    calendar[i][j] = counterDates += 1;
			    String formatDate = String.format("%-2d", calendar[i][j]);
			    System.out.print(formatDate + "  ");
			}

		    }

		}
	    }
	    System.out.println();

	}

    }

    /**
     * 
     * 
     */
    private static DAYS[] getDays() {
	DAYS[] days = DAYS.values();
	return days;
    }

    private static boolean leapChecker(long year) {
	if (year % 400 == 0) {
	    return true;
	}
	if (year % 4 == 0 && !(year % 100 == 0)) {
	    return true;

	}
	return false;

    }

}
