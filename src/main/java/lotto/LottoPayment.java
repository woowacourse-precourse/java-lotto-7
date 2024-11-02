package lotto;

import lotto.exception.LottoArgumentException;

public class LottoPayment {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public LottoPayment(final int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int getLottoCount() {
        return this.amount / LOTTO_PRICE;
    }

    private void validate(final int amount) {
        if (amount == 0 || amount % LOTTO_PRICE != 0) {
            throw new LottoArgumentException("금액은 " + LOTTO_PRICE + "단위로 입력해야 합니다.");
        }
    }
}
