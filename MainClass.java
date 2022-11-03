/*

* @author (Dylan I. Pace)

* <p> (File Name)

* <p> (Assignment)

* <p> (Describe, in general, the code contained.)

*/

public class MainClass
{

	
	public static void main(String[] args)
	{
		
		int n=2;
		hanoiTowers(n, 'A', 'C', 'B');

	}
	
	static void hanoiTowers (int n, char fromRod, char toRod, char helpRod)
	{
		if (n == 1)
		{
			System.out.println("Take a disc from rod " + fromRod + " and put it on " + toRod);
			
			return;
		}
		hanoiTowers (n-1, fromRod, helpRod, toRod);
		
		System.out.println("Take disc " + n + " from rod " + fromRod + " and place it on " + toRod);
		hanoiTowers (n-1, helpRod, toRod, fromRod);
		
	}

}
