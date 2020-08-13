package com.exam.linkedlist;

public class TestLinkedList {

	public static void main(String[] args) {
		MyLinkedList<Integer> ll = new MyLinkedList<Integer>();
		
		ll.add(3);
		ll.add(6);
		ll.add(9);
		ll.add(15);
		ll.add(21);
		ll.print();
		System.out.println("------INSERT---------");
		
		ll.insert(12, 4);		
		ll.insert(18, 6);
		ll.print();
		
		System.out.println("------DELETE---------");		
		ll.delete(4);
		ll.delete(6);
		ll.print();		


	}

}
