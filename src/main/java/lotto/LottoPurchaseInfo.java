package lotto;

import static view.message.ExceptionMessage.NEGATIVE_NUMBER_EXCEPTION_MESSAGE;
import static view.message.ExceptionMessage.MAX_PURCHASE_AMOUNT_TEN_THOUSAND;
import static view.message.ExceptionMessage.LIMIT_EXCEED_EXCEPTION_MESSAGE;
import static view.message.ExceptionMessage.THOUSAND_UNIT;
import static view.message.ExceptionMessage.INVALID_UNIT_EXCEPTION_MESSAGE;
import static view.message.ExceptionMessage.DUPLICATE_BONUS_NUMBER_EXCEPTION_MESSAGE;

import java.math.BigDecimal;
import java.util.List;

public record LottoPurchaseInfo(BigDecimal purchaseAmount, Lotto lottoNumbers, int bonusNumber) {

    public LottoPurchaseInfo {
        validateNegativeNumber(purchaseAmount);
        validatePurchaseAmountLimit(purchaseAmount);
        validateThousandUnit(purchaseAmount);
        validateBonusNumberDuplicate(lottoNumbers, bonusNumber);
    }

    public LottoPurchaseInfo(BigDecimal purchaseAmount, List<Integer> lottoNumbers, int bonusNumber) {
        this(purchaseAmount, new Lotto(lottoNumbers), bonusNumber);
    }

    private void validateNegativeNumber(BigDecimal purchaseAmount) {
        if (purchaseAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void validatePurchaseAmountLimit(BigDecimal purchaseAmount) {
        if (purchaseAmount.compareTo(MAX_PURCHASE_AMOUNT_TEN_THOUSAND) > 0) {
            throw new IllegalArgumentException(LIMIT_EXCEED_EXCEPTION_MESSAGE);
        }
    }

    private void validateThousandUnit(BigDecimal purchaseAmount) {
        if (purchaseAmount.remainder(THOUSAND_UNIT)
                          .compareTo(BigDecimal.ZERO) != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_EXCEPTION_MESSAGE);
        }
    }

    private void validateBonusNumberDuplicate(Lotto lottoNumbers, int bonusNumber) {
        if (lottoNumbers.getNumbers()
                        .contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
