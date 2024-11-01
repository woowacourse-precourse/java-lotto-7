package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (numbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 숫자는 중복될 수 없습니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
