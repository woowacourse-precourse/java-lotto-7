package lotto.domain.result;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.number.WinningNumbers;

public class WinningStatistics {
    private final Map<LottoRank, Integer> rankCounts;

    private WinningStatistics(Map<LottoRank, Integer> rankCounts) {
        this.rankCounts = Collections.unmodifiableMap(new EnumMap<>(rankCounts));
    }

    public static WinningStatistics from(List<Lotto> lottos, WinningNumbers winningNumbers) {
        Map<LottoRank, Integer> rankCounts = initializeRankCounts();

        for (Lotto lotto : lottos) {
            LottoRank rank = LottoRank.valueOf(
                    lotto.countMatchNumbers(winningNumbers.getWinningNumbers()),
                    lotto.matchBonusNumber(winningNumbers.getBonusNumber())
            );
            rankCounts.merge(rank, 1, Integer::sum);
        }

        return new WinningStatistics(rankCounts);
    }

    private static Map<LottoRank, Integer> initializeRankCounts() {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values())
                .forEach(rank -> rankCounts.put(rank, 0));
        return rankCounts;
    }

    public int getCountByRank(LottoRank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    public long calculateTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
