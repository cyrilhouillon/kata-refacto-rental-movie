package movierental;

import static movierental.PricingStrategy.CHILDRENS_STRATEGY;
import static movierental.PricingStrategy.NEW_RELEASE_STRATEGY;
import static movierental.PricingStrategy.REGULAR_STRATEGY;

public enum Pricing {

	CHILDRENS(CHILDRENS_STRATEGY), //
	NEW_RELEASE(NEW_RELEASE_STRATEGY), //
	REGULAR(REGULAR_STRATEGY);

	private PricingStrategy amountComputation;

	private Pricing(PricingStrategy amountComputation) {
		this.amountComputation = amountComputation;
	}

	public double amountFor(int daysRented) {
		return amountComputation.amountFor(daysRented);
	}

}
