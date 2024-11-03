package lotto.service;

public enum Prize {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000);

    private final int cnt;
    private final int price;
    private final boolean bonus;

    Prize(int cnt, int price) {
        this(cnt, price, false);
    }

    Prize(int cnt, int price, boolean bonus) {
        this.cnt = cnt;
        this.price = price;
        this.bonus = bonus;
    }

    public int getCnt() {
        return cnt;
    }

    public int getPrice() {
        return price;
    }

    public boolean isBonus() {
        return bonus;
    }
}
