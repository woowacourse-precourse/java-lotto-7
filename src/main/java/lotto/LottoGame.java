package lotto;

import java.util.List;

public class LottoGame {

    public int[] calculateResults(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        int[] totalCount = new int[LottoRank.values().length - 1];

        for (Lotto ticket : tickets) {
            int matchCount = ticket.countMatchingNumbers(winningNumbers);
            boolean hasBonus = ticket.containsBonus(bonusNumber);
            LottoRank rank = LottoRank.valueOf(matchCount, hasBonus);

            if (rank != LottoRank.NONE) {
                totalCount[rank.ordinal()]++;
            }
        }
        return totalCount;
    }

    public int calculateTotalPrize(int[] totalCount) {
        int totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NONE) continue;
            totalPrize += totalCount[rank.ordinal()] * rank.getPrize();
        }
        return totalPrize;
    }

    public double calculateEarningRate(int totalPrize, int investment) {
        return ((double) totalPrize / investment) * 100;
    }
}
