package lotto.model;

import java.util.List;
import lotto.entity.PurchaseAmount;
import lotto.entity.WinnerNumber;

public class LotteryMachineModel {

    PurchaseAmount purchaseAmount;
    WinnerNumber winnerNumber;

    public LotteryMachineModel() {
        this.purchaseAmount = new PurchaseAmount(0L);
        this.winnerNumber = new WinnerNumber(List.of(1, 2, 3, 4, 5, 6));
    }

    public PurchaseAmount getPurchaseAmount() {
        return purchaseAmount;
    }

    public WinnerNumber getWinnerNumber() {
        return winnerNumber;
    }

    public void insertPurchaseAmount(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void settingWinnerNumber(WinnerNumber winnerNumber) {
        this.winnerNumber = winnerNumber;
    }
}
