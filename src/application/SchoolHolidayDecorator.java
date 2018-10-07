package application;

public class SchoolHolidayDecorator extends RentalDecorator{

	public SchoolHolidayDecorator(CustomerRental rental) {
		super(rental);
	}
	
	@Override
	public double calculatePrice() {
		double price = super.calculatePrice();
		// modify price with discount
		price = price - (price * 0.25);	// 25% discount
		return price;
	}
	
}
