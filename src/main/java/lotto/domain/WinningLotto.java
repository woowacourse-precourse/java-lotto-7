package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.numbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Rank match(Lotto lotto) {
        long matchCount = lotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

        return Rank.findRank((int) matchCount, bonusMatch);
    }

    public Map<Rank, Integer> calculateResults(List<Lotto> lottos) {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottos) {
            Rank rank = this.match(lotto);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
        return results;
    }
}
