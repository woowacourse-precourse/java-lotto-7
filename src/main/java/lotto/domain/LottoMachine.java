package lotto.domain;

public class LottoMachine {
    private static final LottoMachine instance = new LottoMachine();
    private int purchaseAmount;
    private int bonusNumber;

    private LottoMachine() {

    }

    public static LottoMachine getInstance() {
        return instance;
    }

    public void savePurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void saveBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
