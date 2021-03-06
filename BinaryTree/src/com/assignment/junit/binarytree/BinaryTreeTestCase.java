package com.assignment.junit.binarytree;

import junit.extensions.TestSetup;
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BinaryTreeTestCase extends TestCase {

	// Instance/Class variables
	static BinaryTreeApp tree;
	static int arrayLength;
	
	// No-arg constructor
	public BinaryTreeTestCase() {}
	
	// Constructor with a String datatype argument 
	public BinaryTreeTestCase(String string) {
		super(string);
	}
	
	protected static void oneTimeSetUp() throws Exception {
		
		// Populate the binary tree with the String values of an array
		tree = new BinaryTreeApp();
		String[] persons = { "Peggy", "John", "Steve", "Hassan", "Albert", "Abdul", "Xio", "Bijay", "Ashfaque", "Shen", "Kerry", "Farhad" };
		for (int i = 0; i < persons.length; i++) {
			tree.populateTree(persons[i]);
		}
		
		// Store the length of the persons array
		arrayLength = persons.length;
	}
	
	public void testPopulateTree() throws Exception {
		Assert.assertEquals("Array should have 12 elements", 12, arrayLength);
	}
	
	/**
	 * 
	 * Depth-first search is a type of traversal that goes deep as much as possible in every 
	 * child before exploring the next sibling.There are several ways to perform a depth-first search: 
	 * in-order, pre-order and post-order.
	 * 
	 * The testTraverseTree method is a 'in-order' search. In-order traversal consists of first visiting 
	 * the left sub-tree, then the root node, and finally the right sub-tree:
	 * 
	 * @throws Exception
	 */
	public void testTraverseTree() throws Exception {
		tree.traverseTree();
		// Should return '0' if the list of names are sorted properly according to 'in-order' as mentioned above
		Assert.assertEquals("The names in the list are sorted as expected", 0, tree.getSortedArray().toString().compareTo("[Abdul, Albert, Ashfaque, Bijay, Farhad, Hassan, John, Kerry, Peggy, Shen, Steve, Xio]"));
	}
	
	public void testCountNode() throws Exception {
		Assert.assertEquals("There should be 12 nodes in the binary tree", 12, tree.countNode());	
	}
	
	public void testCountLeaf() throws Exception {
		Assert.assertEquals("There should be 6 leaves in the binary tree", 6, tree.countLeaf());	
	}
	
	
	protected static void oneTimeTearDown() throws Exception {

	}

	public static Test suite() { 
		
		// A TestSuite can extract the tests to be run automatically.
		// To do so we pass the class of our BinaryTreeTestCase class to the
		// TestSuite constructor. Then This constructor creates a suite with all the methods
		// starting with "test" (e.g. testPopulateTree) that take no arguments.
		TestSuite suite= new TestSuite(BinaryTreeTestCase.class);
	   
		// We can wrap the test suite containing all our tests in a subclass of TestSetup which 
		// invokes setUp() exactly once before all the tests are run and invokes tearDown() exactly 
		// once after all the tests have been run.
		TestSetup wrapper = new TestSetup(suite) {

            protected void setUp() throws Exception {
                oneTimeSetUp();
            }

            protected void tearDown() throws Exception {
                oneTimeTearDown();
            }
	
        };

        return wrapper;
	}
	
	public static void main(String args[]) { 
	    junit.textui.TestRunner.run(suite());
	}
	
}
