package FileHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import databases.EntityDatabase;
/**
 * @author Danyal Ahmed
 * @version 16/07/2018
 *
 */
public class createFile {

	public createFile(){
			cFile("MOVIES", EntityDatabase.getDB().getNames());

	}

	private void cFile(String file, ArrayList<String> arrData){
		 File f = new File(file+".txt");
//		 System.out.println("Size of Database in createFile = "+EntityDatabase.getDB().getNames().size());
	        try{

	      	BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
	     //       pw.println("This is supposed to print out in a new Line");
	    	int size = arrData.size();
	        for (int i=0;i<size;i++) {
	             String str = arrData.get(i).toString();
	             bw.append(str);
	             bw.write("\n");}
	            bw.flush();
	            bw.close();
	        }catch(IOException ex){
	            ex.printStackTrace();
	        }
	}


	public void cCSV(String file){
		 File f = new File(file);
		 String endMarker = "X";
//		 System.out.println("Size of Database in createFile = "+EntityDatabase.getDB().getNames().size());
	        try{

	      	BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
	     //       pw.println("This is supposed to print out in a new Line");

	             bw.append(endMarker);
	             bw.write("\n");
	             bw.append("Director"+"Title"+"Genre"+"Runtime"+"Comment"+"Rating"+"Year");
	            bw.flush();
	            bw.close();
	        }catch(IOException ex){
	            ex.printStackTrace();
	        }
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
