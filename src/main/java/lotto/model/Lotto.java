package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplicatedNumber(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (isValidateNumberSize(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private boolean isValidateNumberSize(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 될 수 없습니다.");
        }
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
