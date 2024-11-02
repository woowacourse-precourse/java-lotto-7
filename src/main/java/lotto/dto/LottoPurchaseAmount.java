package lotto.dto;

import static lotto.validator.LottoPurchaseAmountValidator.validateLottoPurchaseAmount;

public record LottoPurchaseAmount(
        int lottoPurchaseAmount
) {
    public static LottoPurchaseAmount from(String inputLottoPurchaseAmount) {
        validateLottoPurchaseAmount(inputLottoPurchaseAmount);
        return new LottoPurchaseAmount(Integer.parseInt(inputLottoPurchaseAmount));
    }
}
