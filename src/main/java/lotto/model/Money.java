package lotto.model;

import java.text.DecimalFormat;

import static lotto.Exception.ExceptionMessage.*;
import static lotto.model.LottoConstant.*;

public class Money {
    private static final int ZERO = 0;
    private final long purchaseAmount;

    public Money(long purchaseAmount) {
        checkPurchaseAmountIsZero(purchaseAmount);
        checkPurchaseAmountIsThousandUnit(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void checkPurchaseAmountIsZero(long purchaseAmount) {
        if (purchaseAmount == ZERO) {
            throw new IllegalArgumentException(ZERO_PURCHASE_AMOUNT.getMessage());
        }
    }

    public long getThousandUnitCount() {
        return purchaseAmount / PRICE.getValue();
    }

    public String calculateReturnRate(long totalPrizeMoney) {
        double returnRate = ((double) totalPrizeMoney / purchaseAmount) * 100.0;
        returnRate = Math.round(returnRate * 100) / 100.0;

        return formatReturnRate(returnRate);
    }

    private String formatReturnRate(double returnRate) {
        DecimalFormat df = new DecimalFormat("#,##0.0");
        return df.format(returnRate) + "%";
    }

    private void checkPurchaseAmountIsThousandUnit(long purchaseAmount) {
        if (purchaseAmount % PRICE.getValue() != ZERO) {
            throw new IllegalArgumentException(NOT_THOUSAND_UNIT_PURCHASE_AMOUNT.getMessage());
        }
    }
}
