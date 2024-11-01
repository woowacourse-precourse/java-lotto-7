package lotto.domain.earning;

import lotto.domain.winning.WinningRank;

import java.util.Map;

public class Earning {

    public double getEarning(int purchasement, Map<WinningRank, Integer> winningStatics) {
        double totalWinningMoney = 0;

        for (WinningRank winningRank : WinningRank.values()) {
            int count = winningStatics.get(winningRank);
            totalWinningMoney += winningRank.getWinningMoney() * count;
        }

        return (totalWinningMoney / purchasement) * 100;
    }
}
