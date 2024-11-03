package lotto.Model;

import lotto.Validation.NumberValidation;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        NumberValidation.NumberNotDuplicate(numbers);
        NumberValidation.NumberRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> GetNumbers() {
        return numbers;
    }
}
