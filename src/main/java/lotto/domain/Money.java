package lotto.domain;

public class Money {
    private static final int DIVISABLE_PRICE = 1000;

    int price;
    int amount;

    public Money(int price) {
        this.price = price;
        this.amount = price / DIVISABLE_PRICE;
    }


    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }
}
