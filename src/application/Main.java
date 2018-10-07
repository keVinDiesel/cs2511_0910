package application;
	
import javafx.application.Application;
import javafx.stage.Stage;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setWidth(600);
		primaryStage.setHeight(400);
		
		new RentalScene(primaryStage).display();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
