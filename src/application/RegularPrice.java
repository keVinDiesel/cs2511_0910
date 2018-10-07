package application;

public class RegularPrice extends Price {

	@Override
	double getCharge(int daysRented){
		double result = 3;
		if (daysRented > 3)	{
			result += (daysRented - 3) * 1;
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "REGULAR";
	}
}
