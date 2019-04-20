package serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import jpd.aston.lab6.model.Item;
/**
 * @author Danyal Ahmed
 * @version 16/07/2018
 *
 */
public class getFilms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Item getMovie(String b){
		 String filename ="database/"+ b +".ser";

		 Item object1 = null;
	    // Deserialization
	    try
	    {
	        // Reading the object from a file

	        FileInputStream file = new FileInputStream(filename);
	        ObjectInputStream in = new ObjectInputStream(file);
	        // Method for deserialization of object
   //         System.out.println("Will it enter ");

	        object1 = (Item)in.readObject();

	//        System.out.println("Yes it will");
	        in.close();
	        file.close();
//	        System.out.println("Object has been deserialized ");



	    }

	    catch(IOException ex)
	    {
//	        System.out.println("IOException is caught");
	    }

	    catch(ClassNotFoundException ex)
	    {
	        System.out.println("ClassNotFoundException is caught");
	    }
		return object1;

	}
}
