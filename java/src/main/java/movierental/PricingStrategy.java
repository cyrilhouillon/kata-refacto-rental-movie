package movierental;

import java.util.function.IntToDoubleFunction;

@FunctionalInterface
public interface PricingStrategy extends IntToDoubleFunction {

	PricingStrategy CHILDRENS_STRATEGY = (daysRented) -> {
		double initialAmount = 1.5;
		if (daysRented > 3)
			initialAmount += (daysRented - 3) * 1.5;
		return initialAmount;
	};

	PricingStrategy NEW_RELEASE_STRATEGY = (daysRented) -> daysRented * 3;

	PricingStrategy REGULAR_STRATEGY = (daysRented) -> {
		double initialAmount = 2;
		if (daysRented > 2)
			initialAmount += (daysRented - 2) * 1.5;
		return initialAmount;
	};

	default double amountFor(int days) {
		return applyAsDouble(days);
	}

}
