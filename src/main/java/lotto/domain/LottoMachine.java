package lotto.domain;

public class LottoMachine {
    private static final LottoMachine instance = new LottoMachine();
    private int purchaseAmount;

    private LottoMachine() {

    }

    public static LottoMachine getInstance() {
        return instance;
    }

    public void savePurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
