package movierental;

public class Rental {

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
		// add bonus for a two day new release rental
		if ((_movie.getPriceCode() == Pricing.NEW_RELEASE) && _daysRented > 1)
		    return 2;
		return 1;
	}

	public String statement() {
		return "\t" + _movie.getTitle() + "\t" + String.valueOf(amount()) + "\n";
	}
}
