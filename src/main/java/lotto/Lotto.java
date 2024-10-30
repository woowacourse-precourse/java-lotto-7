package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateThereAreSixNumbers(numbers);
        validateMeetNumberRangeLimit(numbers);
        validateThereAreDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateThereAreSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateMeetNumberRangeLimit(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || 45 < number) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateThereAreDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> duplicateNumbers = new HashSet<>(numbers);
        if (duplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }
}
