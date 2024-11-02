package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 정수여야 합니다");
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if(nonDuplicateNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지않는 정수여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
