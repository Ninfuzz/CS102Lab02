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
public class SavingsAccount extends BankAccount
{
	private double annualInterestRate;
	
	public SavingsAccount (String owner, double balance, double AIR)
	{
		super (owner, balance);
		this.annualInterestRate = AIR;
	}
	
	public void depositMonthlyInterest()
	{
		this.deposit(balance*(annualInterestRate/12));
	}
	
	public void withdraw (double amount)
	{
		if (balance-amount < 0)
		{
			System.out.println("Not enough funds in " + this.getName() + "'s account!");
			
		}
		else 
			this.balance -= amount;
	}
}
