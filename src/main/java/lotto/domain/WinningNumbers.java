package lotto.domain;

import static lotto.constant.Constant.NUMBERS_RANGE_END;
import static lotto.constant.Constant.NUMBERS_RANGE_START;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ExceptionCode;
import lotto.exception.LottoException;

public class WinningNumbers {

    private final List<Integer> numbers;

    private final int bonusNumber;

    public WinningNumbers(List<Integer> inputNumbers, int bonusNumber) {
        this.numbers = inputNumbers;
        validateNumbers();

        this.bonusNumber = bonusNumber;
        validateBonusNumber();
    }

    private void validateNumbers() {
        validateSixNumbers();
        numbers.forEach(this::validateRange);
        validateDuplicated();
    }

    private void validateSixNumbers() {
        if (numbers.size() != 6) {
            throw new LottoException(ExceptionCode.NON_SIX_NUMBERS);
        }
    }

    private void validateRange(int number) {
        if (number < NUMBERS_RANGE_START || number > NUMBERS_RANGE_END) {
            throw new LottoException(ExceptionCode.OUT_OF_RANGE);
        }
    }

    private void validateDuplicated() {
        Set<Integer> validatedNumbers = new HashSet<>();

        for (Integer number : numbers) {
            if (!validatedNumbers.add(number)) {
                throw new LottoException(ExceptionCode.DUPICATED_ERROR);
            }
        }
    }

    private void validateBonusNumber() {
        validateBonusDuplicated();
        validateRange(bonusNumber);
    }

    private void validateBonusDuplicated() {
        if (numbers.contains(bonusNumber)) {
            throw new LottoException(ExceptionCode.DUPICATED_ERROR);
        }
    }

    public List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>(numbers);
        winningNumbers.add(bonusNumber);
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
