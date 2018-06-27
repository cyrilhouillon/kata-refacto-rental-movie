package movierental;

public class Movie {

    private String _title;
	private Pricing _priceCode;

	public Movie(String title, Pricing priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

	public Pricing getPriceCode() {
        return _priceCode;
    }

    public String getTitle() {
        return _title;
    }


}
