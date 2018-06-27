package movierental;

import java.util.List;

public class Rentals {
	public List<Rental> _rentals;

	public Rentals(List<Rental> _rentals) {
		this._rentals = _rentals;
	}

	public boolean add(Rental rental) {
		return _rentals.add(rental);
	}
}