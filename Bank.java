abstract class Account {

	protected double amount;

	public Account (){

		amount = 0.00;
	}

	public void deposit (double m){

		amount += m;
	}

	public void withdraw (double m){

		if (amount < m)
			System.out.println("Insufficient funds");
		else
			amount -= m;
	}

	abstract public void show ();

	abstract public double dailyInterest();
}

class Checking extends Account{

	public void show(){

		System.out.println("Checking Balance: " + String.format("%.2f", amount));
	}

	public double dailyInterest(){

		double interest = 0;

		if (amount < 1000)
			System.out.println("Less then $1000; Cannot recieve interest.");
		else
			interest = amount * 0.03;
			deposit((float) interest);

		return interest;	
	}
}


class Saving extends Account{

	public void show(){

		System.out.println ("Savings Balance: " + String.format("%.2f", amount));
	}

	public double dailyInterest(){

		double interest = amount * 0.06;

		deposit((float)interest);
		return interest;
	}

}

public class Bank{

	public static void main (String[] args){

		Account test[] = new Account[2];

		test[0] = new Saving();
		test[1] = new Checking();

		test[0].deposit(350.50);
		test[0].dailyInterest();
		test[0].show();
		test[0].withdraw(400);
		test[0].withdraw(100);
		test[0].show();

		test[1].deposit(900.32);
		test[1].dailyInterest();
		test[1].deposit(231.23);
		test[1].dailyInterest();
		test[1].show();
		test[1].withdraw(100);
		test[1].show();
	}
}