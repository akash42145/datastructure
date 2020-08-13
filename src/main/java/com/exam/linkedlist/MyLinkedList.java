package com.exam.linkedlist;

import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>>  implements Iterable<T>{
	
	private int size = 0;
	private int limit;
	
	Node<T> head;
	
	public MyLinkedList() {
		
	}
	
	public MyLinkedList(int limit) {
		this.limit = limit;
	}
	
	public void addFirst(T data) {
		if(head == null) {
			head = new Node<T>(data);			
		}
		else {
			Node<T> node = new Node<T>(data);
			node.setNext(head);
			head= node;
		}
		
		size++;
	}
	
	public void add(T data) {

		if(head == null) {
			head = new Node<T>(data);			
		}
		else {
			Node<T> curr = head;
			while(curr.getNext() != null) {
				curr = curr.getNext();
			}
			curr.setNext(new Node<T>(data));
		}
		size++;
	
		
	}
	
	public void insert(T data, int pos) {
		if(pos > size || pos < 1) {
			System.out.println("Given postition is out of boundry ..");
		}
		if(pos == 1 ) {
			addFirst(data);
		}else if(pos == size +1 ) {
			add(data);
		}
		else {
			Node<T> pre = head;
			int count = 1;
			while(count < pos -1) {
				pre = pre.getNext();
				count++;
			}
			Node<T> node = new Node<>(data);
			node.setNext(pre.getNext());
			pre.setNext(node);
			size++;
		}		
	}	
	public void delete(int pos) {
		if(pos > size || pos < 1) {
			System.out.println("Given postition is out of boundry ..");
		}
		if(pos == 1 ) {			
			head = head.getNext();			
		}else {
			Node<T> pre = head;			
			int count = 1;
			while(count < pos -1) {
				pre = pre.getNext();
				count++;
			}
			Node<T> next = pre.getNext();
			if(next != null) {
				next = next.getNext();
			}
			pre.setNext(next);
		}		
		size--;
		
	}
	
	public void print() {
		Node<T> curr = head;
		while(curr !=null) {
			System.out.print(curr.getData() + "->");
			curr = curr.getNext();
		}
		
		System.out.println();
		
	}
	
	public void print(Node<T> node) {
		Node<T> curr = node;
		while(curr !=null) {
			System.out.print(curr.getData() + "->");
			curr = curr.getNext();
		}
		
		System.out.println();
		
	}


	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int size() {
		return size;
	}
	
	public  T findFromlast(int pos) {		
		int i = 1;
		
		Node<T> curr =  head;
		Node<T> node =  head;		
		while(i <  pos) {
			curr = curr.getNext();
			i++;
		}		
		while(curr.getNext() != null) {
			node = node.getNext();
			curr = curr.getNext();			
		}		
		return node.getData();
	}
	
	public Node<T> reverse(){
		Node<T> rev = null;
		Node<T> temp = null;
		Node<T> curr = head;
		
		while(curr !=null) {
			temp = curr;
			curr = curr.getNext();
			temp.setNext(rev);
			rev= temp;
			
		}
		
		return rev;
	}


}
