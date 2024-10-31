package lotto.model;

public class LottoManager {
    private final int PRICE_OF_LOTTO = 1000;
    public int getBuyableCount(Money money) {
        int leftMoney = money.getLeftMoney();
        return leftMoney / PRICE_OF_LOTTO;
    }
}
