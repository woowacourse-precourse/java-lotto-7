package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbers(numbers);
        validateEachNumber(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalStateException("[ERROR] 번호 리스트가 유효하지 않습니다.");
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateEachNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number == null) {
                throw new NullPointerException("[ERROR] 번호가 유효하지 않습니다.");
            }
            if (!inRange(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 이상 45 이하의 정수여야 합니다.");
            }
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 각 번호는 서로 달라야 합니다.");
        }
    }

    private boolean inRange(int number) {
        return (number <= 45 && number >= 1);
    }
}
