package jpd.aston.lab6;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jpd.aston.lab6.model.Item;
/**
 * @author Danyal Ahmed
 * @version 16/07/2018
 *
 */
public class chooseController {

	private Item A;
	private Item editted;
	private boolean deleteFile;
	private boolean closeWindow;
	private boolean editItem;
	@FXML private Label lblItem;
	private final Item selectedItem;

	public chooseController(Item I){
		A = I;
		deleteFile=false;
		closeWindow = false;
		editItem = false;
		selectedItem = I;

	}

	@FXML
	public void initialize() {
		lblItem.setText(selectedItem.toString());
	}













	@FXML private void extraPressed(){
		closeWindow = true;
			final Item selectedItem = A;
			final FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("ExtraInformation.fxml"));
			final ExtraInformation controller = new ExtraInformation(selectedItem);
			loader.setController(controller);
			try {
				final Parent parent = (Parent) loader.load();

				final Stage extraStage = new Stage();
				extraStage.initModality(Modality.APPLICATION_MODAL);
				extraStage.setScene(new Scene(parent, 270, 270));
				extraStage.showAndWait();


				if(selectedItem == null ){
					extraStage.close();

			}
			}			 catch (IOException ex) {
				ex.printStackTrace();}
			}
public boolean windowConfirmed(){
	return closeWindow;
}

	public boolean isConfirmed() {
		return deleteFile;
	}
	public boolean editConfirmed() {
		return editItem;
	}
	@FXML private void removePressed(){
		closeWindow = true;
			final Item selectedItem = A;

			final FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("RemoveItem.fxml"));
			final RemoveController controller = new RemoveController(selectedItem);
			loader.setController(controller);
			try {
				final Parent parent = (Parent) loader.load();

				final Stage removeStage = new Stage();
				removeStage.initModality(Modality.APPLICATION_MODAL);
				removeStage.setScene(new Scene(parent, 230, 304));
				removeStage.showAndWait();

				if (controller.isConfirmed()) {
					deleteFile = true;
			}
				}
			 catch (IOException ex) {
				ex.printStackTrace();
			}
		}


	@FXML private void editPressed(){
		closeWindow = true;
			final Item selectedItem = A;

			final FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("EditMovie.fxml"));
			final EditController controller = new EditController(selectedItem);
			loader.setController(controller);
			try {
				final Parent parent = (Parent) loader.load();

				final Stage editStage = new Stage();
				editStage.initModality(Modality.APPLICATION_MODAL);
				editStage.setScene(new Scene(parent, 230, 338));
				editStage.showAndWait();

				if (controller.isConfirmed()) {
					editItem = true;
					editted = controller.editPressed();

			}
				}
			 catch (IOException ex) {
				ex.printStackTrace();
			}
		}


	public Item edited(){
		return editted;
	}


	}




