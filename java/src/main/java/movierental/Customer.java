package movierental;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String _name;
    private List<Rental> _rentals = new ArrayList<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
		String result = "Rental Record for " + getName() + "\n";

		int totalFrequentRenterPoints = 0;
        for (Rental each: _rentals) {
			totalFrequentRenterPoints += each.frequentRenterPoints();
		}

		for (Rental each : _rentals) {
            result += each.statement();
		}

		double totalAmount = 0;
		for (Rental each : _rentals) {
            totalAmount += each.amount();
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(totalFrequentRenterPoints) + " frequent renter points";

        return result;
    }
}
