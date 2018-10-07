package application;


import java.util.ArrayList;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class RentalController {
	@FXML
	private ListView<String> movieList;
	
	@FXML
	private Button addButton;
	
	@FXML
	private Label selectedLabel;
	
	@FXML
	private Label totalItemsLabel;
	
	@FXML
	private ListView<String> rentalList;
	
	private Stage s;
	
	public RentalBasket rentalBasket = new RentalBasket();
	
	ArrayList<Movie> movies = new ArrayList<Movie>();

	
	RentalController(Stage s) {
		this.s = s;
	}
	
	@FXML
	public void initialize() {
		movieList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				onSelection(newValue);
			}	
		});
		RegularPrice regularPrice = new RegularPrice();
		ClassicPrice classicPrice = new ClassicPrice();
		NewReleasePrice newReleasePrice = new NewReleasePrice();
		Movie movie1 = new Movie("regular movie", regularPrice);
		movies.add(movie1);
		Movie movie2 = new Movie("classic movie", classicPrice);
		movies.add(movie2);
		Movie movie3 = new Movie("new release", newReleasePrice);
		movies.add(movie3);
		movieList.getItems().add(movie1.getPriceCode().toString() + " - " + movie1.getTitle() + " ($" + movie1.getCharge(1) + ")");
		movieList.getItems().add(movie2.getPriceCode().toString() + " - " + movie2.getTitle() + " ($" + movie2.getCharge(1) + ")");
		movieList.getItems().add(movie3.getPriceCode().toString() + " - " + movie3.getTitle() + " ($" + movie3.getCharge(1) + ")");
	}
	
	private void onSelection(String newValue) {
		selectedLabel.setText(newValue + " selected.");
	}
	
	@FXML
	public void addRental() {
		String toAdd = movieList.getSelectionModel().getSelectedItem();
		if (!toAdd.isEmpty()) {
			rentalList.getItems().add(toAdd);
			Movie currentMovie = null;
			for (Movie m : movies) {
				if (toAdd.contains(m.getTitle())) {
					System.out.println("matched item: " + m.getTitle());
					currentMovie = m;
				}

			}
			
			Rental currentRental = new Rental(currentMovie, 1);
			rentalBasket.add(currentRental);
			double totalCost = rentalBasket.calculatePrice();

			if (rentalBasket.getNumItems() > 3) {
				CustomerRental discountedBasket = new BulkBuyDecorator(rentalBasket);
				totalCost = discountedBasket.calculatePrice();
			}

			totalItemsLabel.setText("Total Items Cost: $" + totalCost);
		}
	}
	
	
}
