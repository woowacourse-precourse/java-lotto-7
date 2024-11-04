package lotto.model;

public class Calculator {
    private final static int LOTTO_PRICE = 1000;

    public int getLottoCount(String money) {
        return calculateLottoCount(money);
    }

    private int calculateLottoCount(String money) {
        return Integer.parseInt(money) / LOTTO_PRICE;
    }
}
