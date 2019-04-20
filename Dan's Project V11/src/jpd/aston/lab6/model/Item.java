package jpd.aston.lab6.model;

import java.io.Serializable;

/**
 * The Item class represents a multi-media item. Information about the item is
 * stored and can be retrieved. This class serves as a superclass for more
 * specific items.
 *
 * @author Danyal Ahmed
 * @version 24/04/2018
 */
public class Item implements Serializable {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
		/**
		 *
		 */
		private static final long serialVersionUID = 2097858943345190818L;
		private final String title;
		private final int playingTime;
		private String comment = new String("");
		private final int rating;
		private final String director;
		private final String genre;
		private final int year;
		private String fName = new String("");

		/**
		 * Initialise the fields of the item.
		 */
		public Item(String theTitle, String theDirector, String theGenre, int time, int theRating, String theComment, int theYear) {
			title = theTitle;
			playingTime = time;
			rating = theRating;
			director = theDirector;
			comment = theComment;
			genre = theGenre;
			year = theYear;
		}


 public String getFName(){
	 String a[] = director.split(" ");
	 fName = a[a.length-1] + title.trim();
	 return fName;
 }


		public String getTitle(){
			return title;
		}

		/**
		 * Enter a comment for this item.
		 */
		public void setComment(String comment) {
			this.comment=comment;
		}

		/**
		 * Return the comment for this item.
		 */
		public String getComment() {
			return comment;
		}

		/**
		 * Returns the playing time for this item.
		 */
		public int getPlayingTime() {
			return playingTime;
		}
		public int getTheRating() {
			return rating;
		}
		public String getDirector() {
			return director;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(
				String.format("Title: " + title + "\n" + "Director: "+ director ));
			sb.append("\n"+ "Rating: " + getTheRating()+" / 5"+ "\n\n");
			return sb.toString();
		}





		public String getGenre() {
			return genre;
		}





		public int getYear() {
			return year;
		}
}
