/**
 * @author Akshay
 * @version 1.0.0
 * @since 25-May-2018
 */

package com.bridgelabz.datastructures.programs;

import com.bridgelabz.algorithm.impl.OrderedListImpl;
import com.bridgelabz.algorithm.interfaces.List;
import com.bridgelabz.algorithm.interfaces.OrderedList;

/**
 * @author bridgeit
 *
 */
public class Week implements Comparable<Week> {

    OrderedList<Node> daysInWeek = new OrderedListImpl();

  
    @Override
    public String toString() {
	return "Week [daysInWeek=" + daysInWeek + "]";
    }


    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Week o) {
	// bridgeit
	return 0;
    }

}
