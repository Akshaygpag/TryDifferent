/**
 * @author Akshay
 * @version 1.0.0
 * @since 23-May-2018
 */

package com.bridgelabz.algorithm.impl;

import com.bridgelabz.algorithm.interfaces.DeQue;
import com.bridgelabz.datastructures.programs.Node;

public class DeQueImpl implements DeQue {

    Node front;
    Node rear;

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.DeQue#Deque()
     */
    @Override
    public DeQue Deque() {
	// RETURNS THE EMPTY DEQUEUE
	return new DeQueImpl();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.DeQue#addFront(com.bridgelabz.
     * datastructures.programs.Node)
     */
    @Override
    public void addFront(Node item) {
	// ADDS THE ELEMENT TO THE FRONT

	if (front == null && rear == null) {

	    rear = item;
	    front = item;
	    return;
	}

	front.setNext(item);
	front = item;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.DeQue#addRear(com.bridgelabz.
     * datastructures.programs.Node)
     */
    @Override
    public void addRear(Node item) {
	// ADDS THE ELEMENT TO THE REAR

	if (front == null && rear == null) {

	    rear = item;
	    front = item;
	    return;
	}

	item.setNext(rear);
	rear = item;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.DeQue#removeFront()
     */
    @Override
    public Node removeFront() {
	// REMOVES THE ELEMENT FROM THE FRONT OF THE DEQUEUE
	if (front == null) {

	    return null;
	}
	Node current = rear;
	Node previous = rear;
	if (rear == front) {
Node item=front;
	    rear = null;
	    front = null;
	    return item;
	}
	while (current != front) {
	    previous = current;
	    current = current.getNext();
	}
	front = previous;
	previous.setNext(null);
	return current;
    }

    public Node getFront() {
        return front;
    }

    public void setFront(Node front) {
        this.front = front;
    }

    public Node getRear() {
        return rear;
    }

    public void setRear(Node rear) {
        this.rear = rear;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.DeQue#removeRear()
     */
    @Override
    public Node removeRear() {
	// REMOVES THE ELEMENT FROM THE REAR
	if (rear == null) {

	    return null;

	}
	Node current = rear;
	rear = rear.getNext();
	current.setNext(null);
	if (rear == null) {

	    front = null;
	}

	return current;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.DeQue#isEmpty()
     */
    @Override
    public boolean isEmpty() {
	// RETURNS TRUE IF DEQUEUE IS EMPTY ELSE FALSE

	if (rear == null && front == null) {

	    return true;

	}

	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.DeQue#size()
     */
    @Override
    public int size() {
	// GIVES THE SIZE OF THE DEQUEUE (NO OF ELEMENTS PRESENT IN IT)

	int size = 0;
	if (rear == null && front == null) {

	    return size;
	}
	Node current = rear;

	while (current != null) {

	    size++;
	    current = current.getNext();

	}
	return size;
    }

}
