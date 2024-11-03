package lotto;

import java.math.BigDecimal;
import lotto.exception.LottoArgumentException;

public class LottoPayment {
    private static final BigDecimal LOTTO_PRICE = new BigDecimal(1000);
    private final BigDecimal purchaseAmount;

    public LottoPayment(final BigDecimal purchaceAmount) {
        validate(purchaceAmount);
        this.purchaseAmount = purchaceAmount;
    }

    public int getLottoCount() {
        return purchaseAmount.divide(LOTTO_PRICE).intValue();
    }

    public BigDecimal getPayment() {
        return this.purchaseAmount;
    }

    private void validate(final BigDecimal purchaceAmount) {
        if (purchaceAmount.equals(BigDecimal.ZERO) || !purchaceAmount.remainder(LOTTO_PRICE).equals(BigDecimal.ZERO)) {
            throw new LottoArgumentException("금액은 " + LOTTO_PRICE + "단위로 입력해야 합니다.");
        }
    }
}
