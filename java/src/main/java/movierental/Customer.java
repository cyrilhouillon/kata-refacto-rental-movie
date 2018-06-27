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

		result += rentals.statement();

		// add footer lines
        result += "Amount owed is " + String.valueOf(rentals.amount()) + "\n";
		result += "You earned " + String.valueOf(rentals.frequentRenterPoints()) + " frequent renter points";

        return result;
    }
}
