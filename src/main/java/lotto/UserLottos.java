package lotto;

public class UserLottos {
    private final int purchaseAmount;

    public UserLottos(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount == 0 || purchaseAmount % LottoInfo.PRICE.getInfo() != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_THOUSAND_UNIT_ERROR.getMessage());
        }
    }
}
