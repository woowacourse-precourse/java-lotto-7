package lotto.model.lotto;

import java.util.List;
import lotto.model.lotto.Lotto;

public class WinningLotto extends Lotto {

    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumber(List<Integer> comparedNumbers) {
        int matchCount = 0;
        for (Integer number : comparedNumbers) {
            if (this.numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean isBonusMatched(List<Integer> comparedNumbers) {
        return comparedNumbers.contains(bonusNumber);
    }
}
