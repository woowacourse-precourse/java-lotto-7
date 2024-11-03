package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Result {
    public static int[] calculateResults(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        int[] results = new int[LottoRank.values().length - 1];
        Set<Integer> winningSet = new HashSet<>(winningNumbers);

        for (Lotto ticket : tickets) {
            int matchCount = getMatchCount(ticket, winningSet);
            boolean bonusMatch = isBonusMatch(ticket, bonusNumber);

            LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);
            if (rank != LottoRank.MISS) {
                results[getRankIndex(rank)]++;
            }
        }
        return results;
    }

    private static int getMatchCount(Lotto ticket, Set<Integer> winningSet) {
        int matchCount = 0;
        for (int number : ticket.getNumbers()) {
            if (winningSet.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private static boolean isBonusMatch(Lotto ticket, int bonusNumber) {
        for (int number : ticket.getNumbers()) {
            if (number == bonusNumber) {
                return true;
            }
        }
        return false;
    }

    private static int getRankIndex(LottoRank rank) {
        if (rank == LottoRank.FIFTH) {
            return 4;
        }
        if (rank == LottoRank.FOURTH) {
            return 3;
        }
        if (rank == LottoRank.THIRD) {
            return 2;
        }
        if (rank == LottoRank.SECOND) {
            return 1;
        }
        if (rank == LottoRank.FIRST) {
            return 0;
        }
        throw new IllegalArgumentException();
    }

    public static double calculateProfitRate(int[] results, int purchaseAmount) {
        int winnings = calculateWinnings(results);
        return (double) winnings / purchaseAmount * 100;
    }

    private static int calculateWinnings(int[] results){
        int winnings = 0;
        for (int i = 0; i < results.length; i++) {
            winnings += LottoRank.values()[i].getPrize() * results[i];
        }
        return winnings;
    }

}
