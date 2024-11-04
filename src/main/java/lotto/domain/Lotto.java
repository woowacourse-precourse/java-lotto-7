package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;

public record Lotto(List<Integer> numbers) {

    private static final int START_OF_RANGE = 1;
    private static final int END_OF_RANGE = 45;
    private static final int LOTTO_COUNT = 6;

    public Lotto {
        validateNumbers(numbers);
    }

    public int getMatchingCountWith(Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(otherLotto.numbers::contains)
                .count();
    }

    public boolean containsBonusNumber(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.bonusNumber());
    }

    private void validateNumbers(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicated(numbers);
        numbers.forEach(this::validateRange);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_COUNT_NOT_SIX.getMessage());
        }
    }

    private void validateRange(int number) {
        if (number < START_OF_RANGE || number > END_OF_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE_NOT_MATCH.getMessage());
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        Set<Integer> duplicateCheck = new HashSet<>(numbers);
        if (duplicateCheck.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_DUPLICATED.getMessage());
        }
    }
}
