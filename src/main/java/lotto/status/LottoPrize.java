package lotto.status;

public enum LottoPrize {
    RANK1(2_000_000_000, "6개 일치"),
    RANK2(30_000_000, "5개 일치, 보너스 볼 일치"),
    RANK3(1_500_000, "5개 일치"),
    RANK4(50_000, "4개 일치"),
    RANK5(5_000, "3개 일치");

    final int money;
    final String title;

    LottoPrize(int money, String title) {
        this.money = money;
        this.title = title;
    }

    public int getMoney() {
        return money;
    }

    public String getTitle() {
        return title;
    }
}
