/**
 * @author Akshay
 * @version 1.0.0
 * @since 23-May-2018
 */

package com.bridgelabz.algorithm.impl;

import com.bridgelabz.algorithm.interfaces.Queue;
import com.bridgelabz.datastructures.programs.Node;
import com.bridgelabz.algorithm.interfaces.Queue;

/**
 * @author bridgeit
 *
 */
public class QueueImpl implements Queue {
    Node front;
    Node rear;

    public QueueImpl() {
	// ZERO ARG CONSTRUCTOR

	front = null;
	rear = null;

    }

    /*
     * @see com.bridgelabz.algorithm.interfaces.Queue#Queue()
     */
    @Override
    public Queue Queue() {
	// RETURNS THE NEW QUEUE

	return new QueueImpl();
    }

    /*
     * @see com.bridgelabz.algorithm.interfaces.Queue#enqueue(com.bridgelabz.
     * datastructures.programs.Node)
     */
    @Override
    public void enqueue(Node customer) {
	// THIS METHOD WILL TAKE IN CUSTOMERS
	if (front == null || rear == null) {

	    customer.setNext(rear);
	    rear = customer;
	    front = rear;
	    return;

	}
	customer.setNext(rear);
	rear = customer;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.Queue#dequeue()
     */
    @Override
    public Node dequeue() {
	// THIS METHOD WILL REMOVE CUSTOMERS FROM THE QUEUE
	if (rear == null && front == null) {
	    // empty
	    System.out.println("The queue is empty");
	    return null;
	}
	if (rear == front) {
	    Node contains = front;

	    front = null;
	    rear = null;
	    return contains;

	}
	Node previous = rear;
	Node current = rear;
	while (current != front) {
	    previous = current;
	    current = current.getNext();
	}

	previous.setNext(null);
	front = previous;

	return current;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.Queue#isEmpty()
     */
    @Override
    public boolean isEmpty() {
	// FRTURN TRUE IF THE QUEUE IS EMPTY ELSE FALSE
	if (this.size() == 0) {
	    return true;
	}
	return false;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.Queue#size()
     */
    @Override
    public int size() {
	// RETURNS THE NUMBER OF CONTENTS IN THE QUEUE
	if (rear == null && front == null) {

	    return 0;
	}
	if (rear == front) {
	    return 1;
	}

	Node current = rear;
	int size = 1;
	while (current != front) {

	    size++;
	    current = current.getNext();

	}

	return size;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.Queue#peek()
     */
    @Override
    public Node peek() {
	// SEARCH FOR THE FIRST ITEM IN THE QUEUE

	if (front == null || rear == null) {

	    System.out.println("Empty queue returning null");
	    return null;

	}

	return front;
    }

}
