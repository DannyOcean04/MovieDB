package jpd.aston.lab6;

import java.io.IOException;
import java.util.Comparator;

import FileHandler.createFile;
import FileHandler.deleteFile;
import OpenFile.OPENCSV;
import databases.EntityDatabase;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jpd.aston.lab6.model.Database;
import jpd.aston.lab6.model.Item;
import serialize.Serial;
/**
 * @author Danyal Ahmed
 * @version 16/07/2018
 *
 */
public class ListController {

	@FXML
	private ListView<Item> listItems;
	private final Database model;
	private Item saveItems;
	private deleteFile df;
	private Comparator<Item> comparator;
	private Comparator<Item> yearComparator;
	private int sorting = 0;
	private int yearSorting = 0;
	private Boolean titlesorting = false;
	private Boolean directorsorting = false;
	private Boolean genresorting = false;
	@FXML private TextField searchTextField;
	@FXML private Label NoMovies;


	public ListController(Database model) {
		this.model = model;
		df = new deleteFile();
		comparator = Comparator.comparingDouble(Item::getTheRating);
		yearComparator = Comparator.comparingDouble(Item::getYear);
	}

	@FXML
	public void initialize() {
		listItems.setItems(model.itemsProperty());
		countDatabase();
	}

public void countDatabase(){
	String number = Integer.toString(model.itemsProperty().size());
	NoMovies.setText(number);
}

@FXML public void listItemsClicked(){
	int selectedIdx = listItems.getSelectionModel().getSelectedIndex();
	if (selectedIdx >= 0) {
		final Item selectedItem = listItems.getSelectionModel().getSelectedItem();
		final FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("ExtraOrRemove.fxml"));
		final chooseController controller = new chooseController(selectedItem);
		loader.setController(controller);
		try {
			final Parent parent = (Parent) loader.load();

			final Stage extraStage = new Stage();
			extraStage.initModality(Modality.APPLICATION_MODAL);
			extraStage.setScene(new Scene(parent, 200, 200));
			extraStage.showAndWait();


			if(controller.windowConfirmed()){
				extraStage.close();
			}


			if (controller.isConfirmed()) {
				model.itemsProperty().remove(selectedIdx);
				String B = selectedItem.getFName();
               df.removeMovie(B);
		}
			if(controller.editConfirmed()){
		//		model.itemsProperty().remove(selectedIdx);
				model.itemsProperty().add(controller.edited());
				saveItems=controller.edited();
				EntityDatabase.getDB().getMOVIE().add(saveItems);
                EntityDatabase.getDB().getNames().add(saveItems.getFName());
			//	EntityDatabase.getDB().addName(saveItems.getFName());
				load();
			}

			countDatabase();

		}
		 catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}


	@FXML
	public void searchTextPressed(){
		searchTextField.clear();
		countDatabase();
	}



	@FXML
	public void shufflePressed() {
		FXCollections.shuffle(model.itemsProperty());

	}

	@FXML
	public void sortByTitle(){
		if(titlesorting == false){
		FXCollections.sort(model.itemsProperty(),
                new Comparator<Item>()
                {
                    public int compare(Item f1, Item f2)
                    {
                        return f1.getTitle().toString().compareTo(f2.getTitle().toString());
                    }
                });
		titlesorting = true;
		}
		else if(titlesorting==true){
			load();
			titlesorting = false;
		}
	}
	@FXML
	public void sortByGenre(){
		if(genresorting == false){
		FXCollections.sort(model.itemsProperty(),
                new Comparator<Item>()
                {
                    public int compare(Item f1, Item f2)
                    {
                        return f1.getGenre().toString().compareTo(f2.getGenre().toString());
                    }
                });
		genresorting = true;
		}
		else if(genresorting==true){
			load();
			genresorting = false;
		}
	}

	@FXML public void sortByDirector(){
		if(directorsorting == false){
			FXCollections.sort(model.itemsProperty(),
	                new Comparator<Item>()
	                {
	                    public int compare(Item f1, Item f2)
	                    {
	               String  D1 []=  f1.getDirector().toString().split(" ");

	               String D2[] =   f2.getDirector().toString().split(" ");
	                        return (D1[D1.length-1]).compareTo(D2[D2.length-1]);
	                    }
	                });
			directorsorting = true;
			}
			else if(directorsorting==true){
				load();
				directorsorting = false;
			}
	}



@FXML public void searchPressed(){
	 model.itemsProperty().clear();
	String search = searchTextField.getText();

if(!search.isEmpty()){

	for(int i=0; i<EntityDatabase.getDB().getMOVIE().size();i++){
		Item a = EntityDatabase.getDB().getMOVIE().get(i);

		if(a.getDirector().contains(search)){
			model.addItem(a);
		}
		if(a.getTitle().contains(search)){
			model.addItem(a);
		}
		if(a.getGenre().contains(search)){
			model.addItem(a);
		}
		if(Integer.toString(a.getYear()).contains(search)){
			model.addItem(a);


		}
	}
}

else{
reset();
listItems.setItems(model.itemsProperty());
}
countDatabase();
}

private void load(){
	 model.itemsProperty().clear();
	 reset();
	 listItems.setItems(model.itemsProperty());
}


@FXML public void openPressed(){

	OPENCSV OC = new OPENCSV();
	for(int i =0; i<OC.getVids().size();i++){
	  Item I = OC.getVids().get(i);
	  model.itemsProperty().add(I);
	EntityDatabase.getDB().getMOVIE().add(I);
	String fname = I.getFName().trim();
	EntityDatabase.getDB().addName(fname);
	}

}

public void reset(){
	for (int i=0; i< EntityDatabase.getDB().getMOVIE().size(); i++){
		Item a = EntityDatabase.getDB().getMOVIE().get(i);
		model.addItem(a);
	}
}



@FXML
public void sortByRating(){
	if(sorting == 0){
		FXCollections.sort(model.itemsProperty(),comparator);
		sorting++;
	}
	else if(sorting == 1){
		FXCollections.sort(model.itemsProperty(),comparator.reversed());

		sorting++;
	}
	else{
		load();
		sorting = 0;
	}
}
@FXML
public void sortByYear(){
	if(yearSorting == 0){
		FXCollections.sort(model.itemsProperty(),yearComparator);
		yearSorting++;
	}
	else if(yearSorting == 1){
		FXCollections.sort(model.itemsProperty(),yearComparator.reversed());

		yearSorting++;
	}
	else{
		load();
		yearSorting = 0;
	}
}


	@FXML
	public void quitPressed(){
		listItems.getScene().getWindow().hide();
		df.deleteTheList("MOVIES.txt");
		df.deleteTheList("MoviesDatabase.csv");
		createFile cf = new createFile();
		cf.cCSV("MoviesDatabase.csv");
        Serial S = new Serial();
        S.serialize();
	}


	@FXML
	public void addPressed() {
			final FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("AddMovie.fxml"));
			final AddController controller = new AddController();
			loader.setController(controller);
			try {
				final Parent parent = (Parent) loader.load();

				final Stage addStage = new Stage();
				addStage.setTitle("Create Movie");
				addStage.initModality(Modality.APPLICATION_MODAL);
				addStage.setScene(new Scene(parent, 230, 338));
				addStage.showAndWait();

				if (controller.isConfirmed()) {

					model.itemsProperty().add(controller.createPressed());
					saveItems=controller.createPressed();
					EntityDatabase.getDB().getMOVIE().add(saveItems);
					EntityDatabase.getDB().addName(saveItems.getFName());
					countDatabase();

				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
}
