package lotto;

import lotto.messages.SystemMessage;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public abstract class LottoManager {

    public static int getTotal(int price) {
        return price / 1000;
    }

    public static Map<LottoRank, Integer> findWinningLotto(LottoList lottoList, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> rankCount = new HashMap<>();

        for (Lotto lotto : lottoList.getLottoList()) {
            LottoRank rank = determineRank(lotto.getNumbers(), winningNumbers, bonusNumber);
            if (rank != null) {
                rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
            }
        }

        printWinningStatistics(rankCount);
        return rankCount;
    }

    private static LottoRank determineRank(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = getMatchCount(lottoNumbers, winningNumbers);
        boolean bonusMatch = lottoNumbers.contains(bonusNumber);

        for (LottoRank rank : LottoRank.values()) {
            if (rank.getMatchCount() == matchCount && rank.isBonusMatch() == bonusMatch) {
                return rank;
            }
        }
        return null;
    }

    private static void printWinningStatistics(Map<LottoRank, Integer> rankCount) {
        System.out.println(SystemMessage.WINNING_NUMBER_RESULT);
        System.out.println("---");

        for (LottoRank rank : LottoRank.values()) {
            int count = rankCount.getOrDefault(rank, 0);
            System.out.printf("%s (%,d원) - %d개%n", rank.getMatchDescription(), rank.getPrize(), count);
        }
    }

    private static int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public static double calculateProfit(Map<LottoRank, Integer> rankCount, int totalSpent) {
        double totalPrize = 0;
        for (Map.Entry<LottoRank, Integer> entry : rankCount.entrySet()) {
            totalPrize += entry.getKey().getPrize() * entry.getValue();
        }
        return Math.round((totalPrize / totalSpent) * 1000.0) / 10.0;
    }
}
