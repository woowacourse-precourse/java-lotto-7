package lotto.model;

import java.util.List;
import lotto.validator.LottoValidator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator validator = new LottoValidator();
        validator.numberCount(numbers);
        validator.duplicate(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
