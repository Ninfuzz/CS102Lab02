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
public class Assignment2_DP_1
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		int[] array0 = {1,77,-5,2,65,30};
		int[] array1 = {-10,50,15,2,77};
		
		System.out.println(contains(array0));
		System.out.println(contains(array1));

	}
	
	public static boolean contains(int[] a)
	{
		int num1 = 65;
		int num2 = 77;
		boolean check1 = false;
		boolean check2 = false;
		
		for (int c = 0; c < a.length; c++)
		{
			if (a[c] == num1)
			{
				check1 = true;
			}
			if (a[c] == num2)
			{
				check2 = true;
			}
		}
		if (check1 && check2)
		{
			return true;
		}
		return false;
	}

}
