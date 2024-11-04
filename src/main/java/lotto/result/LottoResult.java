package lotto.result;

import lotto.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoResult {

    private final Map<LottoRank, Integer> resultStatistics;

    public LottoResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        resultStatistics = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoRank rank = matchCount(lotto, winningNumbers, bonusNumber);
            resultStatistics.put(rank, resultStatistics.getOrDefault(rank, 0) + 1);
        }
    }

    private LottoRank matchCount(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        long matchCount = lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
        boolean hasBonus = lotto.getNumbers().contains(bonusNumber);

        return LottoRank.valueOf((int) matchCount, hasBonus);
    }

    public Map<LottoRank, Integer> getStatistics() {
        return resultStatistics;
    }

    public List<Integer> extractMatchCounts() {
        return Stream.of(LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST)
                .map(rank -> resultStatistics.getOrDefault(rank, 0))
                .collect(Collectors.toList());
    }
}
