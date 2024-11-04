package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {
    public static Map<LottoRank, Integer> checkResults(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> resultMap = initializeResultMap();

        for (Lotto lotto : purchasedLottos) {
            int matchCount = calculateMatchCount(lotto, winningNumbers);
            boolean bonusMatch = isBonusMatched(lotto, bonusNumber);

            LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);
            resultMap.put(rank, resultMap.get(rank) + 1);
        }

        return resultMap;
    }

    private static Map<LottoRank, Integer> initializeResultMap() {
        Map<LottoRank, Integer> resultMap = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            resultMap.put(rank, 0);
        }
        return resultMap;
    }

    private static int calculateMatchCount(Lotto lotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private static boolean isBonusMatched(Lotto lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    public static String generateResultSummary(Map<LottoRank, Integer> resultMap) {
        StringBuilder resultSummary = new StringBuilder();

        LottoRank[] ranks = LottoRank.values();
        for (int i = ranks.length - 1; i >= 0; i--) {
            LottoRank rank = ranks[i];
            if (rank == LottoRank.MISS) {
                continue;
            }

            resultSummary.append(String.format("%d개 일치", rank.getMatchCount()));

            if (rank.isMatchBonus()) {
                resultSummary.append(", 보너스 볼 일치");
            }

            resultSummary.append(String.format(" (%,d원) - %d개\n", rank.getPrize(), resultMap.getOrDefault(rank, 0)));
        }

        return resultSummary.toString();
    }

}
