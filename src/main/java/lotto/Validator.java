package lotto;

public class Validator {
    private static final int LOTTO_PRICE = 1000;
    public static void validateNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 함");
        }
    }

    public static void validateDivisibleByLottoPrice(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 천원 단위로 나눠 떨어져야 함");
        }
    }
}
