package com.exam.bst;

public interface Tree<T> {
	
	 void insert(T t);
	
	 void traverse();
	
	 T getMax();
	
	 T getMin();
	
	 void remove(T t);

}
