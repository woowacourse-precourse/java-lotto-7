package lotto.model;

import lotto.Constants;
import lotto.ErrorMessages;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.Constants.*;
import static lotto.ErrorMessages.*;

public class WinningLotto {
    ;
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> winningLotto, Integer bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);
        validateBonusNumber(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> winningLotto, Integer bonusNumber) {
        validateDuplicate(winningLotto, bonusNumber);
        validateRange(bonusNumber);
    }

    private void validateDuplicate(List<Integer> winningLotto, Integer number) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(winningLotto);
        nonDuplicateNumbers.add(number);
        if (nonDuplicateNumbers.size() != WINNING_LOTTO_SIZE) {
            throw new IllegalArgumentException(WINNING_LOTTO_DUPLICATE);
        }
    }

    private void validateRange(Integer number) {
        if (!(MIN_NUMBER <= number && number <= MAX_NUMBER)) {
            throw new IllegalArgumentException(WINNING_LOTTO_RANGE_WRONG);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getNumbers() {
        return winningLotto.getNumbers();
    }

}
