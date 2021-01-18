package slotMachine;

public class Slot {
	private Column x; 
	private Column y; 
	private Column z;
	
	private int bet;

	// Construct a slot.
	public Slot() {
		this.x = new Column();
		this.y = new Column();
		this.z = new Column();
	}
	
	// To function the same as take_bet in the Python.
	public int getBet() {
		return (int) bet;
	}
	
	// Get score results for the play, function as score_slot in the Python.
	public double getScore(int bet) {
		if (this.x.face == this.y.face && this.x.face == this.z.face) {
			return this.bet * 2;
		}
		else if (this.x.face == this.y.face || this.y.face == this.z.face || this.x.face == this.z.face) {
			return this.bet * 1.5;
		}
		else {
			return 0;
		}

	}
	
	// To function the same as take_bet in the Python.
	public void setBet(int bet) {
		this.bet = bet;
	}
	
	// Pull handle == change face of the slot.
	public void pullHandle() {
		this.x.changeFace();
		this.y.changeFace();
		this.z.changeFace();
	}
	
	// Return a String representation, function as show_slot in the Python.
	@Override
	public String toString() {
		return x.face + " " + y.face + " " + z.face;
	}

}
