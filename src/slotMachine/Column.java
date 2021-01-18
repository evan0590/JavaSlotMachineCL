package slotMachine;

import java.util.Random;
// 🍇 grape
// 🍉 watermelon
// 🍋 lemon
public class Column {
	//	Declaring, creating, initializing an array of faces.
	public String[] faces = {"🍇", "🍉", "🍋"};
	public String face; // The face of the column
	
	// Construct a column with a random face.
	public Column() {
	    int rnd = new Random().nextInt(faces.length);
	    this.face = faces[rnd];
	}
	
	// Function similar to change_face in the Python
	public void changeFace() {
	    int rnd = new Random().nextInt(faces.length);
	    this.face = faces[rnd];
	}

}
