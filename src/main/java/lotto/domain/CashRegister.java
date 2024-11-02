package lotto.domain;

public class CashRegister {
    private final int money;
    private final int SINGLE_LOTTO_PRICE = 1000;

    public CashRegister(int money) {
        this.money = money;
    }


    private int calculateLottoCount() {
        return this.money / SINGLE_LOTTO_PRICE;
    }

}
