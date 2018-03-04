package com.assignment.junit.binarytree;


/**
 * 
 * populateTree // This method populates the tree 
 * traverseTree // This method displays sorted name
 * countNode 	// This method counts all the nodes in the tree
 * counLeaf 	// This method counts leafs in the tree
 * 
 * In the simplest case a binary tree with a root node, a left and a right has 3 nodes, two of which are leaf nodes. It's (n+1)/2.
 * 
 * @author Ashfaque Ahammad
 *
 */
public class BinaryTreeApp {
	private Node<String> root; // hidden root node
	private int nodeCount = 0;

	/**
	 * We’ll follow these rules starting from the root node for insertion:
	 * if it is a new entry then insert into the tree
	 * if the new node’s value is lower than the current node’s, we go to the left child
	 * if the new node’s value is greater than the current node’s, we go to the right child
	 * when the current node is null, we’ve reached a leaf node and we can insert the new node in that position
	 * 
	 * First, we’ll create a recursive method to do the insertion:
	 *
	 * @param str
	 */
	public void populateTree(String str) {
		if (root == null) { // must handle case of empty tree first
			root = new Node<String>(str);
			return;
		}
		Node<String> node = root; // start search downward at root
		while (true) {
			if (str.compareTo(node.data) < 0) { // go left
				if (node.left != null) {
					node = node.left;
				} else {
					node.left = new Node(str);
					break;
				}
			} else if (str.compareTo(node.data) > 0) { // go right
				if (node.right != null) {
					node = node.right;
				} else {
					node.right = new Node(str);
					break;
				}
			} else 
				break; // found! Don't insert
		}
	}

	// traverseTree: need because root is hidden
	public void traverseTree() {
		traverseNode(root);
	}

	// traverseNode: recursive function that does the work
	private void traverseNode(Node node) {
		if (node != null) {
			traverseNode(node.left);
			System.out.print(node.data + " ");
			traverseNode(node.right);
		}
	}
	
	public int countNode() {
		return getNodeCount(root);
	}

	
	/**
	 * getNodeCount: recursive function that does the work
	 * @param node
	 * @return
	 */
	private int getNodeCount(Node node) {
		int count = 0;
		if (node != null) {
			count++;
			count = count + getNodeCount(node.left);
			count = count + getNodeCount(node.right);
		}
		return count;
	}
	
	/* 
	 * Function to get the count of leaf nodes in a binary tree
	 */
    public int countLeaf() 
    {
        return getLeafCount(root);
    }
  
    /*
     * Here's the algorithm -
     * 1. If node is NULL then return 0
     * 2. Else If left and right child nodes are NULL then return 1
     * 3. Else recursively calculate leaf count of the binary tree
     *    using the formula -> 
     *    Leaf count of a tree = Leaf count of the left subtree +
     *    Leaf count of the right subtree
     * 
     */
    private int getLeafCount(Node node) 
    {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        else
            return getLeafCount(node.left) + getLeafCount(node.right);
    }

	public Node<String> getRoot() {
		return root;
	}

	public void setRoot(Node<String> root) {
		this.root = root;
	}

	public int getNodeCount() {
		return nodeCount;
	}

	public void setNodeCount(int nodeCount) {
		this.nodeCount = nodeCount;
	}

}
