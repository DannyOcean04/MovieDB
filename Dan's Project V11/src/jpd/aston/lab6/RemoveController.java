package jpd.aston.lab6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jpd.aston.lab6.model.Item;
/**
 * @author Danyal Ahmed
 * @version 24/04/2018
 *
 */
public class RemoveController {

	@FXML private Label lblItem;

	private final Item selectedItem;
	private boolean confirmed = false;

	public RemoveController(Item selectedItem) {
		this.selectedItem = selectedItem;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	@FXML
	public void initialize() {
		lblItem.setText(selectedItem.toString());
	}

	@FXML
	public void cancelPressed(ActionEvent e) {
		lblItem.getScene().getWindow().hide();
	}

	@FXML
	public void confirmPressed(ActionEvent e) {
		confirmed = true;
		lblItem.getScene().getWindow().hide();
	}
}
