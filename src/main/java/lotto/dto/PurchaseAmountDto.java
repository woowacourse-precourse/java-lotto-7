package lotto.dto;

import lotto.exception.LottoExceptionStatus;
import lotto.properties.LottoProperties;

public record PurchaseAmountDto(
        int purchaseAmount
) {

    public PurchaseAmountDto {
        validate(purchaseAmount);
    }

    private void validate(int purchaseAmount) {
        if (isAmountInvalid(purchaseAmount)) {
            throw new IllegalArgumentException(LottoExceptionStatus.INVALID_LOTTO_PURCHASE_AMOUNT.getMessage());
        }
    }

    private boolean isAmountInvalid(int purchaseAmount){
        return purchaseAmount % LottoProperties.LOTTO_PRICE != 0;
    }

    public static PurchaseAmountDto from(String input) {
        return new PurchaseAmountDto(
                Integer.parseInt(input)
        );
    }
}
