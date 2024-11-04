package lotto.dto.data;

public class Receipt {
    private int purchaseAmount;

    public Receipt(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
