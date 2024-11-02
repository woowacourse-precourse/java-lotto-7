package lotto.domain;

public class Money {

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validate(int money) {
        if ((money % 1000) * 1000 != money) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 구매 가능 합니다.");
        }
    }
}