package lotto.dto;

import lotto.validator.DTOValidator;

public record LottoPurchasedAmountInput(String rawAmount) {

    private static final DTOValidator dTOValidator = new DTOValidator();

    public static LottoPurchasedAmountInput from(String rawAmount) {
        dTOValidator.NotNull(rawAmount);
        dTOValidator.Empty(rawAmount);
        return new LottoPurchasedAmountInput(rawAmount);
    }
}
