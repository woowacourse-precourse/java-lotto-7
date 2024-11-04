package lotto;

public class Validator {
    private static final int LOTTO_PRICE = 1000;
    public static void validateNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 함");
        }
    }
}
