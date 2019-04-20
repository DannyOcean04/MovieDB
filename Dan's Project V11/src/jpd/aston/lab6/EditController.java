package jpd.aston.lab6;

import FileHandler.deleteFile;
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
 * @author Danyal Ahmed
 * @version 16/07/2018
 *
 */
public class EditController {
	private deleteFile df;
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
	private Item movie;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public EditController(Item A){
  movie = A;

	}

	private void load(Item A){
		 df = new deleteFile();
			directorField.setText(A.getDirector());
			titleField.setText(A.getTitle());
			genreField.setText(A.getGenre());
			commentField.setText(A.getComment());
			String Y = Integer.toString(A.getYear());
			yearField.setText(Y);
			setRating(A);
			setRuntime(A);
		 df.removeMovie(A.getFName());
	}

	private void setRating(Item B){
		int rating = B.getTheRating();

		if(rating == 0){
			zeroBtn.setSelected(true);
		}
		else if(rating == 1){
			oneBtn.setSelected(true);
		}
		else if(rating == 2){
			twoBtn.setSelected(true);
		}
		else if(rating == 3){
			threeBtn.setSelected(true);
		}
		else if(rating == 4){
			fourBtn.setSelected(true);
		}
		else if(rating == 5){
			fiveBtn.setSelected(true);
		}

	}

	private void setRuntime(Item C){
		int runtime = C.getPlayingTime();
		playtimeSlider.setValue(runtime);
		String play = Integer.toString(C.getPlayingTime());
		playtimeLabel.setText(play);
	}

	public boolean isConfirmed() {
		return confirmed;
	}
	@FXML public void initialize() {

		load(movie);

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
	public Item editPressed(){
		confirmed = true;
		Item V = new Item(addTitle(), addDirector(),addGenre(), addPlayTime(), getRating(), addComment(), addYear());
		cancelledPressed();
		return V;
	}
}

