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
public class Assignment2_DP
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] array0 = {1,5,-5,2,12,30};
		int[] array1 = {-10,50,15,2};
		
		System.out.println(common(array0, array1));
		
		

	}
	
	public static String common (int[] a, int[] b)
	{
		String common = "";
		for (int c = 0; c < a.length; c++)
		{
			for (int i = 0; i < b.length; i++)
			{
				if (a[c] == b[i])
				{
					common += a[c] + " ";
				}
			}
		}
		return "Common Elements: " + common;
	}

}
