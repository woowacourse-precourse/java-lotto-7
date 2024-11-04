package View;

public enum Prize {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000);

    private int PrizeAmount;

    Prize(int PrizeAmount) {
        this.PrizeAmount = PrizeAmount;
    }

    public int getPrizeAmount() {
        return PrizeAmount;
    }
}
