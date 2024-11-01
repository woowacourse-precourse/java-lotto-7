package lotto.model.lotto;

import java.util.List;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumberWith(List<Integer> comparedNumbers) {
        int matchCount = 0;
        for (Integer number : comparedNumbers) {
            if (this.lotto.numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean isBonusNumberMatchedWith(List<Integer> comparedNumbers) {
        return comparedNumbers.contains(bonusNumber);
    }
}
