package com.bridgelabz.algorithm.interfaces;

import com.bridgelabz.algorithm.impl.UnOrderedList;
import com.bridgelabz.datastructures.programs.Node;

public interface List<T> {
	UnOrderedList list();

	void add(Node item);

	Node remove(Node item);

	boolean search(Node item);

	boolean isEmpty();

	int size();

	void append(Node item);

	int index(Node item);

	void insert(int position, Node item);

	Node pop();

	Node pop(int position);
}
