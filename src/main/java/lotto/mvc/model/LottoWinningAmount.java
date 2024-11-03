package lotto.mvc.model;

public enum LottoWinningAmount {
    THREE(3, 5_000, "3개 일치"),
    FOUR(4, 50_000, "4개 일치"),
    FIVE(5, 1_500_000, "5개 일치"),
    FIVE_PLUS_BONUS(5, 30_000_000, "5개 일치 + 보너스 볼 일치", true),
    SIX(6, 2_000_000_000, "6개 일치");

    private int count;
    private int amount;
    private boolean bonus;
    private String description;

    LottoWinningAmount(int count, int amount, String description) {
        this.count = count;
        this.amount = amount;
        this.description = description;
    }

    LottoWinningAmount(int count, int amount, String description, boolean bonus) {
        this.count = count;
        this.amount = amount;
        this.description = description;
        this.bonus = bonus;
    }

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isBonus() {
        return bonus;
    }

    public String getDescription() {
        return description;
    }
}
