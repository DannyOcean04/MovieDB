package jpd.aston.lab6;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import FileHandler.OrderList;
import databases.EntityDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jpd.aston.lab6.model.Database;
import jpd.aston.lab6.model.Item;
import serialize.Deserial;
/**
 * @author Danyal Ahmed
 * @version 16/07/2018
 *
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
	    	final Database d = createDatabase();

			final FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("ListScene.fxml"));
			loader.setController(new ListController(d));
			final Parent root = loader.load();

			final Scene scene = new Scene(root, 421, 304);
			primaryStage.setTitle("Movie Database");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private Database createDatabase() {
		if(Files.exists(Paths.get("MOVIES.txt"))){
		//	System.out.println("File exists");
		}
		else{
			@SuppressWarnings("unused")
			File f = new File("MOVIES.txt");
		}

		final Database d = new Database();
		EntityDatabase.getDB().createDatabases();
		@SuppressWarnings("unused")
		OrderList ol = new OrderList();
	if(EntityDatabase.getDB().getNames().size() == 0){
	//	System.out.println("Database Empty");
	}
	else{

		Deserial DS = new Deserial();
		DS.deserialize();
  int k = EntityDatabase.getDB().getMOVIE().size();
	for (int i=k-1; i>= 0; i--){
	//	System.out.println(i);
		Item a = EntityDatabase.getDB().getMOVIE().get(i);
		d.addItem(a);
	}

	}

		return d;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
