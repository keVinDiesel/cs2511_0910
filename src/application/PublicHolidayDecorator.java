package application;

public class PublicHolidayDecorator extends RentalDecorator {

	public PublicHolidayDecorator(CustomerRental rental) {
		super(rental);
	}
	
	@Override
	public double calculatePrice() {
		double price = super.calculatePrice();
		// modify price by applying discount
		price = price + (price * 0.10);	// 10% surcharge
		return price;
	}
	
}
