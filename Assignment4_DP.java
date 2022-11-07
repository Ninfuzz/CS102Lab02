/*

* @author (Dylan I. Pace)

* <p> (File Name)

* <p> (Assignment)

* <p> (Describe, in general, the code contained.)

*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
public class Assignment4_DP
{


	public static void main(String[] args)
	{
		//Following code is for dealing with the queue
		Queue<Integer> myQ = new LinkedList<Integer>();
		
		myQ.add(-2);
		myQ.add(2);
		myQ.add(3);
		myQ.add(0);
		myQ.add(-1);

		System.out.println("The minimum value in the queue is: " + minValue(myQ));
		
		//Following code is for dealing with palindromes
		String word1 = "madam";
		String word2 = "apple";
		
		if (palindrome(word1))
		{
			System.out.println(word1 + " is a palindrome!");
		}
		else
		{
			System.out.println(word1 + " is not a palindrome.");
		}
		
		if (palindrome(word2))
		{
			System.out.println(word2 + " is a palindrome!");
		}
		else
		{
			System.out.println(word2 + " is not a palindrome.");
		}
		
		//Following code is for checking for balanced parenthesis
		String equation1 = "(((4+5)2)+8)";
		String equation2 = "(9+5))";
		
		if (balancedParenthesis(equation1))
		{
			System.out.println(equation1 + " has balanced parenthesis!");
		}
		else
		{
			System.out.println(equation1 + " does not have balanced parenthesis.");
		}
		
		if (balancedParenthesis(equation2))
		{
			System.out.println(equation2 + " has balanced parenthesis!");
		}
		else
		{
			System.out.println(equation2 + " does not have balanced parenthesis.");
		}

	}
	//method to find the minimum integer value in a queue
	public static int minValue (Queue<Integer> queue)
	{
		
		Object[] tempArray = queue.toArray();
		int minimum = (int)tempArray[0];
		for (int c = 0; c < tempArray.length; c++)
		{
			if ((int)tempArray[c] < minimum)
			{
				minimum = (int)tempArray[c];
			}
			
		}
		
		return minimum;
		
	}
	//method to determine if a given String is a palindrome or not
	public static boolean palindrome (String word)
	{
		Stack<Character> myStack = new Stack<Character>();
		
		String starting = word;

		
		for (int c = 0; c < word.length(); c++)
		{
			
			myStack.push(word.charAt(c));
		}
		
		String ending = "";
		
		while (!myStack.isEmpty())
		{
			ending += myStack.pop();
		}

		if (starting.equalsIgnoreCase(ending))
		{
			return true;
		}
		else
			return false;
	}
	//method to check if the parenthesis' in an equation are balanced
	public static boolean balancedParenthesis (String equation)
	{
		int openCount = 0;
		int closedCount = 0;
		
		for (int c = 0; c < equation.length(); c++)
		{
			if ('(' == equation.charAt(c))
			{
				openCount++;
			}
			if (')' == equation.charAt(c))
			{
				closedCount++;
			}
		}
		
		if (closedCount == openCount)
		{
			return true;
		}
		else
			return false;
		
	}

}
