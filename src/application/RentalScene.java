package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RentalScene {
	private Stage s;
	private String title;
	private FXMLLoader fxmlLoader;
	
	public RentalScene(Stage s) {
		this.s = s;
		this.title = "Rental Tool";
		this.fxmlLoader = new FXMLLoader(getClass().getResource("RentalTool.fxml"));
	}
	
	public void display() throws Exception {
		s.setTitle(title);
		fxmlLoader.setController(new RentalController(s));
		
		Parent root = fxmlLoader.load();
		s.setScene(new Scene(root));
		s.show();
	}
}
