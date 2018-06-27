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
		        thisAmount += 2;
		        if (_daysRented > 2)
		            thisAmount += (_daysRented - 2) * 1.5;
		        break;
			case NEW_RELEASE:
		        thisAmount += _daysRented * 3;
		        break;
			case CHILDRENS:
		        thisAmount += 1.5;
		        if (_daysRented > 3)
		            thisAmount += (_daysRented - 3) * 1.5;
		        break;
		}
		return thisAmount;
	}

	public int frequentRenterPoints() {
		int frequentRenterPoints = 0;
		// add frequent renter points
		frequentRenterPoints++;
		// add bonus for a two day new release rental
		if ((_movie.getPriceCode() == PriceCode.NEW_RELEASE) && _daysRented > 1)
		    frequentRenterPoints++;
		return frequentRenterPoints;
	}

	public String statement() {
		return "\t" + _movie.getTitle() + "\t" + String.valueOf(amount()) + "\n";
	}
}
