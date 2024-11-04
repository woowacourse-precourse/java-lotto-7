package lotto;

import util.Rank;

import java.util.List;

public class LottoResult {

    public int[] calculateRank(List<Lotto> lottoNumber, Lotto winner, int bonusNumber) {
        int[] result = new int[Rank.values().length];

        for (Lotto lotto : lottoNumber) {
            int countMatchingNumbers = lotto.countMatchingNumbers(winner);
            boolean matchBonus = lotto.checkBonus(bonusNumber);
            Rank rank = Rank.getRank(countMatchingNumbers, matchBonus);

            if (rank != null) result[rank.ordinal()]++;
        }

        return result;
    }

    public double calculateProfitRate(int[] result, int purchaseAmount) {
        int totalWinning = 0;

        for (int i = 0; i < result.length; i++) {
            totalWinning += result[i] * Rank.values()[i].getPrize();
        }

        return totalWinning / (double) purchaseAmount * 100.0;
    }
}
