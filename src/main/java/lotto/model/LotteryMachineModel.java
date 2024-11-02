package lotto.model;

import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.entity.BonusNumber;
import lotto.entity.PurchaseAmount;
import lotto.entity.WinnerNumber;

public class LotteryMachineModel {

    PurchaseAmount purchaseAmount;
    WinnerNumber winnerNumber;
    BonusNumber bonusNumber;

    public LotteryMachineModel() {
        this.purchaseAmount = new PurchaseAmount(0L);
        this.winnerNumber = new WinnerNumber(List.of(1, 2, 3, 4, 5, 6));
        this.bonusNumber = new BonusNumber(7);
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

    public void settingBonusNumber(BonusNumber bonusNumber) {
        validateDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(BonusNumber bonusNumber) {
        boolean isPresentNumber = winnerNumber.numbers()
                .contains(bonusNumber.number());
        if (isPresentNumber) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_DUPLICATED);
        }
    }
}
