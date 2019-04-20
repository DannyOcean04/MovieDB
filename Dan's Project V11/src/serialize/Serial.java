package serialize;

import databases.EntityDatabase;
/**
 * @author Danyal Ahmed
 * @version 16/07/2018
 *
 */

public class Serial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void serialize(){

		saveFilms s = new saveFilms();


		for(int i=0; i<EntityDatabase.getDB().getMOVIE().size();i++){
       String n = EntityDatabase.getDB().getMOVIE().get(i).getFName().trim();
		s.saveToFile(EntityDatabase.getDB().getMOVIE().get(i), n);
   //     System.out.println(EntityDatabase.getDB().getMOVIE().get(i));
		}
	}
}
