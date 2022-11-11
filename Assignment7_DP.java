/*

* @author (Dylan I. Pace)

* <p> (Assignment7_DP)

* <p> (Assignment 07)

* <p> (Contains the methods for merge sort and a 4 peg towers of hanoi algorithm)

*/



import java.util.*;
public class Assignment7_DP
{
	int count = 0;
	
	public static void main(String[] args)
	{
		int[] array = new int[] {5, 0, 1, 8, 7, 4, 9};
		
		System.out.println("the array takes " + sort(array) + " actions to sort");
		
		System.out.println("Give me an int value for the amount of discs you want to use.");
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		System.out.println("The amount of actions taken to solve this was " + hanoiTowers(n, 'A', 'D', 'B', 'C') + " actions");

	}
	
	public static int sort(int[] array)
	{
		//initializing variables for counting and to hold the low and high values
		int tempCount = 0;
		int lowVal = array[0];
		int highVal = array[0];
		//skims the array for the lowest value
		for (int c = 0; c < array.length; c++)
		{
			if (lowVal > array[c])
			{
				lowVal = array[c];
			}
		}
		//skims the array for the highest value
		for (int c = 0; c < array.length; c++)
		{
			if (highVal < array[c])
			{
				highVal = array[c];
			}
		}
		//Indicates the program to go back to the last step in recursion
		if (highVal <= lowVal)
		{
			return tempCount;
		}
		//sets the mid value, where the split will happen
		int midVal = (lowVal + highVal)/2;
		//counts actions as it calls itself
		tempCount++;
		tempCount += sort(array, lowVal, midVal);
		tempCount++;
		tempCount += sort(array, midVal+1, highVal);
		//calls another method to do the actual sorting
		tempCount += merge(array, lowVal, midVal, highVal);
		//returns the count to the previous step
		return tempCount;
		
		
		
		
	}
	//Is another version of the above method that takes the low and high values on top of the array
	public static int sort(int[] array, int low, int high)
	{
		int tempCount = 0;
		int lowVal = low;
		int highVal = high;
		
		//returns to the previous step when the split has reached its smallest amount
		if (highVal <= lowVal)
		{
			return tempCount;
		}
		//calculates the mid value, where the split will occur
		int midVal = (lowVal + highVal)/2;
		//counts actions as it calls itself
		tempCount++;
		tempCount += sort(array, lowVal, midVal);
		tempCount++;
		tempCount += sort(array, midVal+1, highVal);
		//calls the merge method to do the actual sorting
		tempCount += merge(array, lowVal, midVal, highVal);
		
		return tempCount;
		
		
	}
	
	public static int merge(int[] array, int low, int mid, int high) 
	{
		int tempCount = 0;
	    // Creating temporary arrays
	    int leftSide[] = new int[mid - low + 1];
	    int rightSide[] = new int[high - mid];

	    // Copying our given array into temporary ones
	    for (int c = 0; c < leftSide.length; c++)
	    {
	    	leftSide[c] = array[c];
	    	tempCount++;
	    }
	    for (int c = 0; c < rightSide.length; c++)
	    {
	    	rightSide[c] = array[c];
	    	tempCount++;
	    }

	    // Variables holding the index values for both temporary arrays
	    int leftIndex = 0;
	    int rightIndex = 0;

	    // Copying the values from left and right arrays back into the given array
	    for (int c = 0; c < leftSide.length; c++) 
	    {
	        
	        if (c < leftSide.length)
	        {
	            // If all the elements from the right side of the array are copied, then program finishes left side
	            array[c] = leftSide[leftIndex];
	            leftIndex++;
	            tempCount++;
	        } 
	    }
	    for (int c = 0; c < rightSide.length; c++)
	    {
	        if (c < rightSide.length)
	        {
	            // If all the elements from the left side of the array are copied, then program finishes the right side
	            array[c] = rightSide[rightIndex];
	            rightIndex++;
	            tempCount++;
	        }
	    }
	    
	    return tempCount;
	}
	
	static int hanoiTowers(int n, char fromRod, char toRod, char helpRod1, char helpRod2)
	{
		//Keeps count of the amount of actions taken
		int tempCount = 0;
		//returns to the last step when there is no more disc to move
		if (n == 0)
		{
			return tempCount;
		}
		//does the last action and returns back a step when on the last disc
		if (n == 1) 
		{
			System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
			tempCount++;
			return tempCount;
		}

			tempCount += hanoiTowers(n - 2, fromRod, helpRod1, helpRod2, toRod);
			
			System.out.println("Move disk " + (n - 1) + " from rod " + fromRod + " to rod " + helpRod2);
			tempCount++;
			System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
			tempCount++;
			System.out.println("Move disk " + (n - 1) + " from rod " + helpRod2 + " to rod " + toRod);
			tempCount++;
			
			tempCount += hanoiTowers(n - 2, helpRod1, toRod, fromRod, helpRod2);
			
			return tempCount;
		}

			
}
