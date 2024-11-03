package lotto.domain;

public class Prize implements Money {
    private long money;

    public Prize(long money) {
        this.money = money;
    }

    @Override
    public long getMoney() {
        return money;
    }
}