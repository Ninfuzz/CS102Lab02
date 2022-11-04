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
public class CheckingAccount extends BankAccount
{
	
	private double insufficientFundsFee;

	public CheckingAccount (String owner, double balance, double IFF)
	{
		super (owner, balance);
		insufficientFundsFee = IFF;
	}
	
	public void processCheck (double checkAmount)
	{
		 this.deposit(checkAmount);
	}
	
	public void withdraw (double amount)
	{
		this.balance -= amount;
		if (balance < 0)
		{
			this.balance -= insufficientFundsFee;
		}
	}
	
	
}
