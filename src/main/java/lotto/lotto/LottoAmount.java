package lotto.lotto;

public class LottoAmount {

    private static final int LOTTO_PURCHASE_UNIT_AMOUNT = 1000;

    private final int amount;

    public LottoAmount(int amount) {
        validatePositiveAmount(amount);
        validateLottoPurchaseAmount(amount);
        this.amount = amount;
    }

    public int getPurchaseLottoCount() {
        return amount / LOTTO_PURCHASE_UNIT_AMOUNT;
    }

    private void validatePositiveAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 음수가 될 수 없습니다.");
        }
    }

    private void validateLottoPurchaseAmount(int amount) {
        if (amount % LOTTO_PURCHASE_UNIT_AMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 " + LOTTO_PURCHASE_UNIT_AMOUNT + "원 단위로만 가능합니다.");
        }
    }

    public int getAmount() {
        return amount;
    }
}
