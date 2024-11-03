package lotto.common;

public class LottoValidateUtil {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_PURCHASE_LIMIT = 100000;

    private LottoValidateUtil() {
    }

    public static void validatePurchaseAmount(int amount) {
        if (amount > LOTTO_PURCHASE_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 100,000원까지만 구매가 가능합니다.");
        }
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 1,000원 이상의 금액을 입력하셔야 합니다.");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1,000원 단위만 가능합니다.");
        }
    }
}
