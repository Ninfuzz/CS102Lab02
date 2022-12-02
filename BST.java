/*

* @author (Dylan I. Pace)

* <p> (File Name)

* <p> (Assignment)

* <p> (Describe, in general, the code contained.)

*/


import java.util.*;
//BRIEF DESCRIPTION OF THIS ALGORITHM:
//This method works by accepting values and puts them into nodes, which are then 
//sorted into a tree like structure with the smaller values being put left,
//and the higher values being put right
//this program has the functionality to search and delete a node given its key
//as well as it has the ability to return the root value.
public class BST
{
	class Node 
	{
		int key;
		Node left, right;
		
		public Node (int data)
		{
			key = data;
			left = right = null;
		}
	}
	
	Node root;
	
	public BST()
	{
		root = null;
	}
	
	public void delete (int key)
	{
		root = deleteRecursive(root, key);
	}
	
	public Node deleteRecursive(Node root, int key)
	{
		//if the tree is empty
		if (root == null)
		{
			return root;
		}
		
		//traverse through the tree
		if (key < root.key)
		{
			//traverses the left side
			root.left = deleteRecursive(root.left, key);
		}
		else if (key > root.key)
		{
			//traverses the right side
			root.right = deleteRecursive(root.right, key);
		}
		else
		{
			//if node only has one child
			if (root.left == null)
			{
				return root.right;
			}
			else if (root.right == null)
			{
				return root.left;
			}
			
			//if the node has two children
			//puts the successor in the correct order
			root.key = minValue(root.right);
			
			//deletes the successor in order
			root.right = deleteRecursive(root.right, root.key);
		}
		return root;
	}
	
	public int minValue (Node root)
	{
		//initial minimum value is set to root
		int minVal = root.key;
		
		//finds the minimum value
		while (root.left != null)
		{
			minVal = root.left.key;
			root = root.left;
		}
		return minVal;
	}
	
	//Method to insert a node into the BST
	public void insert (int key)
	{
		root = insertRecursive(root, key);
	}
	
	//recursive insert method
	public Node insertRecursive (Node root, int key)
	{
		//does if tree is empty
		if (root == null)
		{
			root = new Node(key);
			return root;
		}
		
		//traverses the tree
		if (key < root.key)
		{
			//inserts into the left side of tree
			root.left = insertRecursive(root.right, key);
		}
		else if (key > root.key)
		{
			//inserts into the right side of tree
			root.right = insertRecursive(root.right, key);
		}
		
		return root;
	}
	
	//method for traversing BST in order
	public void inOrder ()
	{
		inOrderRecursive(root);
	}
	
	//method for recursively traversing the BST
    void inOrderRecursive(Node root) 
    { 
        if (root != null) 
        { 
            inOrderRecursive(root.left); 
            System.out.print(root.key + " "); 
            inOrderRecursive(root.right); 
        } 
    } 
    
    public int getRoot()
    {
    	return root.key;
    }
	
	public boolean search (int key)
	{
		root = searchRecursive(root, key);
		if (root != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Node searchRecursive (Node root, int key)
	{
		//if the root is null or if the key is at the root
		if ( root == null || root.key == key)
		{
			return root;
		}
		
		//if the value is larger than the root's key
		if (root.key > key)
		{
			return searchRecursive(root.left, key);
		}
		
		//if the value is smaller than the root's key
		return searchRecursive(root.right, key);
	}
	

      
}
