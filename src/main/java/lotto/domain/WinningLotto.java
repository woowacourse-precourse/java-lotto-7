package lotto.domain;

import static lotto.domain.LottoConstants.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.DuplicatedWinningNumberException;
import lotto.exception.InvalidRangeLottoNumberException;

public class WinningLotto {
    private final static int FINAL_LOTTO_SIZE = LOTTO_SIZE.getValue() + 1;
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> winningNumber, Integer bonusNumber) {
        this.winningLotto = new Lotto(winningNumber);
        validateDuplicate(winningNumber, bonusNumber);
        validateBonusNumberInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberInRange(Integer bonusNumber) {
        if (bonusNumber < LOTTO_MIN_NUMBER.getValue() || bonusNumber > LOTTO_MAX_NUMBER.getValue()) {
            throw new InvalidRangeLottoNumberException();
        }
    }

    private void validateDuplicate(List<Integer> winningNumber, Integer bonusNumber) {
        Set<Integer> lottoNumbers = new HashSet<>(winningNumber);
        lottoNumbers.add(bonusNumber);
        if (lottoNumbers.size() != FINAL_LOTTO_SIZE) {
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
