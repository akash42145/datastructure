package com.exam.linkedlist;

public class ReverseList {

	public static void main(String[] args) {
		MyLinkedList<Integer> ll = new MyLinkedList<Integer>();
		ll.add(3);
		ll.add(6);
		ll.add(9);
		ll.add(12);
		ll.add(15);
		ll.add(18);
		ll.add(21);
		
		ll.print();
		
		
		
		ll.print(ll.reverse());
	}

}
