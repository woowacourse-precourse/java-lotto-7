package lotto.util;

public class PurchaseValidator {
    public static void validatePurchase(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해주세요.");
        }
    }
}
