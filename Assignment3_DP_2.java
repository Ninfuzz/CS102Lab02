/*

* @author (Dylan I. Pace)

* <p> (File Name)

* <p> (Assignment)

* <p> (Describe, in general, the code contained.)

*/

/**
 * @author Ninfuzz
 *
 */
import java.util.Scanner;
public class Assignment3_DP_2
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String myString = scan.nextLine();
		
		if (palindrome(myString))
		{
			System.out.println(myString + " is a palindrome.");
		}
		else
		{
			System.out.println(myString + " is not a palindrome.");
		}

	}
	public static boolean palindrome(String a)
	{
		String temp = "";
		
		for (int c = a.length()-1; c > -1; c--)
		{
			temp += a.charAt(c);
		}
		
		if (a.equalsIgnoreCase(temp))
		{
			return true;
		}
		return false;
		
	}

}
