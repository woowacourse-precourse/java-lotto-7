package lotto.model;

public class Profit {
    public static final int THREE_MATCH_PRIZE = 5000;
    public static final int FOUR_MATCH_PRIZE = 50_000;
    public static final int FIVE_MATCH_PRIZE = 1_500_000;
    public static final int FIVE_AND_BONUS_MATCH_PRIZE = 30_000_000;
    public static final int SIX_MATCH_PRIZE = 2_000_000_000;

    private final int purchasePrice;
    private long totalMoney;
    private double rate;

    public Profit(final int purchasePrice) {
        this.purchasePrice = purchasePrice;
        totalMoney = 0;
    }

    public void calculateTotalPrize(final MatchNumbers matchNumbers) {
        totalMoney = (long) matchNumbers.getThreeMatch() * THREE_MATCH_PRIZE
                + (long) matchNumbers.getFourMatch() * FOUR_MATCH_PRIZE
                + (long) matchNumbers.getFiveMatch() * FIVE_MATCH_PRIZE
                + (long) matchNumbers.getFiveAndBonusMatch() * FIVE_AND_BONUS_MATCH_PRIZE
                + (long) matchNumbers.getSixMatch() * SIX_MATCH_PRIZE;
    }

    public void calculateRate() {
        rate = (double) totalMoney / purchasePrice;
    }

    public double getRate() {
        return Math.round(rate * 1000) / 10.0;
    }
}