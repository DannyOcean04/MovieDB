package jpd.aston.lab6;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import jpd.aston.lab6.model.Item;
/**
 * Adds a Video Item to the Database
 *
 *
 *
 * @author Danyal Ahmed
 * @version 24/04/2018
 *
 */
public class AddController {
	@FXML TextField directorField;
	@FXML TextField titleField;
	@FXML TextField genreField;
	@FXML TextField yearField;
	@FXML VBox addVideo;
	@FXML CheckBox ownCheckBox;
	@FXML Slider playtimeSlider;
    @FXML TextField commentField;
	@FXML Label playtimeLabel;
	@FXML RadioButton zeroBtn;
	@FXML RadioButton oneBtn;
	@FXML RadioButton twoBtn;
	@FXML RadioButton threeBtn;
	@FXML RadioButton fourBtn;
	@FXML RadioButton fiveBtn;
	private int rating;
	private boolean confirmed = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public AddController(){
		rating = 0;
	}

	public boolean isConfirmed() {
		return confirmed;
	}
	@FXML public void initialize() {
		playtimeSlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
            	playtimeLabel.setText(""+arg2.intValue());
            }
        });

	}
	@FXML
	public void cancelledPressed() {
		addVideo.getScene().getWindow().hide();
	}
	@FXML
	public String addDirector(){
		String director = directorField.getText();
		return director;
	}
	@FXML
	public String addTitle(){
		String title = titleField.getText();
		return title;
	}
	@FXML
	public String addGenre(){
		String genre = genreField.getText();
		return genre;
	}
	@FXML
	public int addYear(){
		String year = yearField.getText();
		int y = Integer.parseInt(year);
		return y;
	}
	@FXML
	public String addComment(){
		String comment = commentField.getText();
		return comment;
	}
	@FXML
	public int addPlayTime(){
		int pt = 0;
		if(playtimeSlider == null) {
		    pt = 0;
		}else{
		    pt = (int)playtimeSlider.getValue();
		}
		return pt;
	}

	public int getRating(){
		if(zeroBtn.isSelected()){
			rating = 0;
		}
		if(oneBtn.isSelected()){
			rating = 1;
		}
		if(twoBtn.isSelected()){
			rating = 2;
		}
		if(threeBtn.isSelected()){
			rating = 3;
		}
		if(fourBtn.isSelected()){
			rating = 4;
		}
		if(fiveBtn.isSelected()){
			rating = 5;
		}

		return rating;
	}





	@FXML
	public Item createPressed(){
		confirmed = true;
		Item V = new Item(addTitle(), addDirector(),addGenre(), addPlayTime(), getRating(), addComment(), addYear());
		cancelledPressed();
		return V;
	}
}
