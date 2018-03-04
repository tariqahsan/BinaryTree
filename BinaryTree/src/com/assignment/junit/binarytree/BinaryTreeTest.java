package com.assignment.junit.binarytree;

//TreeTest: test the Tree class, a binary search tree
public class BinaryTreeTest {
	public static void main(String[] argv) {
		
		String[] persons = { "Peggy", "John", "Steve", "Hassan", "Albert", "Abdul", "Xio", "Bijay", "Ashfaque", "Shen", "Kerry", "Farhad" };
		
		BinaryTreeApp tree = new BinaryTreeApp();
		for (int i = 0; i < persons.length; i++)
			tree.populateTree(persons[i]);
		tree.traverseTree();
		/* get leaf count of the binary tree */
		System.out.println("\nThe node count of binary tree is : " + tree.countNode());
        System.out.println("\nThe leaf count of the binary tree is : " + tree.countLeaf());
		System.out.println("\nThe Root value of the tree is : " + tree.getRoot().data);
		System.out.println("\nHere is how the Binary Tree would look like --> \n\n");
		BTreePrinter.printNode(tree.getRoot());
		
	}
}
