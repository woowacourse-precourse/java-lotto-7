package lotto.model;

import lotto.io.ConsoleOutputHandler;

import java.util.List;

public class Game {
    private final int[] rankCount;
    private long totalPrize;
    private int buyAmount;

    public Game(List<Lotto> lottoList, WinningNumber winningNumber, BonusNumber bonusNumber) {
        rankCount = new int[LottoRank.values().length];
        totalPrize = 0;

        for (Lotto lotto : lottoList) {
            int count = lotto.matchingWinningNumber(winningNumber);
            boolean bonus = lotto.matchingBounsNumber(bonusNumber);

            LottoRank rank = getRankByMatchingCount(count, bonus);
            rankCount[rank.getRank()]++;
            totalPrize += rank.getPrize();
            buyAmount++;
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
        double rate = totalPrize / (double)(buyAmount*1000);
        double roundedRate = Math.round(rate * 1000) / 10.0;
        ConsoleOutputHandler.returnRateMessage(roundedRate);
    }

    public void outLottoRankCountInfo() {
        for (int i = LottoRank.values().length - 1; i >= 0; i--) {
            LottoRank rank = LottoRank.values()[i];
            if (rank != LottoRank.NONE) {
                int count = rankCount[rank.getRank()];
                ConsoleOutputHandler.LottoRankCountInfoMessage(rank.getDescription(), rank.getPrize(), count);
            }
        }
    }
}
