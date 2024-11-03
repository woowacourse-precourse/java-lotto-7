package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LottoStatistics {
    private final Map<LottoRanking, Integer> rankingCount;

    public LottoStatistics() {
        this.rankingCount = new EnumMap<>(LottoRanking.class);
    }

    public int calculateTotalPrize() {
        return rankingCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private Optional<LottoRanking> calculateRanking(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = calculateMatchCount(lotto, winningLotto.getNumbers());
        boolean matchBonus = isBonusNumberMatched(lotto, winningLotto.getBonusNumber());

        return Optional.ofNullable(LottoRanking.of(matchCount, matchBonus));
    }

    private int calculateMatchCount(Lotto lotto, List<Integer> numbers) {
        return (int) lotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();
    }

    private boolean isBonusNumberMatched(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
