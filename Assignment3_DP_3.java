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
public class Assignment3_DP_3
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String myString = scan.nextLine();
		
		System.out.println(uppercase(myString));

	}
	
	public static char[] uppercase(String a)
	{
		char[] temp = a.toCharArray();
		for(int c = 0; c < temp.length; c++)
		{
			if (temp[c] == 32 && temp[c+1] > 90 && temp[c-1] == 46 || c == 0 && temp[c+1] > 90)
			{
				if (c != 0)
				{
					temp[c+1] -= 32;
				}
				else
					temp[c] -= 32;
			}
		}
		return temp;
	}

}
