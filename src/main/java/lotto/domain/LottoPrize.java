package lotto.domain;

public enum LottoPrize {

    FIFTH_PRIZE(3, 5_000),
    FOURTH_PRIZE(4, 50_000),
    THIRD_PRIZE(5, 1_500_000),
    SECOND_PRIZE(5, 30_000_000),
    FIRST_PRIZE(6, 2_000_000_000);

    private static final String describePrize = "%d개 일치%s (%s원)";
    private static final String additionalDescribeBonusPrize = ", 보너스 볼 일치";
    private final int matchCount;
    private final int prizeMoney;

    LottoPrize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }


    @Override
    public String toString() {
        String formattedPrizeMoney = String.format("%,d", prizeMoney);
        if (SECOND_PRIZE.equals(this)) {
            return describePrize.formatted(matchCount, additionalDescribeBonusPrize, formattedPrizeMoney);
        }
        return describePrize.formatted(matchCount, "", formattedPrizeMoney);
    }
}
