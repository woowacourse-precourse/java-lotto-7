package lotto.domain.earning;

import lotto.domain.winning.WinningRank;

import java.util.Map;

public class Earning {

    private final double earning;

    public Earning(int purchaseAmount,  Map<WinningRank, Integer> winningStatics) {
        this.earning = calculateEarning(purchaseAmount, winningStatics);
    }

    public double getEarning() {
        return this.earning;
    }

    private double calculateEarning(int purchaseAmount, Map<WinningRank, Integer> winningStatics) {
        double totalWinningMoney = 0;

        for (WinningRank winningRank : WinningRank.values()) {
            int count = winningStatics.get(winningRank);
            totalWinningMoney += winningRank.getWinningMoney() * count;
        }

        return (totalWinningMoney / purchaseAmount) * 100;
    }
}
