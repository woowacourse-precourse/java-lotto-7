package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.winningLotto.DuplicatedWinningNumberException;
import lotto.exception.winningLotto.InvalidRangeWinningNumberException;

public class WinningLotto {
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> winningNumber, Integer bonusNumber) {
        this.winningLotto = new Lotto(winningNumber);
        validateDuplicate(winningNumber, bonusNumber);
        validateBonusNumberInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberInRange(Integer bonusNumber) {
        if (bonusNumber <= 0 || bonusNumber > 45) {
            throw new InvalidRangeWinningNumberException();
        }
    }

    private void validateDuplicate(List<Integer> winningNumber, Integer bonusNumber) {
        Set<Integer> lottoNumbers = new HashSet<>(winningNumber);
        lottoNumbers.add(bonusNumber);
        if (lottoNumbers.size() != 7) {
            throw new DuplicatedWinningNumberException();
        }
    }

    public int countMatchingNumbers(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    public boolean isBonusMatched(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
