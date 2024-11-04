package lotto.model;

import lotto.io.ConsoleOutputHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private final Map<LottoRank, Integer> rankCount;
    private int totalPrize;

    public Game(List<Lotto> lottoList, WinningNumber winningNumber, BonusNumber bonusNumber) {
        rankCount = new HashMap<>();
        totalPrize = 0;

        for (Lotto lotto : lottoList) {
            int count = lotto.matchingWinningNumber(winningNumber);
            boolean bonus = lotto.matchingBounsNumber(bonusNumber);

            LottoRank rank = getRankByMatchingCount(count, bonus);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
            totalPrize += rank.getPrize();
        }
    }

    private LottoRank getRankByMatchingCount(int count, boolean bonus) {
        if (count == 6) {
            return LottoRank.FIRST;
        }
        if (count == 5 && bonus) {
            return LottoRank.SECOND;
        }
        if (count == 5) {
            return LottoRank.THIRD;
        }
        if (count == 4) {
            return LottoRank.FOURTH;
        }
        if (count == 3) {
            return LottoRank.FIFTH;
        }
        return LottoRank.NONE;
    }

    public void outReturnRate() {
        int buyLottoCount = 0;
        for (int count : rankCount.values()) {
            buyLottoCount += count;
        }

        double rate = (double) totalPrize / (buyLottoCount * 1000);
        double roundedRate = Math.round(rate * 10) / 10.0;
        ConsoleOutputHandler.returnRateMessage(roundedRate);
    }
}
