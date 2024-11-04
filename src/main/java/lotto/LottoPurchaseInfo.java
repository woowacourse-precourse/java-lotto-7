package lotto;

import static view.message.ExceptionMessage.NEGATIVE_NUMBER_EXCEPTION_MESSAGE;

import java.math.BigDecimal;
import java.util.List;

public record LottoPurchaseInfo(BigDecimal purchaseAmount, Lotto lottoNumbers, int bonusNumber) {

    public LottoPurchaseInfo {
        validateNegativeNumber(purchaseAmount);
    }

    public LottoPurchaseInfo(BigDecimal purchaseAmount, List<Integer> lottoNumbers, int bonusNumber) {
        this(purchaseAmount, new Lotto(lottoNumbers), bonusNumber);
    }

    private void validateNegativeNumber(BigDecimal purchaseAmount) {
        if (purchaseAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
