package lotto.domain;

import lotto.view.ErrorMessage;

public class Price {
    private static final int MIN_PRICE = 1_000;
    private static final int MAX_PRICE = Integer.MAX_VALUE;

    private final int price;

    public Price(int price) {
        validate(price);
        this.price = price;
    }

    public Price(String price) {
        int parsedPrice = parseStringToInteger(price);
        validate(parsedPrice);
        this.price = parsedPrice;
    }

    private int parseStringToInteger(String price) {
        try {
            return Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.notValidPriceRange());
        }
    }

    private void validate(int price) {
        validatePriceRange(price);
        validateNoRemainder(price);
    }

    private void validateNoRemainder(int price) {
        if ((price % MIN_PRICE) != 0) throw new IllegalArgumentException(ErrorMessage.priceWithRemainder());
    }

    private void validatePriceRange(int price) {
        if (price < MIN_PRICE || price > MAX_PRICE) throw new IllegalArgumentException(ErrorMessage.notValidPriceRange());
    }

    public int value() {
        return price;
    }

    public int getLottoAmount() {
        return price / MIN_PRICE;
    }
}
