/**
 * @author Akshay
 * @version 1.0.0
 * @since 23-May-2018
 */

package com.bridgelabz.algorithm.interfaces;

import com.bridgelabz.datastructures.programs.Node;

/**
 * @author bridgeit
 *
 */
public interface Queue {
    Queue Queue();

    void enqueue(Node customer);

    Node dequeue();

    boolean isEmpty();

    int size();
    
    
    Node peek();

}
