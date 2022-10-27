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
import java.text.DecimalFormat;
public class BankAccount
{
	private String owner;
	double balance;
	
	DecimalFormat df = new DecimalFormat("0.00");
	
	public BankAccount (String owner, double balance)
	{
		this.owner = owner;
		this.balance = balance;
		
	}
	
	public void deposit (double amount)
	{
		balance += amount;
	}
	
	public void withdraw (double amount)
	{
		balance -= amount;
		
	}
	public String getBalance()
	{
		
		return "Balance of " + this.owner + ": " + df.format(balance);
	}
	public String getName()
	{
		return owner;
	}
}
