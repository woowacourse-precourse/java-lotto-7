package lotto.domain;

import static lotto.constant.Constant.NUMBERS_MAX_COUNT;
import static lotto.constant.Constant.NUMBERS_RANGE_END;
import static lotto.constant.Constant.NUMBERS_RANGE_START;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ExceptionCode;
import lotto.exception.LottoException;

public class SixNumbers {

    private final List<Integer> numbers;

    public SixNumbers(List<Integer> inputNumbers) {
        this.numbers = inputNumbers;
        validateNumbers();
    }

    private void validateNumbers() {
        validateSixNumbers();
        validateRange();
        validateDuplicated();
    }

    private void validateSixNumbers() {
        if (numbers.size() != NUMBERS_MAX_COUNT) {
            throw new LottoException(ExceptionCode.NON_SIX_NUMBERS);
        }
    }

    private void validateRange() {
        boolean isRange = numbers.stream()
                .allMatch(number -> number >= NUMBERS_RANGE_START && number <= NUMBERS_RANGE_END);
        if (!isRange) {
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

    public List<Integer> getSixNumbers() {
        return numbers;
    }
}
