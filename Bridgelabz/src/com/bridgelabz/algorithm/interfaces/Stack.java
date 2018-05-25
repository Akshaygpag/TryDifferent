package com.bridgelabz.algorithm.interfaces;

import com.bridgelabz.datastructures.programs.Node;

public interface Stack {
	Stack stack();

	void push(Node item);

	Node pop();

	Node peek();

	boolean isEmpty();

	int size();

}
