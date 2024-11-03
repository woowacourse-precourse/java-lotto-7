package lotto.domain;

public class Money {

    public static final int MIN_AMOUNT_TO_BUY_LOTTO = 1000;
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validate(int money) {
        if ((money % MIN_AMOUNT_TO_BUY_LOTTO) * MIN_AMOUNT_TO_BUY_LOTTO != money) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 구매 가능 합니다.");
        }
    }
}