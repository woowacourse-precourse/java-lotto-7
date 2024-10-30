package lotto.domain;

import java.util.List;
import lotto.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        LottoValidator.validateProcess(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
