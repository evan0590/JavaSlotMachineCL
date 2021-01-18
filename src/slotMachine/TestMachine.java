package slotMachine;

import java.util.Scanner;

public class TestMachine {
	public static void main(String[] args) {

		// Create wallet object from Purse class.
		Purse wallet = new Purse();
		// Create a slot machine object from the Slot class
		Slot machine = new Slot();
		// Read bets from the user.
		Scanner input = new Scanner(System.in);
		System.out.println("==========  SLOT MACHINE  ==========");
		System.out.println("Minimum bet is 2. Type 'N' to exit. ");
		System.out.println("You have " + wallet.getBalance());
		while (wallet.funds > 1) {
			// The player is asked to place a bet.
			String stringBet = input.next();
			// The player has the option to quit the game by typing 'N'.
			if (stringBet.equals("N") || stringBet.equals("n")) {
				System.out.println("You typed 'N' - Thank you for playing.");
				break;
			}
			else {
				try {
					int intBet = Integer.parseInt(stringBet);
					// Convert bet to an integer value
					machine.setBet(intBet);
				}
				// Exception handling for when a non-integer value is entered.
			    catch (NumberFormatException nfe) {
			    	// Equivalent to pass in the Python
			    	;
			    }	
				finally {
					// Minimum bet is 2.
					if (machine.getBet() < 2) {
						System.out.println("Minimum bet is 2.");
						;
					}
					// Checking if integer is within available credit.
					else if (machine.getBet() > wallet.funds) {
						wallet.debit(machine.getBet());
					}
					// A valid number within credit has been entered.
					else {
						wallet.debit(machine.getBet());
						machine.pullHandle();
						System.out.println(machine.toString());
						wallet.credit(machine.getScore(machine.getBet()));
						// Player cannot continue if funds are below 2.
						if (wallet.funds < 2) {
							System.out.println("You score " + machine.getScore(machine.getBet()) + " - Thank you for playing.");
							System.out.println("You are leaving with " + wallet.getBalance() + ".");
						}
						else if (machine.getScore(machine.getBet()) == 0) {
							System.out.println("You score " + machine.getScore(machine.getBet()) + " - you have " + wallet.getBalance());
						}
						else {
							System.out.println("You score " + machine.getScore(machine.getBet()) + " - you have " + wallet.getBalance());
						}
					}
				}
			}
		}
		// Close the Scanner
		input.close();
	}

}
