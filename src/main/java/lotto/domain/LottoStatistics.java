package lotto.domain;

import java.util.List;

public class LottoStatistics {
    private int calculateMatchCount(Lotto lotto, List<Integer> numbers) {
        return (int) lotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();
    }

    private boolean isBonusNumberMatched(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
