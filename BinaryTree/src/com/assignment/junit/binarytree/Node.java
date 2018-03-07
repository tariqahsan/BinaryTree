package com.assignment.junit.binarytree;


// Node: simple node in a binary search tree

/*public class Node {
	public String data; // data at each node
	public Node left, right;

	public Node(String d) { // construct leaf node
		data = d;
		left = right = null;
	}
}*/

public class Node<T extends Comparable<?>> {
	Node<T> left, right;
	T data;

	public Node(T data) {
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}