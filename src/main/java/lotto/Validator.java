package lotto;

public class Validator {
    private static final int LOTTO_PRICE = 1000;

    public static void validatePurchaseAmount(String input) {
        validateNumeric(input);
        int amount = Integer.parseInt(input);
        validateDivisibleByLottoPrice(amount);
        validatePositiveAmount(amount);
    }
    private static void validateNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 함");
        }
    }

    private static void validateDivisibleByLottoPrice(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 천원 단위로 나눠 떨어져야 함");
        }
    }

    private static void validatePositiveAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 천원 이상이어야 함");
        }
    }
}
