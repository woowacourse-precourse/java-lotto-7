package lotto;

public class Money {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String ERROR_NOT_NUMBER = "숫자만 입력 가능합니다.";
    private static final String ERROR_NOT_UNIT = "1,000원 단위로만 구매 가능합니다.";
    private static final String ERROR_NOT_POSITIVE = "구매 금액은 0보다 커야 합니다.";
    private static final int LOTTO_PRICE = 1000;

    private final int amount;

    public Money(String input) {
        validateNumeric(input);
        int parsedAmount = Integer.parseInt(input);
        validatePositive(parsedAmount);
        validateUnit(parsedAmount);
        this.amount = parsedAmount;
    }

    private void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_NOT_NUMBER);
        }
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_NOT_POSITIVE);
        }
    }

    private void validateUnit(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_NOT_UNIT);
        }
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public int getAmount() {
        return amount;
    }
}