package lotto.domain.number;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.LottoValue;
import lotto.domain.LottoErrorTemplate;

public class WinningNumbers {

    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoValue.NUMBER_SIZE) {
            throw new IllegalArgumentException(
                    LottoErrorTemplate.INVALID_WINNING_NUMBER_SIZE.format(LottoValue.NUMBER_SIZE)
            );
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LottoErrorTemplate.DUPLICATE_WINNING_NUMBER.format());
        }
    }
}