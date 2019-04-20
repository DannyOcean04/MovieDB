package jpd.aston.lab6;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import jpd.aston.lab6.model.Item;
/**
 * @author Danyal Ahmed
 * @version 16/07/2018
 *
 */
public class ExtraInformation {

	@FXML private TextArea EIB;
	private Item A;

	public ExtraInformation(Item I){
		A = I;
	}


	public String extra(Item I) {
		StringBuilder sb = new StringBuilder(
			String.format("Genre: " + I.getGenre() + "\n" + "Runtime:  %s ", I.getPlayingTime() +" mins" ));
		sb.append("\n"+ "Year: " + I.getYear());
		sb.append("\n"+"Comment: "+ I.getComment() + "\n");
		return sb.toString();
	}

	@FXML public void loadPressed(){
		EIB.setText(extra(A));
	}

	@FXML public void initialize(){
		EIB.setText(extra(A));
	}
}
