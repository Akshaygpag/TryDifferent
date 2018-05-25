
package com.bridgelabz.datastructures.programs;

import com.bridgelabz.algorithm.impl.QueueImpl;
import com.bridgelabz.algorithm.interfaces.Queue;
import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 23-May-2018
 */
public class BankingApplication {

    /**
     * @param args
     * 
     */
    private long balanceAmount;

    public BankingApplication(long balanceAmount) {
	super();
	this.balanceAmount = balanceAmount;
    }

    public static void main(String[] args) {
	// THIS METHOD WILL START THE QUEUE AND THEN ADD AND REMOVE PEOPLE
	// IT WILL HAVE AN INITAL BALANCE

	System.out.println("Enter the initial amount of money the cashier must hold ");
	long money = Utility.getLongValue();
	BankingApplication bankCounter = new BankingApplication(money);
	bankCounter.open();

    }

    /**
     * 
     * 
     */
    private void open() {
	// THIS METHOD WILL START THR BANK COUNTER
	Queue bankCustomersQueue = new QueueImpl();
	Queue largeWithdrawCustomers = new QueueImpl();

	boolean stop = false;
	while (!stop) {
	    System.out.println();
	    System.out.println("---------------------");
	    System.out.println("Current balance is : " + this.balanceAmount);

	    System.out.println("---------------------");

	    System.out.println();

	    System.out.println("Enter 1.Add customer");
	    System.out.println("Enter 2.Remove customer");

	    System.out.println("Enter 3 to exit and close the counter");
	    int choice = Utility.getIntergerValue();

	    if (choice == 3) {
		stop = true;
	    }
	    if (choice == 2) {

		// remove the customer from the queue

		if (largeWithdrawCustomers.isEmpty()) {
		    if (bankCustomersQueue.isEmpty()) {
			System.out.println("empty queue");

		    }

		    else {
			this.requestHandler(largeWithdrawCustomers, bankCustomersQueue);
			// Node currentCustomer = bankCustomersQueue.dequeue();
			//
			// System.out.println("The number of customer in the queue are : " +
			// bankCustomersQueue.size());
			// System.out.println("normal queue entry : removal :: " + currentCustomer);
			// long requestMoney = (long) currentCustomer.getInfo();
			// if (requestMoney > 0) {
			//
			// balanceAmount += requestMoney;
			//
			// } else {
			// if (this.balanceAmount >= Math.abs(requestMoney)) {
			//
			// this.balanceAmount -= Math.abs(requestMoney);
			//
			// } else {
			// // THE MONEY REQUESTED IS LARGER PUT HIM IN THE WAITING QUEUE
			//
			// largeWithdrawCustomers.enqueue(currentCustomer);
			// System.out.println(
			// "customer has entered the waiting queue : " + largeWithdrawCustomers.size());
			// }
			//
			// }

		    }
		}

		else {
		    // IF LARGEWITHDRAW IS NOT EMPTY THE CHECK
		    this.handlelargeTransactionCustomers(largeWithdrawCustomers, bankCustomersQueue);
		}
	    }
	    if (choice == 1) {
		this.addCustomers(bankCustomersQueue);

	    }

	}
	System.out.println("The end of the day balance at the counter is : " + this.balanceAmount);
    }

    /**
     * @param largeWithdrawCustomers
     * @param bankCustomersQueue
     * 
     */
    private void handlelargeTransactionCustomers(Queue largeWithdrawCustomers, Queue bankCustomersQueue) {
	System.out.println("Entering th epart where the large customer billers are there");

	Node waitingCustomer = largeWithdrawCustomers.peek();

	System.out.println("Waiting queue contains customer " + waitingCustomer);

	if (this.balanceAmount >= Math.abs((long) waitingCustomer.getInfo())) {

	    waitingCustomer = largeWithdrawCustomers.dequeue();

	    this.balanceAmount -= Math.abs((long) waitingCustomer.getInfo());

	} else {
	    // KEEP WAITING TILL THE BALANCE IS BUILT UP....
	    this.requestHandler(largeWithdrawCustomers, bankCustomersQueue);
	}

    }

    /**
     * @param largeWithdrawCustomers
     * @param bankCustomersQueue
     * 
     */
    private void requestHandler(Queue largeWithdrawCustomers, Queue bankCustomersQueue) {
	Node currentCustomer = bankCustomersQueue.dequeue();
	if (currentCustomer == null) {
	    return;
	}
	System.out.println("The number of customer in the queue are : " + bankCustomersQueue.size());
	System.out.println("normal queue entry : removal :: " + currentCustomer);
	long requestMoney = (long) currentCustomer.getInfo();
	if (requestMoney > 0) {

	    balanceAmount += requestMoney;

	} else {
	    if (this.balanceAmount >= Math.abs(requestMoney)) {

		this.balanceAmount -= Math.abs(requestMoney);

	    } else {
		// THE MONEY REQUESTED IS LARGER PUT HIM IN THE WAITING QUEUE

		largeWithdrawCustomers.enqueue(currentCustomer);
		System.out.println("customer has entered the waiting queue : " + largeWithdrawCustomers.size());
	    }

	}

    }

    /**
     * @param bankCustomersQueue
     * 
     */
    private void addCustomers(Queue bankCustomersQueue) {
	Node customer = new Node();
	System.out.println("Enter with sign to deposit or (-)withdraw or deposit");
	customer.setInfo(Utility.getLongValue());
	bankCustomersQueue.enqueue(customer);

    }

}
