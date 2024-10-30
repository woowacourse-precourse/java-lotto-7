package lotto;

public class Purchase {

    private final int money;

    public Purchase(String money) {
        this.money = Integer.parseInt(money);
    }

    public int numberOfPurchases() {
        return money / 1000;
    }
}
