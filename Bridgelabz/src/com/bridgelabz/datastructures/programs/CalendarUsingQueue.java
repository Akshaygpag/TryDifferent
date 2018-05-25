/**
 * @author Akshay
 * @version 1.0.0
 * @since 25-May-2018
 */

package com.bridgelabz.datastructures.programs;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import com.bridgelabz.algorithm.impl.QueueImpl;
import com.bridgelabz.algorithm.interfaces.Queue;
import com.bridgelabz.algoritms.util.AlgorithmUtil;

enum DAY {
    S, M, T, W, Th, F, Sa
}

public class CalendarUsingQueue {
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

    /**
     * @param args
     * 
     */
    public static void main(String[] args) {

	java.util.Calendar calendarG = new GregorianCalendar(Integer.parseInt(args[0]), Integer.parseInt(args[1]) - 1,
		1);

	int position = AlgorithmUtil.dayOfWeek(calendarG.get(java.util.Calendar.DATE),
		calendarG.get(java.util.Calendar.MONTH) + 1, calendarG.get(java.util.Calendar.YEAR));

	int counterDates = 0;

	if (calendarG.get(java.util.Calendar.MONTH) == 1) {

	    // CHECK FOR LEAP YEAR
	    boolean isLeapYear = leapChecker(Long.parseLong(args[0]));
	    if (isLeapYear) {

		days.put(1, 29);
	    }
	}

	int end = days.get(calendarG.get(java.util.Calendar.MONTH));
	Queue queue = new QueueImpl();

	Week headers = new Week();
System.out.println(getDays()[0]);




	for (int i = 0; i < getDays().length; i++) {

	    WeekDay day = new WeekDay();
System.out.println(getDays()[i]);
	    day.setDay(String.valueOf(getDays()[i]));
	    Node n = new Node();
	    n.setInfo(day);
	    headers.daysInWeek.add(n);

	}

	Node n2 = new Node();
	n2.setInfo(headers);
	queue.enqueue(n2);

	System.out.println(queue.dequeue());
	
	
	int i2 = 0;
	int y = 0;
	boolean stop = false;
	for (int i = 0; i < getDays().length; i++) {

	    Week week = new Week();

	    for (int j = 0; j < getDays().length; j++) {

		WeekDay day = new WeekDay();

		if (j < position && i == 0) {

		    day.setDay("");
		    day.setDate("");
		    continue;
		}

		day.setDate(String.valueOf(++y));
		// y = y + 1;
		Node n = new Node();
		n.setInfo(day);
		week.daysInWeek.add(n);

	    }

	    if (stop) {
		break;
	    }
	    System.out.println("Exiting the for loop");
	    Node n = new Node();
	    n.setInfo(week);
	    queue.enqueue(n);

	}

	System.out.println(queue.dequeue());
	System.out.println("added success");

    }

    private static String getDay(int date) {

	DAY[] days = DAY.values();
	return days[date].name();

    }

    private static DAY[] getDays() {
	DAY[] days = DAY.values();
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
