package lotto.validator;

public class Money implements InputTypeValidator {
    private final String moneyAmount;

    public Money(String moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    @Override
    public void isNaturalNumber() {
        try {
            Long.parseLong(moneyAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] " + e.getMessage());
        }
    }
}
