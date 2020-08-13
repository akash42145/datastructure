package com.exam.bst;

public class BSTClient {

	public static void main(String[] args) {
		Tree<Integer> bst = new BinarySearchTree<Integer>();
		bst.insert(15);
		bst.insert(40);
		bst.insert(50);
		bst.insert(45);
		bst.insert(10);
		bst.insert(13);		
		bst.insert(11);
		bst.insert(8);
		
		System.out.println("In order traverse...");
		bst.traverse();
		System.out.println("");
		System.out.println("Get max.."+ bst.getMax());
		
		System.out.println("Get min.."+ bst.getMin());
		
		System.out.println("Removing Node....");
		
	}

}
