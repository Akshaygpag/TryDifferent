package com.bridgelabz.algorithm.interfaces;

import com.bridgelabz.datastructures.programs.Node;

public interface OrderedList<T> {

	OrderedList list();

	void add(Node item);

	void remove(Node item);

	boolean search(Node item);

	boolean isEmpty();

	int size();

	int index(Node item);

	Node pop();

	Node pop(int position);
	
	void printElements();
	

}
