package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {

    private final static int BONUS_NUMBER_MATCH_COUNT = 5;
    private final static int FIRST_PLACE_PRIZE = 2000000000;
    private final static int SECOND_PLACE_PRIZE = 30000000;
    private final static int THIRD_PLACE_PRIZE = 1500000;
    private final static int FORTH_PLACE_PRIZE = 50000;
    private final static int FIFTH_PLACE_PRIZE = 5000;

    private WinningNumber winningNumber;


    public LottoResultCalculator(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public Rank calculateRanking(Lotto userLotto) {
        int matchCount = winningNumber.findMatchCount(userLotto);
        boolean matchedBonusNumber = matchCount == BONUS_NUMBER_MATCH_COUNT && winningNumber.hasMatchingBonusNumberWith(userLotto);

        return Rank.findRankByMatchCount(matchCount, matchedBonusNumber);
    }

    public Map<Rank, Integer> calculateRanking(List<Lotto> lotteries) {
        Map<Rank, Integer> statistics = new HashMap<>();
        lotteries.forEach(lotto -> {
            Rank rank = calculateRanking(lotto);
            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        });

        return statistics;
    }

    public double calculateRateOfReturn(Map<Rank, Integer> results, int totalAmount) {
        int totalRevenue = 0;

        totalRevenue += results.getOrDefault(Rank.FIRST_PLACE, 0) * FIRST_PLACE_PRIZE;
        totalRevenue += results.getOrDefault(Rank.SECOND_PLACE, 0) * SECOND_PLACE_PRIZE;
        totalRevenue += results.getOrDefault(Rank.THIRD_PLACE, 0) * THIRD_PLACE_PRIZE;
        totalRevenue += results.getOrDefault(Rank.FORTH_PLACE, 0) * FORTH_PLACE_PRIZE;
        totalRevenue += results.getOrDefault(Rank.FIFTH_PLACE, 0) * FIFTH_PLACE_PRIZE;

        if (totalAmount > 0) {
            return ((double) totalRevenue / totalAmount) * 100;
        }

        return 0;
    }
}
