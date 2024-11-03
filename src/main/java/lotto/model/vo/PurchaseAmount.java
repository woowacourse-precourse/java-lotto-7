package lotto.model.vo;

import lotto.util.LottoUtils;

public record PurchaseAmount(int amount) {
    
    private static final String MESSAGE = "구매 금액은";

    public static PurchaseAmount fromString(String purchaseAmount) {
        LottoUtils.validatePositiveNumber(purchaseAmount,MESSAGE);
        return new PurchaseAmount(Integer.parseInt(purchaseAmount));
    }
}
