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
public class Assignment2_DP_2
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		char[] array = {'s','a','b','a'};
		
		System.out.println(reverse(array));

	}
	
	public static String reverse(char[] a)
	{
		String temp = "";
		
		for (int c = a.length-1; c > -1; c--)
		{
			temp += a[c] + " ";
		}
		return temp;
	}

}
