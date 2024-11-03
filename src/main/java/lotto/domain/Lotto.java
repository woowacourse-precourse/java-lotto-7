package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE.getMessage());
        }
    }

    // TODO: 추가 기능 구현

    private void checkDuplicateNumbers(List<Integer> numbers) {
        final Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        int count = 0;
        for (final Integer number : winningNumbers) {
            if (numbers.contains(number)) {
                ++count;
            }
        }
        return count;
    }
}
