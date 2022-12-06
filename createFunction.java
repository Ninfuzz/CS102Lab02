/*

* @author (Dylan I. Pace)

* <p> (File Name)

* <p> (Assignment)

* <p> (Describe, in general, the code contained.)

*/


import java.util.*;
public class createFunction
{
	Scanner scan = new Scanner (System.in);
	private double[] functionValues;
	private String[] operations;
	
	public createFunction(int numOfVariables)
	{
		int temp;
		functionValues = new double[numOfVariables];
		operations = new String[numOfVariables - 1];
		
		for (int c = 0; c < numOfVariables; c++)
		{
			System.out.println("Give me a value (one at a time) (remaining to give " + (numOfVariables - c) + ")");
			
			functionValues[c] = scan.nextDouble();
		}
		this.addOperations(numOfVariables);
		
	}
	public void addOperations(int numOfOperations)
	{
		System.out.println("What operations would you like to include? (choose " + (numOfOperations - 1) + ") (put operations in order)");
		
		for (int c = 0; c < numOfOperations;)
		{
			System.out.println("Operations left to give: " + (numOfOperations - 1 - c));
			System.out.println("1 - additon\n2 - subtraction\n3 - multiplication\n4 - division");
			
			if (scan.nextInt() == 1)
			{
				operations[c] = "+";
				c++;
			}
			else if (scan.nextInt() == 2)
			{
				operations[c] = "-";
				c++;
			}
			else if ( scan.nextInt() == 3)
			{
				operations[c] = "*";
				c++;
			}
			else if (scan.nextInt() == 4)
			{
				operations[c] = "/";
				c++;
			}
			else
			{
				System.out.println("Invalid option, try again.");
			}
			
		}
		
	}
	public double call ()
	{
		System.out.println("Give me the values (in order from left to right, one at a time)");
		for (int c = 0; c < functionValues.length; c++)
		{
			functionValues[c] = scan.nextDouble();
		}
		System.out.println("Your equation: \n" + this.equation());
		
		double temp = 0;
		
		for (int c = 0; c < functionValues.length; c++)
		{
			 if (c == 0)
			 {
				 temp = functionValues[c];
			 }
			 else if (c < functionValues.length - 1 && operations[c].equals("+"))
			 {
				 temp += functionValues[c];
			 }
			 else if (c < functionValues.length - 1 && operations[c].equals("-"))
			 {
				 temp -= functionValues[c];
			 }
			 else if (c < functionValues.length - 1 && operations[c].equals("*"))
			 {
				 temp *= functionValues[c];
			 }
			 else if (c < functionValues.length - 1 && operations[c].equals("/"))
			 {
				 temp /= functionValues[c];
			 }
			 else
			 {
				 if (operations[functionValues.length - 2].equals("+"))
				 {
					 temp += functionValues[functionValues.length - 1];
				 }
				 else if (operations[functionValues.length - 2].equals("-"))
				 {
					 temp -= functionValues[functionValues.length - 1];
				 }
				 else if (operations[functionValues.length - 2].equals("*"))
				 {
					 temp *= functionValues[functionValues.length - 1];
				 }
				 else if (operations[functionValues.length - 2].equals("/"))
				 {
					 temp /= functionValues[functionValues.length - 1];
				 }
			 }
		}
		System.out.print(this.equation() +" = " + temp);
		
		return temp;
		
	}
	public String equation()
	{
		String temp = "";
		for (int c = 0; c < functionValues.length; c++)
		{
			temp += functionValues[c];
			if (c < functionValues.length - 1)
			{
				temp += operations[c];
			}
		}
		return temp;
	}
	
	public String toString()
	{
		int tempInt;
		char tempChar;
		String temp = "";
		for (int c = 0; c < functionValues.length; c++)
		{
			tempInt = c + 65;
			tempChar = (char)tempInt;
			temp += tempChar;
			if (c < functionValues.length - 1)
			{
				temp += operations[c];
			}
		}
		return temp;
	}


}
