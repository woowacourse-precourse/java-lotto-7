package lotto.validation;

public class PurchaseAmountValidator {
    private final static int PRICE_PER_LOTTO = 1000;
    private final static String INVALID_PRICE_INPUT = "[ERROR]올바른 금액을 입력해 주시기 바랍니다.";
    private final static String NUMBER_REGEX = "\\d+";

    public static int parseValidatedTicketCount(String input) {
        if (input == null || input.isBlank() || !input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(INVALID_PRICE_INPUT);
        }
        int parsedInput = parseInput(input);
        if (parsedInput == 0 || parsedInput % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(INVALID_PRICE_INPUT);
        }
        return parsedInput / PRICE_PER_LOTTO;
    }

    private static int parseInput(String input) {
        return Integer.parseInt(input.trim());
    }
}
