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

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }


	public double amount() {
		return amount;
	}

	private double computeAmount() {
		double thisAmount = 0;
	
		// determine amounts for each line
		switch (getMovie().getPriceCode()) {
			case REGULAR:
		        thisAmount += 2;
		        if (getDaysRented() > 2)
		            thisAmount += (getDaysRented() - 2) * 1.5;
		        break;
			case NEW_RELEASE:
		        thisAmount += getDaysRented() * 3;
		        break;
			case CHILDRENS:
		        thisAmount += 1.5;
		        if (getDaysRented() > 3)
		            thisAmount += (getDaysRented() - 3) * 1.5;
		        break;
		}
		return thisAmount;
	}

	public int frequentRenterPoints() {
		int frequentRenterPoints = 0;
		// add frequent renter points
		frequentRenterPoints++;
		// add bonus for a two day new release rental
		if ((getMovie().getPriceCode() == PriceCode.NEW_RELEASE) && getDaysRented() > 1)
		    frequentRenterPoints++;
		return frequentRenterPoints;
	}

	public String statement() {
		return "\t" + getMovie().getTitle() + "\t" + String.valueOf(amount()) + "\n";
	}
}
