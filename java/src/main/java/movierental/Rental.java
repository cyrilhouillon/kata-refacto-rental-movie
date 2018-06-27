package movierental;

public class Rental {

    private static final int FRP_NEW_RELEASE_BONUS = 1;
	private static final int BASE_FRP = 1;

	private Movie _movie;
    private int _daysRented;
	private double amount;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
		amount = computeAmount();
    }

	public double amount() {
		return amount;
	}

	private double computeAmount() {
		return _movie.getPriceCode().amountFor(_daysRented);
	}

	public int frequentRenterPoints() {
		return BASE_FRP + frpBonus();
	}

	private int frpBonus() {
		return isEligibleForFRPNewReleaseBonus() ? FRP_NEW_RELEASE_BONUS : 0;
	}

	private boolean isEligibleForFRPNewReleaseBonus() {
		return (_movie.getPriceCode() == Pricing.NEW_RELEASE) && _daysRented > 1;
	}

	public String statement() {
		return "\t" + _movie.getTitle() + "\t" + String.valueOf(amount()) + "\n";
	}
}
