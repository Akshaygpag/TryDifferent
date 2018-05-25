/**
 * @author Akshay
 * @version 1.0.0
 * @since 25-May-2018
 */

package com.bridgelabz.datastructures.programs;

import com.bridgelabz.algorithm.impl.StackImpl;
import com.bridgelabz.algorithm.interfaces.Stack;

public class QueueUsingStack {
    Stack stack1, stack2;

    public QueueUsingStack() {
	stack1 = new StackImpl();
	stack2 = new StackImpl();

    }

    public Node pop() {

	stack2 = stack2.stack();
	while (!stack1.isEmpty()) {

	    Node removedItem = stack1.pop();

	    stack2.push(removedItem);
	}

	Node returningItem = stack2.pop();

	while (!stack2.isEmpty()) {

	    Node removedItem = stack2.pop();

	    stack1.push(removedItem);

	}
	return returningItem;
    }

    public void push(Node item) {
	stack1.push(item);

    }

}
