package lotto.model;

import lotto.model.constant.Match;

public class Profit {

    private final int purchasePrice;
    private long totalMoney;
    private double rate;

    public Profit(final int purchasePrice) {
        this.purchasePrice = purchasePrice;
        totalMoney = 0;
    }

    public void calculateTotalPrize(final MatchNumbers matchNumbers) {
        totalMoney = (long) matchNumbers.getThreeMatch() * Match.THREE.getPrize()
                + (long) matchNumbers.getFourMatch() * Match.FOUR.getPrize()
                + (long) matchNumbers.getFiveMatch() * Match.FIVE.getPrize()
                + (long) matchNumbers.getFiveAndBonusMatch() * Match.BONUS.getPrize()
                + (long) matchNumbers.getSixMatch() * Match.SIX.getPrize();
    }

    public void calculateRate() {
        rate = (double) totalMoney / purchasePrice;
    }

    public double getRate() {
        return Math.round(rate * 1000) / 10.0;
    }
}