package movierental;
import java.util.ArrayList;

public class Customer {

    private String _name;
	private Rentals rentals = new Rentals(new ArrayList<Rental>());

	public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental rental) {
		rentals.add(rental);
    }

	public String getName() {
        return _name;
    }

    public String statement() {
		String result = "Rental Record for " + getName() + "\n";

		int totalFrequentRenterPoints = 0;
		for (Rental each : rentals) {
			totalFrequentRenterPoints += each.frequentRenterPoints();
		}

		for (Rental each : rentals) {
            result += each.statement();
		}

		double totalAmount = 0;
		for (Rental each : rentals) {
            totalAmount += each.amount();
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(totalFrequentRenterPoints) + " frequent renter points";

        return result;
    }
}
