package OpenFile;

import java.util.ArrayList;

import FileHandler.InputReader;
import jpd.aston.lab6.model.Item;

/**
 * @author Danyal Ahmed
 * @version 16/07/2018
 *
 */
public class OPENCSV{
private InputReader reader;
private ArrayList<Item>theVids;
private ArrayList<String>Directors;
private ArrayList<String>Titles;
private ArrayList<Integer>Runtimes;
private ArrayList<String>Comments;
private ArrayList<Integer>Ratings;
private ArrayList<String>Genres;
private ArrayList<Integer>Years;
private String Director;
private String Title;
private int Runtime;
private int Rating;
private int Year;
private String Genre;

private String Comment;

//private String Runtime;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	/**
	 * This method gets the Database of movies file name from the GUI and launches the processorder() method.
	 */
	public OPENCSV(){

		reader = new InputReader("MoviesDatabase.csv"); // this line creates a new InputReader using the sim file taken from the gui
       theVids = new ArrayList<Item>();
       setDirectors(new ArrayList<String>());
       setTitles(new ArrayList<String>());
       setRuntimes(new ArrayList<Integer>());
       setComments(new ArrayList<String>());
       setRatings(new ArrayList<Integer>());
       setGenres(new ArrayList<String>());
       setYears(new ArrayList<Integer>());
		csvTest();
	//	videoLoop();


		}

	/**
	 * This Method takes the sim and divides it into an array, and using matches and splits it takes and the relevant information
	 * and saves them into string variables
	 */


private void csvTest(){
	//while(reader.hasNext()){ // while the reade
String endMarker = "X";
boolean finished = false;

while(!finished){
	String[] FileArray = reader.getInput();
	if(FileArray[0].equals(endMarker)){
	    finished = true;}
	else{
//DIRECTOR
String c[] =  FileArray[0].split(" ");//it will split the string depend on the spaces in the string
StringBuilder db = new StringBuilder();
for (int counter = 0; counter < c.length; counter++) {
db.append(c[counter]).append(" ");}
Director = db.toString();
Directors.add(Director);
//System.out.println(Director);

//TITLE
String a[] =  FileArray[1].split(" ");//it will split the string depend on the spaces in the string
StringBuilder tb = new StringBuilder();
for (int counter = 0; counter < a.length; counter++) {
tb.append(a[counter]).append(" ");}
Title = tb.toString();
Titles.add(Title);
//System.out.println(Title);

//GENRE
String gen[] =  FileArray[2].split(" ");//it will split the string depend on the spaces in the string
StringBuilder g = new StringBuilder();
for (int counter = 0; counter < gen.length; counter++) {
 g.append(gen[counter]).append(" ");}
Genre = g.toString();
Genres.add(Genre);
//System.out.println(Genre);


//RUNTIME
String t = FileArray[3];
Runtime = Integer.parseInt(t);
Runtimes.add(Runtime);
//System.out.println(Runtime);

//COMMENT
String com[] =  FileArray[4].split(" ");//it will split the string depend on the spaces in the string
StringBuilder cb = new StringBuilder();
for (int counter = 0; counter < com.length; counter++) {
 cb.append(com[counter]).append(" ");}
Comment = cb.toString();
Comments.add(Comment);
//System.out.println(Comment);

//RATING
String r = FileArray[5];
Rating = Integer.parseInt(r);
Ratings.add(Rating);
//System.out.println(Rating);

//YEAR
String y = FileArray[6];
Year = Integer.parseInt(y);
Years.add(Year);



		}}

		for(int w = 0; w<Directors.size();w++){
		addVids(Titles.get(w), Directors.get(w),Runtimes.get(w), Comments.get(w), Ratings.get(w),Genres.get(w), Years.get(w));}


		reader.closeFile();
}

























public void addVids(String T, String D, int RU, String C, int RA, String G, int Y ){
	Item V = new Item(T, D, G, RU, RA, C, Y);
    theVids.add(V);
}


public ArrayList<Item> getVids() {
	return theVids;
}
public ArrayList<String> getDirectors() {
	return Directors;
}
public void setDirectors(ArrayList<String> directors) {
	Directors = directors;
}
public ArrayList<String> getTitles() {
	return Titles;
}
public void setTitles(ArrayList<String> titles) {
	Titles = titles;
}
public ArrayList<Integer> getRuntimes() {
	return Runtimes;
}
public void setRuntimes(ArrayList<Integer> runtimes) {
	Runtimes = runtimes;
}
public ArrayList<String> getComments() {
	return Comments;
}
public void setComments(ArrayList<String> comments) {
	Comments = comments;
}
public ArrayList<Integer> getRatings() {
	return Ratings;
}
public void setRatings(ArrayList<Integer> ratings) {
	Ratings = ratings;
}
public ArrayList<String> getGenres() {
	return Genres;
}
public void setGenres(ArrayList<String> genres) {
	Genres = genres;
}
public ArrayList<Integer> getYears() {
	return Years;
}
public void setYears(ArrayList<Integer> Years) {
	this.Years = Years;
}

}