package lotto.model;

import java.util.List;

import static lotto.constants.Constants.LOTTO_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호는 허용되지 않습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
