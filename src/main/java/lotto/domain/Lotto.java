package lotto.domain;

import lotto.domain.vo.Number;
import java.util.List;

public class Lotto {
    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = convertIntegerToNumber(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    private List<Number> convertIntegerToNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(Number::newInstance)
                .toList();
    }
}
