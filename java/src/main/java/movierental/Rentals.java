package movierental;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Rentals implements Iterable<Rental> {
	private List<Rental> _rentals;

	public Rentals() {
		this._rentals = new ArrayList<>();
	}

	public boolean add(Rental rental) {
		return _rentals.add(rental);
	}

	@Override
	public Iterator<Rental> iterator() {
		return _rentals.iterator();
	}

	public int frequentRenterPoints() {
		return _rentals.stream()//
				.mapToInt(Rental::frequentRenterPoints)//
				.sum();
	}

	public double amount() {
		return _rentals.stream()//
				.mapToDouble(Rental::amount)//
				.sum();
	}

	public String statement() {
		return _rentals.stream()//
				.map(Rental::statement)//
				.collect(joining());
	}
}