package lotto.domain;

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
            throw new IllegalArgumentException("[ERROR] 구입금액은 " + MIN_PRICE + "원 이상, " + MAX_PRICE + "원 이하의 숫자만 입력 가능합니다.");
        }
    }

    private void validate(int price) {
        validateNoRemainder(price);
        validateMinPrice(price);
        validateMaxPrice(price);
    }

    private void validateNoRemainder(int price) {
        if ((price % MIN_PRICE) != 0) throw new IllegalArgumentException("[ERROR] 구입금액은 " + MIN_PRICE + "원으로 나누어 떨어져야 합니다.");
    }

    private void validateMaxPrice(int price) {
        if (price > MAX_PRICE) throw new IllegalArgumentException("[ERROR] 최대 구입금액은 " + MAX_PRICE + "원입니다.");
    }

    private void validateMinPrice(int price) {
        if (price < MIN_PRICE) throw new IllegalArgumentException("[ERROR] 최소 구입금액은 " + MIN_PRICE + "원입니다.");
    }
}
