package lotto.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private final List<Lotto> lottos;
    private final WinningNumbers winningNumbers;

    public LottoResult(List<Lotto> lottos, WinningNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public Map<LottoRank, Integer> getResults() {
        return lottos.stream()
                .collect(Collectors.toMap(
                        lotto -> LottoRank.valueOf(getMatchCount(lotto.getNumbers()),
                                getBonusMatch(lotto.getNumbers())),
                        lotto -> 1,
                        Integer::sum
                ));
    }

    private int getMatchCount(List<Integer> numbers) {
        return (int) numbers.stream().
                filter(winningNumbers.winningNumbers()::contains)
                .count();
    }

    private boolean getBonusMatch(List<Integer> numbers) {
        return numbers.contains(winningNumbers.bonusNumber());
    }
}