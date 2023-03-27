package semester_1;

import java.util.*;

abstract class Account { // abstract class is created
	static int balance = 6000;

	abstract void display();
}

class details {
	void disp() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter pin number:"); // accessing the account
		int pin = sc.nextInt();
		System.out.println("Pin number:" + pin);
		if (pin == 1234) {
			System.out.println("valid");
		} else {
			System.out.println("invalid");
			System.exit(0);
		}
	}

	void output() {
		System.out.println("Transaction processing..");
	}
}

class transfer extends details { // inheritance
	void output() {
		System.out.println("Credentials validated\n"); // method overriding
	}
}

class AccountHolder extends Account { // inheritence
	void display() {
		System.out.println("Current Balance in your account " + balance + "\n");
		System.out.println("Transaction Begins....\n");
	}

	public synchronized static void makeWithdrawal(String name, int amount) {
		if (balance >= amount) {
			System.out.println(name + " is going to withdraw Rs " + amount + "\n");
			System.out.println(">>>Transaction is successfull \n");
			balance = balance - amount;
			System.out.println("Balance after withdrawal: " + balance + "\n");
		} else {
			System.out.println("Not enough in account for " + name + " to withdraw" + "\n");
		}
	}
}

class ThreadWithdrawal extends Thread {
	String name;
	int amount;

	ThreadWithdrawal() { // default constructor
	}

	ThreadWithdrawal(String name) { // constructor overloading
		this.name = name;
	}

	ThreadWithdrawal(String name, int amount) {
		this.name = name;
		this.amount = amount;
	}

	public void run() {
		AccountHolder.makeWithdrawal(name, amount); // classname.methodname(....) calling the static method of
													// AccountHolder class
	}
}

public class User {
	public static void main(String[] args) {
		details d = new details();
		d.disp();
		transfer t = new transfer();
		t.output();
		ThreadWithdrawal t1 = new ThreadWithdrawal("Bhavya", 1000); // thread 1
		ThreadWithdrawal t2 = new ThreadWithdrawal("Charishma", 300);
//thread 2 
		Thread t3 = new ThreadWithdrawal("Anjali", 3000);
// dynamic dispatch 
		Thread t4 = new ThreadWithdrawal("Mahati", 2000);
// dynamic dispatch 
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		AccountHolder obj1 = new AccountHolder();
		obj1.display();
	}
}