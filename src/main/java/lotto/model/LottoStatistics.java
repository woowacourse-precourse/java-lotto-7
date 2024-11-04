package lotto.model;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LottoStatistics {
    public static final int RANK_OFFSET = 8;
    public static final int MAX_WIN_RANK = 5;
    public static final int BONUS_CALCULATE_RANK = 5;
    Map<Integer, Integer> matchResult;
    private final List<Lotto> lottos;
    private final Lotto winningNumbers;
    private final Integer bonusNumber;

    private LottoStatistics(List<Lotto> lottos, Lotto winningNumbers, Integer bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        initializeResultMap();
        createStatistics();
    }

    public static LottoStatistics create(List<Lotto> lottos, Lotto winningNumbers, Integer bonusNumber) {
        return new LottoStatistics(lottos, winningNumbers, bonusNumber);
    }

    public Map<Integer, Integer> getMatchResult() {
        return matchResult;
    }

    public long getTotalEarnings() {

        long totalEarnings = 0;
        Map<Integer, Integer> earningsByRank = Map.of(
            1, 2000000000,
            2, 30000000,
            3, 1500000,
            4, 50000,
            5, 5000
        );
        for (Integer rank : matchResult.keySet()) {
            totalEarnings += (long) matchResult.get(rank) * earningsByRank.get(rank);
        }
        return totalEarnings;
    }

    private void createStatistics() {
        for (Lotto lotto : lottos) {
            int rank = getRank(lotto);
            if (rank <= MAX_WIN_RANK) {
                matchResult.merge(rank, 1, Integer::sum);
            }
        }
    }

    private void initializeResultMap() {
        Map<Integer, Integer> defaultResultValue = Map.of(
            1, 0,
            2, 0,
            3, 0,
            4, 0,
            5, 0
        );
        matchResult = new TreeMap<>(defaultResultValue);
    }

    private int getRank(Lotto lotto) {
        int matchCount = lotto.getMatchNumbersCount(winningNumbers);

        int rank = RANK_OFFSET - matchCount;
        if (rank >= BONUS_CALCULATE_RANK && lotto.getNumbers().contains(bonusNumber)) {
            rank--;
        }

        return rank;
    }
}
