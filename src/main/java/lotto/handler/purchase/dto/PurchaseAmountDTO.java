package lotto.handler.purchase.dto;

public class PurchaseAmountDTO {
    private String purchaseAmount;

    private PurchaseAmountDTO(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmountDTO create(String purchaseAmount) {
        return new PurchaseAmountDTO(purchaseAmount);
    }
}
