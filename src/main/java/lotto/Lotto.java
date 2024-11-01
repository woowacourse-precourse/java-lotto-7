package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateWinningNumberRange(numbers);
        validateNoDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateWinningNumberRange(List<Integer> numbers) {
        boolean isValid = numbers.stream()
                .allMatch(number -> number >= 1
                        && number <= 45);
        if (!isValid) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateNoDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("당첨 번호는 6개의 서로 다른 숫자여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
