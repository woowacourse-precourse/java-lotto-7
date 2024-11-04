package lotto.dto;

import lotto.validator.DTOValidator;

public record LottoPurchasedAmountInput(String rawAmount) {

    private static final DTOValidator validator = new DTOValidator();

    public static LottoPurchasedAmountInput from(String rawAmount) {
        validator.NotNull(rawAmount);
        validator.Empty(rawAmount);

        return new LottoPurchasedAmountInput(rawAmount);
    }
}
