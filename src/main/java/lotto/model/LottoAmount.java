package lotto.model;

public class LottoAmount {

    private static final int MONEY = 1000;
    private final int amount;

    public LottoAmount(int price) {
        this.amount = price / MONEY;
    }

    public int get() {
        return amount;
    }
}
