package application;

public class ClassicPrice extends Price {

	@Override
	double getCharge(int daysRented){
		double result = 2.5;
		if (daysRented > 5)
		result += (daysRented - 5) * 0.5;
		return result;
	}
	
	@Override
	public String toString() {
		return "CLASSIC";
	}
}
