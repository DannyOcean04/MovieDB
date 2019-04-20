package databases;

import java.util.ArrayList;

import jpd.aston.lab6.model.Item;

/**
 * @author Danyal Ahmed
 * @version 16/07/2018
 *
 */
public class EntityDatabase {
	private static EntityDatabase db = new EntityDatabase();

	  private ArrayList<Item>MOVIE;
	  private ArrayList<String>names;
	//Constructor
	private EntityDatabase(){

	}
	public static EntityDatabase getDB(){
		if(db==null){
			db = new EntityDatabase();
		}
		return db;
	}
	/**
	 * Creates hashMaps to store Robots and Entities
	 */
	public void createDatabases(){
		setMOVIE(new ArrayList<Item>());
		setNames(new ArrayList<String>());
	}

	public ArrayList<Item> getMOVIE() {
		return MOVIE;
	}
	public void setMOVIE(ArrayList<Item> MOVIE) {
		this.MOVIE=MOVIE;
	}
	public void addName(String n){
		names.add(n);
	}

	public void addMovies(Item I){
		MOVIE.add(I);
	}
	public ArrayList<String> getNames() {
		return names;
	}
	public void setNames(ArrayList<String> names) {
		this.names = names;
	}


}


