package serialize;

import databases.EntityDatabase;
import jpd.aston.lab6.model.Item;
/**
 * @author Danyal Ahmed
 * @version 16/07/2018
 *
 */

public class Deserial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void deserialize(){
		getFilms ds = new getFilms();

		for(int j=0; j<EntityDatabase.getDB().getNames().size();j++){

			String name = (EntityDatabase.getDB().getNames().get(j));
			Item b = ds.getMovie(name);
			EntityDatabase.getDB().addMovies(b);
			}
	}
}
