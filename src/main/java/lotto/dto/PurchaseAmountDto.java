package lotto.dto;


import lotto.utils.LottoUtils;

import static lotto.exception.LottoExceptionStatus.INVALID_LOTTO_PURCHASE_AMOUNT;
import static lotto.properties.LottoProperties.LOTTO_PRICE;

public record PurchaseAmountDto(
        int purchaseAmount
) {

    public PurchaseAmountDto {
        validate(purchaseAmount);
    }

    private void validate(int purchaseAmount) {
        if (isAmountInvalid(purchaseAmount)) {
            throw new IllegalArgumentException(INVALID_LOTTO_PURCHASE_AMOUNT.getMessage());
        }
    }

    private boolean isAmountInvalid(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE != 0;
    }

    public static PurchaseAmountDto from(String input) {
        return new PurchaseAmountDto(LottoUtils.checkPurchaseNumberFormat(input));
    }
}
