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

    public void make(List<Lotto> lottos, WinningLotto winningLotto) {
        lottos.stream()
                .map(lotto -> calculateRanking(lotto, winningLotto))
                .filter(Optional::isPresent)
                .forEach(rankingOptional -> rankingCount.merge(rankingOptional.get(), 1, Integer::sum));
    }

    public int calculateTotalPrize() {
        return rankingCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public Map<LottoRanking, Integer> getRankingCount() {
        return rankingCount;
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
