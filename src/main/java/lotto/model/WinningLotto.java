package lotto.model;

import java.util.List;
import lotto.common.ErrorMessage;

public class WinningLotto {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> winNumbers;

    public WinningLotto(List<Integer> winNumbers) {
        List<Integer> newNumbers = winNumbers.stream().toList();
        validateSize(newNumbers);
        validateNumbersRange(newNumbers);
        validateDuplicateNumbers(newNumbers);
        this.winNumbers = newNumbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_MUST_SIX.getMessage());
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        numbers.stream().forEach(number -> validateNumberRange(number));
    }

    private void validateNumberRange(Integer number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        long distinctNumbersSize = numbers.stream().distinct().count();
        if (distinctNumbersSize != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DISTINCT.getMessage());
        }
    }

    public List<Integer> getWinNumbers() {
        return winNumbers.stream().toList();
    }
}
