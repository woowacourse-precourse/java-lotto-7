package lotto.model;

public enum Price {
    FIRST_PRICE("2,000,000,000원"),
    SECOND_PRICE("30,000,000원"),
    THIRD_PRICE("1,500,000원"),
    FOURTH_PRICE("50,000원"),
    FIFTH_PRICE("5,000원"),
    ;

    private final String message;

    Price(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
