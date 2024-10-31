package lotto.domain;

import java.util.List;
import java.util.Optional;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Optional<Ranking> calculateRanking(Lotto lotto) {
        int count = 0;
        for (Integer number : numbers) {
            if (lotto.contains(number)) {
                count++;
            }
        }

        return Ranking.findBy(count, lotto.contains(bonusNumber));
    }
}
