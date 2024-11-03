package lotto.dto;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public record LottoPurchasedAmountInput(String rawAmount) {

    private static void validateLottoPurchasedAmountNotNull(String rawAmount) {
        if (rawAmount == null) {
            throw LottoException.from(ErrorMessage.NULL_INPUT_ERROR);
        }
    }

    private static void validateLottoPurchasedAmountEmpty(String rawAmount) {
        if (rawAmount.isEmpty()) {
            throw LottoException.from(ErrorMessage.EMPTY_INPUT_ERROR);
        }
    }

    public static LottoPurchasedAmountInput from(String rawAmount) {
        validateLottoPurchasedAmountNotNull(rawAmount);
        validateLottoPurchasedAmountEmpty(rawAmount);
        return new LottoPurchasedAmountInput(rawAmount);
    }
}
