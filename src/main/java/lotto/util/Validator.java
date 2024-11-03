package lotto.util;

public class Validator {

    public static int validatePurchaseAmount(String input) {
        try {
            long purchaseAmount = Long.parseLong(input);

            if (purchaseAmount > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("[ERROR] 구입금액이 너무 큽니다.");
            } else if (purchaseAmount < 1000) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 이상이어야 합니다.");
            } else if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위로 입력할 수 있습니다.");
            }

            return (int) purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 양의 정수만 입력할 수 있습니다.");
        }
    }
}
