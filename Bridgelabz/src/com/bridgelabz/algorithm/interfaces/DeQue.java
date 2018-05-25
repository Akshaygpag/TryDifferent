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
public interface DeQue {

    DeQue Deque();
    void addFront(Node item);
    void addRear(Node item);
    Node removeFront();
    Node removeRear();
    boolean isEmpty();
    int size();
    
    Node getFront();
    Node getRear();
    
    
    
    
}
