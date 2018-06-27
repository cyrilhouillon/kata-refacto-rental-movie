package movierental;

import java.util.function.IntToDoubleFunction;

public enum Pricing {

	CHILDRENS((daysRented) -> {
		double initialAmount = 1.5;
		if (daysRented > 3)
			initialAmount += (daysRented - 3) * 1.5;
		return initialAmount;
	}), //
	NEW_RELEASE((daysRented) -> daysRented * 3), //
	REGULAR((daysRented) -> {
		double initialAmount = 2;
		if (daysRented > 2)
			initialAmount += (daysRented - 2) * 1.5;
		return initialAmount;
	});

	private IntToDoubleFunction amountComputation;

	private Pricing(IntToDoubleFunction amountComputation) {
		this.amountComputation = amountComputation;
	}

	public double amountFor(int daysRented) {
		return amountComputation.applyAsDouble(daysRented);
	}

}
