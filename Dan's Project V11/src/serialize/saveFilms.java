package serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import jpd.aston.lab6.model.Item;
/**
 * @author Danyal Ahmed
 * @version 16/07/2018
 *
 */

public class saveFilms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void saveToFile(Item object, String a){
		String filename = "database/"+ a +".ser";

	    // Serialization
	    try
	    {
	        //Saving of object in a file
	        FileOutputStream file = new FileOutputStream(filename);
	        ObjectOutputStream out = new ObjectOutputStream(file);
	        // Method for serialization of object
	        out.writeObject(object);
	        out.close();
	        file.close();

//	        System.out.println("Object has been serialized");

	    }

	    catch(IOException ex)
	    {
//	        System.out.println("IOException is caught");
	    }


	}


}
