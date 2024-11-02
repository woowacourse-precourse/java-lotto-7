package lotto.model;

import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.entity.BonusNumber;
import lotto.entity.IssuedLotto;
import lotto.entity.PurchaseAmount;
import lotto.entity.WinnerNumber;

public class LotteryMachineModel {

    private PurchaseAmount purchaseAmount;
    private WinnerNumber winnerNumber;
    private BonusNumber bonusNumber;
    private IssuedLotto issuedLotto;

    public LotteryMachineModel() {
        this.purchaseAmount = new PurchaseAmount(0L);
        this.winnerNumber = new WinnerNumber(List.of(1, 2, 3, 4, 5, 6));
        this.bonusNumber = new BonusNumber(7);
        this.issuedLotto = new IssuedLotto(List.of());
    }

    public PurchaseAmount getPurchaseAmount() {
        return purchaseAmount;
    }

    public WinnerNumber getWinnerNumber() {
        return winnerNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    public IssuedLotto getIssuedLotto() {
        return issuedLotto;
    }

    public void insertPurchaseAmount(PurchaseAmount purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public void settingWinnerNumber(WinnerNumber winnerNumber) {
        this.winnerNumber = winnerNumber;
    }

    public void settingBonusNumber(BonusNumber bonusNumber) {
        validateDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void settingIssuedLotto(IssuedLotto issuedLotto) {
        this.issuedLotto = issuedLotto;
    }

    public PurchaseAmount consumePurchaseAmount() {
        PurchaseAmount amount = this.purchaseAmount;
        purchaseAmount = new PurchaseAmount(0L);
        return amount;
    }

    private void validateDuplicate(BonusNumber bonusNumber) {
        boolean isPresentNumber = winnerNumber.numbers()
                .contains(bonusNumber.number());
        if (isPresentNumber) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_DUPLICATED);
        }
    }

    public void validatePurchaseAmount(PurchaseAmount purchaseAmount) {
        if (purchaseAmount.purchaseAmount().equals(0L)) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_IS_POSITIVE);
        }
    }
}
