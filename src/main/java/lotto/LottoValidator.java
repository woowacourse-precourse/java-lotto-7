package lotto;

public class LottoValidator {

    private static final int LOTTO_PRICE = 1000;

    public static void validateAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
