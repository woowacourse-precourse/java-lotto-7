package lotto.constants;

public enum Prizes {

    FIRST_PRIZE(2_000_000_000, 6, false, ""),
    SECOND_PRIZE(30_000_000, 5, true, ", 보너스 볼 일치"),
    THIRD_PRIZE(1_500_000, 5, false, ""),
    FOURTH_PRIZE(50_000, 4, false, ""),
    FIFTH_PRIZE(5_000, 3, false, "");

    private final int money;
    private final int count;
    private final boolean bonus;
    private final String bounsComment;

    Prizes(int money, int count, boolean bonus, String bounsComment) {
        this.money = money;
        this.count = count;
        this.bonus = bonus;
        this.bounsComment = bounsComment;
    }

    public int getMoney() {
        return this.money;
    }

    public int getCount() {
        return this.count;
    }

    public boolean getBonus() {
        return bonus;
    }

    public String getComment() {
        return bounsComment;
    }
}
