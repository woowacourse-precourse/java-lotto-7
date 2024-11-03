package lotto.dto.entity;

public class Receipt {
    private int purchaseAmount;
    public Receipt(int purchaseAmount){
        this.purchaseAmount = purchaseAmount;
    }
    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
