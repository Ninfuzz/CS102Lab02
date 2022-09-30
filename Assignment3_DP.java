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
public class Assignment3_DP
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String myString = scan.nextLine();
		if (uniqueChar(myString))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}

	}
	
	public static boolean uniqueChar (String a)
	{
		for (int c = 0; c < a.length(); c++)
		{
			for (int i = 0; i < a.length(); i++)
			{
				if (i!=c && a.charAt(i)==a.charAt(c) && a.charAt(i)+32 == a.charAt(c)+32)
				{
					return false;
				}
			}
		}
		return true;
	}

}
