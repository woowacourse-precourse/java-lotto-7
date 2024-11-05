package lotto.util;

import lotto.domain.JackpotNumbers;
import lotto.domain.Lotto;
import lotto.domain.Ranking;

import java.util.*;

public abstract class RankingEvaluator {

    public static Map<Ranking, Integer> evaluateAll(List<Lotto> purchasedLottos, JackpotNumbers jackpotNumbers) {
        Map<Ranking, Integer> rankingMap = initRankingMap();

        purchasedLottos.stream()
                .map(lotto -> evaluateRank(lotto, jackpotNumbers))
                .forEach(ranking -> rankingMap.merge(ranking, 1, Integer::sum));

        return rankingMap;
    }

    private static Map<Ranking, Integer> initRankingMap() {
        Map<Ranking, Integer> rankingMap = new LinkedHashMap<>();
        Arrays.stream(Ranking.values())
                        .sorted(Collections.reverseOrder())
                                .forEach(ranking -> rankingMap.put(ranking, 0));
        return rankingMap;
    }

    private static Ranking evaluateRank(Lotto lotto, JackpotNumbers jackpotNumbers) {
        int matchingCount = countMatchingNumbers(lotto, jackpotNumbers.getLotto());
        boolean isMatchBonusNumber = lotto.getNumbers().contains(jackpotNumbers.getBonusNumber());
        return Ranking.getRanking(matchingCount, isMatchBonusNumber);
    }

    private static int countMatchingNumbers(Lotto lotto, Lotto jackpot) {
        return (int) lotto.getNumbers().stream()
                .filter(jackpot.getNumbers()::contains)
                .count();
    }
}
