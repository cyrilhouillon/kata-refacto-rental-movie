package movierental;

public enum PriceCode {

	CHILDRENS, NEW_RELEASE, REGULAR;

	public static double childrensAmount(int daysRented) {
		double initialAmount = 1.5;
		if (daysRented > 3)
			initialAmount += (daysRented - 3) * 1.5;
		return initialAmount;
	}

	public static double newReleaseAmount(int daysRented) {
		return daysRented * 3;
	}

	public static double regularAmount(int daysRented) {
		double initialAmount = 2;
		if (daysRented > 2)
			initialAmount += (daysRented - 2) * 1.5;
		return initialAmount;
	}

}
