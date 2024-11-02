package lotto;

public class PurchaseValidator {
    private static final int LOTTO_PRICE = 1000;

    public static void validate(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해 주세요.");
        }
    }
}
