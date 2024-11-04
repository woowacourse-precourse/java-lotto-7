package lotto.model;

public class Money {
    private final int money;
    private static final int PRICE = 1000;
    private static final String INVALID_MONEY = "[ERROR] 로또는 1개당 1,000원입니다.";

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public static void validate(int money) {
        if (money % PRICE > 0) {
            throw new IllegalArgumentException(INVALID_MONEY);
        }
    }

    public int getMoney() {
        return money;
    }

    public int getCount() {
        return money / PRICE;
    }
}
