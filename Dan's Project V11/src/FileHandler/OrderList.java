package FileHandler;

import databases.EntityDatabase;

/**
 * @author Danyal Ahmed
 * @version 16/07/2018
 *
 */
public class OrderList{
private InputReader reader;


//private String Runtime;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	/**
	 * This method gets the Database of movies file name from the GUI and launches the processorder() method.
	 */
	public OrderList(){

		reader = new InputReader("MOVIES.txt"); // this line creates a new InputReader using the sim file taken from the gui
		processOrder();
		//reader.deleteFile();
	//videoLoop();


		}

	/**
	 * This Method takes the sim and divides it into an array, and using matches and splits it takes and the relevant information
	 * and saves them into string variables
	 */

private void processOrder(){

while(reader.hasNext()){ // while the reader has a next line
String[] FileArray = reader.getInput();// Sim file is placed into a array

for(int i =0;i<FileArray.length;i++){
	String name = FileArray[i];
//	System.out.println(name);
   EntityDatabase.getDB().getNames().add(name);
}

}

reader.closeFile();
}

}






