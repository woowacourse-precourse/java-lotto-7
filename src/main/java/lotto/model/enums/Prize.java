package lotto.model.enums;

public enum Prize {
    FIFTH_PRICE(5000,"5,000원"),
    FOURTH_PRICE(50000,"50,000원"),
    THIRD_PRICE(1500000, "1,500,000원"),
    SECOND_PRICE(30000000, "30,000,000원"),
    FIRST_PRICE(2000000000, "2,000,000,000원"),
    ;

    private final int amount;
    private final String message;

    Prize(int amount, String message) {
        this.amount = amount;
        this.message = message;
    }

    public int getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }
}
