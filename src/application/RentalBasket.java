package application;

import java.util.ArrayList;

public class RentalBasket implements CustomerRental {
    private ArrayList<CustomerRental> childRentals = new ArrayList<CustomerRental>();

	@Override
	public double calculatePrice() {
		// TODO Auto-generated method stub
		double price = 0.0;
		for (CustomerRental rental : childRentals) {
			price += rental.calculatePrice();
		}
		return price;
	}

	public void add(CustomerRental e) {
		childRentals.add(e);
	}
	
	public void remove(CustomerRental e) {
		childRentals.remove(e);
	}
	
	public int getNumItems() {
		return childRentals.size();
	}
	}
	
}
