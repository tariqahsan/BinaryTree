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
}