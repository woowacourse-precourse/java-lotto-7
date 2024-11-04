package lotto.service;

public class LottoService {
    private int money;

    public int getAmount(int money) {
        this.money = money;
        return money / 1000;
    }
}
