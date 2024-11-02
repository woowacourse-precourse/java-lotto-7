package lotto.dto;

import static lotto.validator.LottoPurchaseAmountValidator.validateLottoPurchaseAmount;

public record LottoPurchaseAmount(
        String lottoPurchaseAmount
) {
    public LottoPurchaseAmount {
        validateLottoPurchaseAmount(lottoPurchaseAmount);
    }
}
