package lotto.dto;

public class PurchaseAmountRequestDto {
    private final int purchaseAmount;
    public PurchaseAmountRequestDto(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }
    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }
}
