package lotto.util;

public class Validator {

    public static void purchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount <= 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
            }
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
        }
    }
}
