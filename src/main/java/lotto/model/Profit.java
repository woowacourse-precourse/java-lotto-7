package lotto.model;

public class Profit {
    public static final int THREE_MATCH_PRIZE = 5000;
    public static final int FOUR_MATCH_PRIZE = 50_000;
    public static final int FIVE_MATCH_PRIZE = 1_500_000;
    public static final int FIVE_AND_BONUS_MATCH_PRIZE = 30_000_000;
    public static final int SIX_MATCH_PRIZE = 2_000_000_000;

    private int purchasePrice;
    private int totalMoney;
    private double rate;

    public Profit(int purchasePrice) {
        this.purchasePrice = purchasePrice;
        totalMoney = 0;
    }

    public void calculateTotalMoney(MatchNumbers matchNumbers) {
        totalMoney = matchNumbers.getThreeMatch() * THREE_MATCH_PRIZE
        + matchNumbers.getFourMatch() * FOUR_MATCH_PRIZE
        + matchNumbers.getFiveMatch() * FIVE_MATCH_PRIZE
        + matchNumbers.getFiveAndBonusMatch() * FIVE_AND_BONUS_MATCH_PRIZE
        + matchNumbers.getSixMatch() * SIX_MATCH_PRIZE;
    }

    public void calculateRate() {
        rate = (double) totalMoney / purchasePrice;
    }

    public double getRate() {
        return Math.round(rate * 1000) / 10.0;
    }
}
