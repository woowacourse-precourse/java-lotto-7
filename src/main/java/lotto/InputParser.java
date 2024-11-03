package lotto;

public class InputParser {

    private static int parseStringToInt(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static int parsePurchaseAmount(String amountInput) {
        return parseStringToInt(amountInput, "[ERROR] 구입 금액은 숫자여야 합니다.");
    }
}
