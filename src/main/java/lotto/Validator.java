package lotto;

public class Validator {

    public static void validatePurchaseAmount(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
        int amount = Integer.parseInt(input);
        if (amount % 1000 != 0 || amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.");
        }
    }
}