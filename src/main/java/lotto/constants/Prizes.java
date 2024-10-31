package lotto.constants;

public enum Prizes {

    FIRST_PRIZE(2_000_000_000, 6),
    SECOND_PRIZE(30_000_000, 5),
    THIRD_PRIZE(1_500_000, 5),
    FOURTH_PRIZE(50_000, 4),
    FIFTH_PRIZE(5_000, 3);

    private final int money;
    private final int count;

    Prizes(int money, int count) {
        this.money = money;
        this.count = count;
    }

    public int getMoney() {
        return this.money;
    }

    public int getCount() {
        return this.count;
    }
}
