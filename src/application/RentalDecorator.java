package application;

public abstract class RentalDecorator implements CustomerRental{
	protected CustomerRental rentalToBeDecorated;
	
	public RentalDecorator(CustomerRental rental) {
		this.rentalToBeDecorated = rental;
	}
	
	@Override
	public double calculatePrice() {
		return this.rentalToBeDecorated.calculatePrice();
	}
}
