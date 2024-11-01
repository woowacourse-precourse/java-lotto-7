package lotto.model;

import lotto.entity.PurchaseAmount;

public class LotteryMachineModel {

    PurchaseAmount purchaseAmount;

    public LotteryMachineModel() {
        this.purchaseAmount = new PurchaseAmount(0L);
    }

    public PurchaseAmount getPurchaseAmount() {
        return purchaseAmount;
    }

    public void insertPurchaseAmount(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }
}
