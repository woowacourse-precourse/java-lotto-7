package lotto.validation;

public class PurchaseAmountValidator {
    private final static int PRICE_PER_LOTTO = 1000;
    private final static int MINIMUM_PURCHASE_AMOUNT = PRICE_PER_LOTTO;
    private final static String INVALID_PRICE_INPUT = "[ERROR] 올바른 금액을 입력해 주시기 바랍니다.";
    private final static String INVALID_PRICE_UNIT_INPUT = "[ERROR] 구매 금액은 " + PRICE_PER_LOTTO + "원 단위여야 합니다.";
    private final static String NUMBER_REGEX = "\\d+";

    public static int parseValidatedTicketCount(String input) {
        validateInputIsNotNullOrEmpty(input);
        int parsedInput = parseInput(input);
        validateMinimumAmount(parsedInput);
        validateUnit(parsedInput);
        return parsedInput / PRICE_PER_LOTTO;
    }

    private static void validateInputIsNotNullOrEmpty(String input) {
        if (input == null || input.isBlank() || !input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(INVALID_PRICE_INPUT);
        }
    }

    private static void validateMinimumAmount(int amount) {
        if (amount < MINIMUM_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(INVALID_PRICE_INPUT);
        }
    }

    private static void validateUnit(int amount) {
        if (amount % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(INVALID_PRICE_UNIT_INPUT);
        }
    }

    private static int parseInput(String input) {
        return Integer.parseInt(input.trim());
    }
}
