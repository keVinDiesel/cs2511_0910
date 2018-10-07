package application;

public class NewReleasePrice extends Price {

	@Override
	double getCharge(int daysRented){
		double result = 5;
		if (daysRented > 1) {
			result += (daysRented - 1) * 5;
		}
		return result;
	}
	
	int getFrequentRenterPoints(int daysRented) {
		return (daysRented > 1) ? 2: 1;
	}
	
	@Override
	public String toString() {
		return "NEW";
	}

}
