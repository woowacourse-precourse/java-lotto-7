package lotto.dto;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public record LottoPurchasedAmountInput(String RawAmount) {

    private static void validateLottoPurchasedAmountNotNull(String RawAmount) {
        if (RawAmount == null) {
            throw LottoException.from(ErrorMessage.NULL_INPUT_ERROR);
        }
    }

    private static void validateLottoPurchasedAmountEmpty(String RawAmount) {
        if (RawAmount.isEmpty()) {
            throw LottoException.from(ErrorMessage.EMPTY_INPUT_ERROR);
        }
    }

    public static LottoPurchasedAmountInput from(String RawAmount) {
        validateLottoPurchasedAmountNotNull(RawAmount);
        validateLottoPurchasedAmountEmpty(RawAmount);
        return new LottoPurchasedAmountInput(RawAmount);
    }
}
