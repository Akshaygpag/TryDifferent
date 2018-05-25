package com.bridgelabz.datastructures.programs;

import com.bridgelabz.algorithm.impl.StackImpl;
import com.bridgelabz.algorithm.interfaces.Stack;
import com.bridgelabz.functionalprogramming.util.Utility;

public class StackMainMethod {

    public static void main(String[] args) {
	// THIS METHOD WILL TAKE THE USER INPUT STRING FOR THE EXPRESSION AND PUSH ( ,)
	// INTO THE STACK AND POP IF REQUIRED
	Stack myStack = new StackImpl();

	System.out.println("Enter a arithetic expression with paranthesis .");
	String expression = Utility.getUserStringValue();
	char[] expressionArray = expression.toCharArray();

	boolean result = isBracketsbalanced(expressionArray, myStack);
	System.out.println(" Is it balanced "+result+" ");
    }

    private static boolean isBracketsbalanced(char[] expressionArray, Stack myStack) {
	// THIS METHOD WILL RETURN TRUE IT EXPRESSION IS BALANCED ELSE FALSE
System.out.println("Initial stack size is : "+myStack.size());
	for (int i = 0; i < expressionArray.length; i++) {
	    
	    System.out.println("Element to be operated is : "+expressionArray[i]);
	    if (expressionArray[i] == '(') {
		// THEN ONLY PERFORM THE PUSH OPERATIONS
		Node item = new Node();

		item.setInfo(String.valueOf(expressionArray[i]));
		myStack.push(item);

	    }
	    
	    if (expressionArray[i] == ')') {
		// PERFORM THE POP OPERATIONS
		Node check=myStack.pop();

		if(check==null) {
		    
		    return false;
		}
		
	    }

	}
//System.out.println("Final stack content is "+myStack.size());
//System.out.println("My stack contents  "+myStack.isEmpty());
	if (myStack.isEmpty()) {

	    return true;

	}


	return false;
    }

}
