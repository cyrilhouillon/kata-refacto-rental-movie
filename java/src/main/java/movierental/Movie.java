package movierental;

public class Movie {

    private String _title;
	private PriceCode _priceCode;

	public Movie(String title, PriceCode priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

	public PriceCode getPriceCode() {
        return _priceCode;
    }

    public String getTitle() {
        return _title;
    }


}
