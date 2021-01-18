package slotMachine;

public class Purse {
	public double funds;
	
	public Purse() {
		this.funds = 10;
	}
	
	public double getBalance() {
		return funds;	
		
	}
	
	public double credit(double bet) {
		funds = funds + bet;
		return funds;
	}

	public void debit(int bet) {
		if(funds < bet) {
			;
		} else {
			funds = funds - bet;
		}
	}
	
}
