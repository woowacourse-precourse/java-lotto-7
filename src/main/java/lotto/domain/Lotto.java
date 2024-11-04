package lotto.domain;

import static lotto.common.CollectionValidator.validateDuplicate;
import static lotto.common.CollectionValidator.validateSize;

import java.util.List;
import lotto.common.Displayable;

public class Lotto implements Displayable {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toPrettyString() {
        return numbers.stream()
                .sorted()
                .toList()
                .toString();
    }

    public int matchNumbers(List<Integer> winningNumbers) {
        return (int) this.numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean matchBonusNumber(Integer bonusNumber) {
        return this.numbers.stream()
                .anyMatch(winningNumber -> winningNumber == bonusNumber);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers, LOTTO_NUMBER_SIZE);
        validateDuplicate(numbers);
    }
}
