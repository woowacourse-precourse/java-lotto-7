package lotto.validation;

public class InputValidatorImpl {
    private static final String ERROR_INVALID_AMOUNT = "[ERROR] 구매 금액은 1,000원 단위로 입력해야 합니다.";
    private static final String ERROR_NON_POSITIVE_AMOUNT = "[ERROR] 구매 금액은 0보다 커야 합니다.";
    private static final String ERROR_NOT_NUMERIC = "[ERROR] 구매 금액은 숫자여야 합니다.";
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final int ZERO = 0;

    public int validate(String input) {
        int amount = parseInput(input);
        if (amount <= ZERO) {
            throw new IllegalArgumentException(ERROR_NON_POSITIVE_AMOUNT);
        }
        if (amount % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_AMOUNT);
        }
        return amount;
    }

    private int parseInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_NUMERIC);
        }
    }
}
