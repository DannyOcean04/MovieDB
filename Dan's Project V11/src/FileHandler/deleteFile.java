package FileHandler;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import databases.EntityDatabase;
/**
 * @author Danyal Ahmed
 * @version 16/07/2018
 *
 */
public class deleteFile {



public deleteFile(){


}

public void removeMovie(String title){
	String t = title.trim();

	for(int i=0; i<EntityDatabase.getDB().getNames().size();i++){
//System.out.println(title);

		if(EntityDatabase.getDB().getNames().get(i).equals(t)){
		//	String a = EntityDatabase.getDB().getNames().get(i).trim();


			deleteTheFile(t);
			EntityDatabase.getDB().getNames().remove(i);
			EntityDatabase.getDB().getMOVIE().remove(i);
		}
      }
}




public void deleteTheFile(String a){
	try
    {
        Files.deleteIfExists(Paths.get("database/"+a+".ser"));
    }
    catch(NoSuchFileException e)
    {
  //      System.out.println("No such file/directory exists");
    }
    catch(DirectoryNotEmptyException e)
    {
 //       System.out.println("Directory is not empty.");
    }
    catch(IOException e)
    {
 //       System.out.println("Invalid permissions.");
    }

//   System.out.println("File Deletion successful.");

}

public void deleteTheList(String a){
	try
    {
        Files.deleteIfExists(Paths.get(a));
    }
    catch(NoSuchFileException e)
    {
//        System.out.println("No such file/directory exists");
    }
    catch(DirectoryNotEmptyException e)
    {
//        System.out.println("Directory is not empty.");
    }
    catch(IOException e)
    {
//        System.out.println("Invalid permissions.");
    }

//    System.out.println("Text File Deletion successful.");
}
}



