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
		double thisAmount = 0;
	
		// determine amounts for each line
		switch (_movie.getPriceCode()) {
			case REGULAR:
			thisAmount = regularAmount(thisAmount);
		        break;
			case NEW_RELEASE:
			thisAmount = newReleaseAmount(thisAmount);
		        break;
			case CHILDRENS:
			thisAmount = childrensAmount();
		        break;
		}
		return thisAmount;
	}

	private double childrensAmount() {
		initialAmount += 1.5;
		if (_daysRented > 3)
		    initialAmount += (_daysRented - 3) * 1.5;
		return initialAmount;
	}

	private double newReleaseAmount(double initialAmount) {
		initialAmount += _daysRented * 3;
		return initialAmount;
	}

	private double regularAmount(double initialAmount) {
		initialAmount += 2;
		if (_daysRented > 2)
		    initialAmount += (_daysRented - 2) * 1.5;
		return initialAmount;
	}

	public int frequentRenterPoints() {
		// add bonus for a two day new release rental
		if ((_movie.getPriceCode() == PriceCode.NEW_RELEASE) && _daysRented > 1)
		    return 2;
		return 1;
	}

	public String statement() {
		return "\t" + _movie.getTitle() + "\t" + String.valueOf(amount()) + "\n";
	}
}
