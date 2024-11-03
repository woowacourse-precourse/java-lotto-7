package lotto.model;

import java.util.List;
import lotto.validator.LottoNumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumberValidator.validate(numbers);
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현
}
