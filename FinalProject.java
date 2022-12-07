/*

* @author (Dylan I. Pace)

* <p> (File Name)

* <p> (Assignment)

* <p> (Describe, in general, the code contained.)

*/

import java.util.*;
import java.text.DecimalFormat;
public class FinalProject
{
	//Class level variables for the audit log, scanner, and decimal format
	static DecimalFormat df = new  DecimalFormat("0.00");
	static Scanner scan = new Scanner (System.in);
	static ArrayList<String> log = new ArrayList<String>();
	static createFunction[] custom = new createFunction[3];
	static double customAns;
	public static void main(String[] args)
	{
		
		int count = 1;
		//Variable to hold value that the user gives
		int choice;
		//Lets the user choose whether to go to the function menu or to view the audit log
		do
		{
		System.out.println("What would you like to do? (1 to go to functions, 2 to view usage log, 3 to create a function, 0 to quit)");
		
		choice = scan.nextInt();
		
		if (choice == 1)
		{
			functions();
		}
		else if (choice == 2)
		{
			System.out.println("Usage Log:\n");
			for (int c = 0; c < log.size(); c++)
			{
				System.out.println(log.get(c));
			}
		}
		else if (choice == 3)
		{
			if (count <= 3)
			{
				int temp;
				System.out.println("Give me the amount of variables in your function.");
				do
				{
					temp = scan.nextInt();
					if (temp <= 0)
					{
						System.out.println("Invalid option, try again.");
					}
				} while (temp <= 0);
				
				if (count == 1)
				{
					createFunction one = new createFunction(temp);
					custom[count-1] = one;
					count++;
				}
				else if (count == 2)
				{
					createFunction two = new createFunction(temp);
					custom[count-1] = two;
					count++;
				}
				else
				{
					createFunction three = new createFunction(temp);
					custom[count-1] = three;
					count++;
				}
			}
			
			
		
			
		}
		else if (choice != 0)
		{
			System.out.println("Invalid choice, try again.");
		}
		}while (choice != 0);
		
		System.out.println("Thank you, have a nice day!");

	}
	//Method for the function menu
	public static void functions()
	{
		//Holds the favorites of the user (up to 3)
		String[] favorites = new String[3];
		int choice;
		
		do
		{
			System.out.println("Which function would you like to perform? (0 to quit)");
			System.out.println("Your favorites:");
			//Presents the favorites of the user at the top
			for (int c = 0; c <favorites.length; c++)
			{
				if (favorites[c] != null)
				{
					System.out.println(favorites[c]);
				}
				else
				{
					System.out.println("<empty>");
				}
			}
			System.out.println("Your Functions (6, 7, or 8): ");
			for (int c = 0; c < custom.length; c++)
			{
				if (custom[c] != null)
				{
					System.out.println("(Custom Function)");
				}
				else
				{
					System.out.println("<empty>");
				}
			}
			
			System.out.println("To add a function to favorites type -1");
			//Presents the function options
			System.out.println("Banking:\n1 - Simple Interest \n2 - Compound Interest");
			System.out.println("Graphs:\n3 - Slope ");
			System.out.println("Arithmetic:\n4 - Factorial \n5 - Half Life");
		
			choice = scan.nextInt();
			//Code for setting up a favorite or removing/replacing one
			if (choice == -1)
			{
				int change;
				do
				{
					
					System.out.println("Which slot would you like to add to/delete from? (from 1 - 3, 4 to return to menu)");
					change = scan.nextInt();
					//Checks if the value given is an option
					if (change != 1 && change != 2 && change != 3)
					{
						System.out.println("Invalid option, try again.");
					}
					//Will add a favorite if the slot chosen is empty
					else if (favorites[change - 1] == null)
					{
						favorites[change - 1] = addFavorite();	
					}
					//If the slot is full asks if the user wants the value to be replaced
					else
					{
						System.out.println("That spot is full, would you like to replace it? (type 1 if you would like to, type any other integer if not)");
						int yesNo = scan.nextInt();
						
						if (yesNo == 1)
						{
							favorites[change - 1] = addFavorite();
						}
						else
						//Goes back to function method if the user chooses to not replace the favorite
						{
							change = 4;
						}
					}
				}while ( change != 1 && change != 2 && change != 3 && change != 4);
			}
			//Calls the method for simple interest
			else if (choice == 1)
			{
				sInterest();
			}
			//Calls the method for compound interest
			else if (choice == 2)
			{
				cInterest();
			}
			//Calls the method for slope
			else if (choice == 3)
			{
				slope();
			}
			//Calls the method for setting up a factorial
			else if (choice == 4)
			{
			factorialSetup();
			}
			//Calls the method for half lives
			else if (choice == 5)
			{
				halfLife();
			}
			else if (choice == 6)
			{
				customAns = custom[0].call();
				log.add("(custom1): " + customAns);
			}
			else if (choice == 7)
			{
				customAns = custom[1].call();
				log.add("(custom2): " + customAns);
			}
			else if (choice == 8)
			{
				customAns = custom[2].call();
				log.add("(custom3): " + customAns);
			}
			//Checks if the value given is an option
			else if (choice != 0)
			{
				System.out.println("Invalid Option, Try Again.");
			}
		}while (choice != 0);
	}
	//Method for calculating simple interest
	public static void sInterest()
	{
		//Creating variables for simple interest
		double principal;
		double interestRate;
		int time;
		
		//Collecting values from user
		System.out.println("What is the starting amount?");
		principal = scan.nextDouble();
		
		System.out.println("What is the interest rate (as a decimal)?");
		interestRate = scan.nextDouble();
		
		System.out.println("How many years do you want to calculate for?");
		time = scan.nextInt();
		
		//Calculating simple interest
		double interest = (double)(principal * interestRate * time);
		//Displays answer
		System.out.println("Amount of interest generated: " + interest);
		//Adds this calculation into the audit log
		log.add("(sInterest): " + principal + " * " + interestRate + " * " + time + " = " + df.format(interest));
	}
	//Method for calculating compound interest
	public static void cInterest()
	{
		//Creating variables for compound interest
		double principal;
		double interestRate;
		int periods;
		int time;
		
		//Collects values from the user
		System.out.println("What is the starting amount?");
		principal = scan.nextDouble();
		
		System.out.println("What is the annual interest rate (as a decimal)?");
		interestRate = scan.nextDouble();
		
		System.out.println("How many periods are going to pass?");
		periods = scan.nextInt();
		
		System.out.println("How many years are passing?");
		time = scan.nextInt();
		
		//Calculates compound interest
		double newValue = (double)(principal * Math.pow((1 + interestRate/periods), (periods*time)));
		//Displays answer
		System.out.println("New value after interest: " + newValue);
		//Adds this calculation to the audit log
		log.add("(cInterest): " + principal + "(1 + " + interestRate + " / " + periods + ")^(" + periods + "*" + time + ") = " + df.format(newValue));
	}
	//Method for calculating slope
	public static void slope()
	{
		//creates variables for slope
		int x1;
		int x2;
		int y1;
		int y2;
		
		//Collects values from user
		System.out.println("What is the value of x1?");
		x1 = scan.nextInt();
		
		System.out.println("What is the value of x2?");
		x2 = scan.nextInt();
		
		System.out.println("What is the value of y1?");
		y1 = scan.nextInt();
		
		System.out.println("What is the value of y2?");
		y2 = scan.nextInt();
		
		//Calculates slope
		double slope = (double)((y2 - y1)/(x2 - x1));
		//Displays answer
		System.out.println("The slope of your graph is " + slope);
		//Adds this calculation to the audit log
		log.add("(slope): (" + y2 + " - " + y1 + ")/(" + x2 + " - " + x1 + ") = " + df.format(slope));
	}
	//Method for setting up a factorial
	public static void factorialSetup()
	{
		//Creates variables for factorial
		int answer;
		int number;
		
		//Collects values from user
		System.out.println("What number would you like to find the factorial of?");
		
		number = scan.nextInt();
		//Calls the method for calculating factorial
		answer = factorial(number);
		//Displays answer
		System.out.println("The factorial of " + number + " is " + answer);
		//Adds this calculation to the audit log
		log.add("(factorial): " + number + "! = " + answer);
	}
	//Method for calculating factorial
	public static int factorial(int a)
	{
		if (a == 0)
		{
			return 1;
		}
		else
		{
			return (a * factorial(a - 1));
		}
	}
	//Method for calculating half lives
	public static void halfLife()
	{
		//Creates variables for half lives
		double oAmount;
		int time;
		int decayRate;
		
		//Collects values from user
		System.out.println("This half life formula calculates the amount of \na substance remaining after an amount of time.");
		System.out.println("What is the starting amount (in grams)?");
		oAmount = scan.nextDouble();
		
		System.out.println("What is the amount of time (in days)?");
		time = scan.nextInt();
		
		System.out.println("What is the decay rate of the substance (in days)?");
		decayRate = scan.nextInt();
		
		//Calculates half life
		double nAmount = (double)(oAmount*Math.pow(0.5,time/decayRate));
		//Displays answer
		System.out.println("The amount of the substance that would be left over after " + time + " days is " + df.format(nAmount));
		//Adds this calculation to the audit log
		log.add("(halfLife): " + oAmount + "(0.5)^(" + time + "/" + decayRate + ") = " + df.format(nAmount));
	}
	//Method to add/remove a favorite
	public static String addFavorite()
	{
		//Variable for user input
		int choice;
		//Collects value from user
		System.out.println("Which function would you like to add to favorites?");
		System.out.println("Banking:\n1 - Simple Interest \n2 - Compound Interest");
		System.out.println("Graphs:\n3 - Slope ");
		System.out.println("Arithmetic:\n4 - Factorial \n5 - Half Life");
		System.out.println("type any other int to delete this favorite.");
		choice = scan.nextInt();
		
		//Adds function to favorite or deletes favorite in slot
			if (choice == 1)
			{
				return "1 - Simple Interest";
			}
			else if (choice == 2)
			{
				return "2 - Compound Interest";
			}
			else if (choice == 3)
			{
				return "3 - Slope";
			}
			else if (choice == 4)
			{
				return "4 - Factorial";
			}
			else if (choice == 5)
			{
				return "5 - Half Life";
			}
			else
			{
				return null;
			}

	}

}
