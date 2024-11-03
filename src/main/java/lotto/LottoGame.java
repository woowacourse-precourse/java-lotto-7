package lotto;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    public static int validatePurchaseAmount(String input) {
        int amount = Integer.parseInt(input);
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return amount;
    }
}
