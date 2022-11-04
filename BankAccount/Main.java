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
public class Main
{
	
	public static void main(String[] args)
	{
		
		SavingsAccount joe = new SavingsAccount("Joe", 100.00, 0.01);
		CheckingAccount emily = new CheckingAccount("Emily", 200.00, 10.00);
		
		emily.deposit(50.00);
		System.out.println(emily.getBalance());
		
		joe.withdraw(25.00);
		System.out.println(joe.getBalance());
		
		emily.processCheck(50.00);
		emily.withdraw(100.00);
		System.out.println(emily.getBalance());
		
		joe.deposit(100.00);
		System.out.println(joe.getBalance());
		
		SavingsAccount sam = new SavingsAccount("Sam", 250.00, 0.005);
		
		joe.depositMonthlyInterest();
		sam.depositMonthlyInterest();
		System.out.println(joe.getBalance());
		System.out.println(sam.getBalance());
		
		emily.withdraw(500.00);
		System.out.println(emily.getBalance());
		joe.withdraw(500.00);
		System.out.println(joe.getBalance());

	}

}
