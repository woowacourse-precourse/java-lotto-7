package lotto;

public class UserLottos {
    private final int purchaseAmount;
    private final int quantity;

    public UserLottos(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.quantity = calculateQuantity();
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount == 0 || purchaseAmount % LottoInfo.PRICE.getInfo() != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_THOUSAND_UNIT_ERROR.getMessage());
        }
    }

    private int calculateQuantity() {
        return this.purchaseAmount / LottoInfo.PRICE.getInfo();
    }

    public int getQuantity() {
        return this.quantity;
    }
}
