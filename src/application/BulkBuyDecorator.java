package application;

public class BulkBuyDecorator extends RentalDecorator {

	public BulkBuyDecorator(CustomerRental rental) {
		super(rental);
	}
	
	@Override
	public double calculatePrice() {
		double price = super.calculatePrice();
		// modify price with discount
		price = price - (price * 0.10);	// 10% discount
		return price;
	}

}
