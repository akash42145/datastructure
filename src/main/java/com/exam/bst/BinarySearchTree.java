package com.exam.bst;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;

	@Override
	public void insert(T t) {
		root = insertNode(root, t);
	}

	private Node<T> insertNode(Node<T> node, T t) {
		if (node == null) {
			return new Node<T>(t);
		}
		if (t.compareTo(node.getData()) < 0) {
			node.setLeft(insertNode(node.getLeft(), t));
		} else {
			node.setRight(insertNode(node.getRight(), t));
		}
		return node;

	}

	@Override
	public void traverse() {
		traverse(root);

	}

	private Node<T> traverse(Node<T> node) {		
		if(node== null) {
			return node;
		}
		traverse(node.getLeft());
		System.out.print(node.getData() + " --> ");
		traverse(node.getRight());		
		return node;
	}

	@Override
	public T getMax() {
		return getMaxNode(root);
	}
	
	private T getMaxNode(Node<T> node) {
		T data = null;
		if(node.getRight() == null) {
			data = node.getData();
			return data;
		}
		return getMaxNode(node.getRight());		
		
	}

	@Override
	public T getMin() {		
		return getMinNode(root);
	}

	private T getMinNode(Node<T> node) {		
		if(node.getLeft() == null) {
			return node.getData();
		}		
		return getMinNode(node.getLeft());
	}

	@Override
	public void remove(T t) {
		/*
		 * 1) Removal node is a leaf node
		 * 2) Removal node has single child
		 * 3) Removal node have both child (In that case either get max node and swap with removal node or get min right node and swap)
		 */
		if(root != null) {
			root = removeNode(root, t);
		}
		

	}

	private Node<T> removeNode(Node<T> node, T t) {
		
		if(t.compareTo(node.getData()) < 0) {
			
		}
		
		
		return null;
	}

}
