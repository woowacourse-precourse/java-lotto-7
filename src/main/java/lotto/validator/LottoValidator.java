package lotto.validator;

public class LottoValidator {
    public static void validatePurchaseAmount(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위이어야 합니다.");
        }
    }
}
