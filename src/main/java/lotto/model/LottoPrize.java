package lotto.model;

public enum LottoPrize {
    RANK_1(2_000_000_000),
    RANK_2(30_000_000),
    RANK_3(1_500_000),
    RANK_4(50_000),
    RANK_5(5_000);

    private final int money;

    LottoPrize(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
