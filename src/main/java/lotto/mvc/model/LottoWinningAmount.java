package lotto.mvc.model;

public enum LottoWinningAmount {
    THREE(3, 5_000), FOUR(4, 50_000), FIVE(5, 1_500_000),
    FIVE_PLUS_BONUS(5, 30_000_000, true), SIX(6, 2_000_000_000);

    private int count;
    private int amount;
    private boolean bonus;

    LottoWinningAmount(int count, int amount) {
        this.count = count;
        this.amount = amount;
    }

    LottoWinningAmount(int count, int amount, boolean bonus) {
        this.count = count;
        this.amount = amount;
        this.bonus = bonus;
    }

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }

    public boolean getBonus() {
        return bonus;
    }
}
