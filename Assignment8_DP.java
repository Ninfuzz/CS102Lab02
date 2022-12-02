/*

* @author (Dylan I. Pace)

* <p> (File Name)

* <p> (Assignment)

* <p> (Describe, in general, the code contained.)

*/

import java.util.*;
public class Assignment8_DP
{

	public static void main(String[] args)
	{
		
		Scanner scan = new Scanner (System.in);
		
		//Creates the BST object
		BST bst = new BST();
		
		//inserting values into the BS
		
		bst.insert(2);
		bst.insert(3);
		bst.insert(5);
		bst.insert(4);
		bst.insert(7);
		bst.insert(6);
		
		System.out.println("Your BST values (left -- root -- right):");
		bst.inOrder();
		
		System.out.println("\nYour root value is " + bst.getRoot());
		
		System.out.println("Which value would you like to delete? ");
		
		int choice = scan.nextInt();
		
		bst.delete(choice);
		
		System.out.println("Your new BST values (left -- root -- right):");
		bst.inOrder();
		
		System.out.println("\nyour new root value is " + bst.getRoot());
		
		

	}

}
