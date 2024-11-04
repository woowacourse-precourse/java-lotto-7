package lotto.domain;

import java.math.BigDecimal;
import lotto.exception.LottoArgumentException;

public class LottoPayment {
    private static final String PURCHASE_AMOUNT_ERROR_MESSAGE_FORMAT = "금액은 %d원 단위로 입력해야 합니다.";
    private static final BigDecimal LOTTO_PRICE = new BigDecimal(1000);
    private final BigDecimal purchaseAmount;

    public LottoPayment(final BigDecimal purchaceAmount) {
        validate(purchaceAmount);
        this.purchaseAmount = purchaceAmount;
    }

    public LottoPayment(final String purchaseAmountInput) {
        final BigDecimal purchaseAmount = new BigDecimal(purchaseAmountInput);
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getLottoCount() {
        return purchaseAmount.divide(LOTTO_PRICE).intValue();
    }

    public BigDecimal getPayment() {
        return this.purchaseAmount;
    }

    private void validate(final BigDecimal purchaceAmount) {
        if (purchaceAmount.equals(BigDecimal.ZERO) || !purchaceAmount.remainder(LOTTO_PRICE).equals(BigDecimal.ZERO)) {
            throw new LottoArgumentException(String.format(PURCHASE_AMOUNT_ERROR_MESSAGE_FORMAT, LOTTO_PRICE.intValue()));
        }
    }
}
