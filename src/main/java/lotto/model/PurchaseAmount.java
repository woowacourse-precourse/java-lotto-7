package lotto.model;

public class PurchaseAmount {
    public static final int LOTTO_PRICE = 1000;
    private final int lottoCount;
    private final int amount;

    public PurchaseAmount(int amount) {
        this.amount = amount;
        this.lottoCount = calculateLottoCount(amount);
    }

    private int calculateLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getAmount() {
        return amount;
    }
}
