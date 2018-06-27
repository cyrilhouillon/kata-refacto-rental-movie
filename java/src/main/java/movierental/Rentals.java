package movierental;

import java.util.Iterator;
import java.util.List;

public class Rentals implements Iterable<Rental> {
	private List<Rental> _rentals;

	public Rentals(List<Rental> _rentals) {
		this._rentals = _rentals;
	}

	public boolean add(Rental rental) {
		return _rentals.add(rental);
	}

	public Iterator<Rental> iterator() {
		return _rentals.iterator();
	}

	public int frequentRenterPoints() {
		int totalFrequentRenterPoints = 0;
		for (Rental each : this) {
			totalFrequentRenterPoints += each.frequentRenterPoints();
		}
		return totalFrequentRenterPoints;
	}

	public double amount() {
		double totalAmount = 0;
		for (Rental each : this) {
	        totalAmount += each.amount();
	    }
		return totalAmount;
	}

	public String statement() {
		String statements = "";
		for (Rental each : this) {
			statements += each.statement();
		}
		return statements;
	}
}